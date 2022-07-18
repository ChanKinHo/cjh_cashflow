package com.house.mybatislearn;

import com.house.cjh_cashflow.learnbatis.dao.UserDao;
import com.house.cjh_cashflow.learnbatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class FirstCacheTest {

    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        String resource = "learnbatis/mybatis-config-test.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        factory = factoryBuilder.build(reader);
        sqlSession = factory.openSession();
    }

    @Test
    public void test1(){
        /**
         * 一级缓存命中场景，一、运行时参数相关
         */
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        /**
         * 命中一级缓存，条件1：sql相同，入参相同
         */
        User user = userDao.queryById(1L);
        User user1 = userDao.queryById(1L);
        System.out.println(user == user1); //true

        //sql相同，入参不同
        User user2 = userDao.queryById(1L);
        User user3 = userDao.queryById(2L);
        System.out.println(user2 == user3); //false

        /**
         * 命中一级缓存，条件2：相同的statementID
         * statementID不同，入参相同，即使sql相同，也不能命中一级缓存
         * 导致statementID不同主要有两种方式，一是接口相同，方法名不同；二是方法名相(不)同但接口名不同；接口指的是UserDao
         */
        //接口名相同，方法名不同导致statementID不同
        //statementID: com.house.cjh_cashflow.learnbatis.dao.UserDao.queryById
        User user4 = userDao.queryById(1L);
        //statementID: com.house.cjh_cashflow.learnbatis.dao.UserDao.queryById1
        User user5 = userDao.queryById1(1L);
        System.out.println(user4 == user5); //false

        /**
         * 命中一级缓存，条件3：sqlSession,会话必须相同，一级缓存也成为会话级缓存
         */
        User user6 = userDao.queryById(1L);
        //结果也true，因为userDao.queryById(1L)底层就是其sqlSession调用selectOne，满足sql相同，入参相同，statementID相同，sqlSession相同
        Object user7 = sqlSession.selectOne("com.house.cjh_cashflow.learnbatis.dao.UserDao.queryById", 1L);
        System.out.println(user6 == user7);

        /**
         * 命中一级缓存，条件4: 分页参数RowBounds 返回的范围必须相同
         */
        //RowBounds为mybatis自带的分页，如果RowBounds设置了查询的范围，那么即使和user6查出相同的对象也不能命中
        RowBounds rowBounds = new RowBounds(0,10);
        List<Object> users = sqlSession.selectList("com.house.cjh_cashflow.learnbatis.dao.UserDao.queryById", 1L, rowBounds);
        System.out.println(user6 == users.get(0)); //false

        //如果RowBounds用的是默认值则可以命中一级缓存，因为userDao.queryById底层的RowBounds也是默认值
        RowBounds defaultRowBounds = RowBounds.DEFAULT;
        List<Object> users1 = sqlSession.selectList("com.house.cjh_cashflow.learnbatis.dao.UserDao.queryById", 1L, defaultRowBounds);
        System.out.println(user6 == users1.get(0)); //true

    }

    @Test
    public void test2(){
        /**
         * 一级缓存命中场景，二、操作与配置相关
         */

        /**
         * 一级缓存命中条件1：不能手动清空缓存
         */
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.queryById(1L);
        sqlSession.clearCache();
        User user1 = userDao.queryById(1L);
        System.out.println(user == user1); //false

        /**
         * 一级缓存命中条件2：不能调用flushCache = Options.FlushCachePolicy.TRUE
         */
        //如果两次查询之前加入了设置清空缓存的查询，也会不命中
        User user2 = userDao.queryById(1L);
        userDao.queryById1(1L); // 设置了flushCache = Options.FlushCachePolicy.TRUE
        User user3 = userDao.queryById(1L);
        System.out.println(user2 == user3); //false

        /**
         * 一级缓存命中条件3: 不能执行update操作，即使update不是要查询的条目，这是mybatis为了保证数据一致性做出的妥协
         * 即使mapper里<update></update>标签写的是select语句也会清空缓存
         */
        User user4 = userDao.queryById(1L);
        userDao.updateById(2L, "鸡仔");
        User user5 = userDao.queryById(1L);
        System.out.println(user4 == user5); //false

        /**
         * 一级缓存命中条件4: 缓存作用域为SESSION,不被修改
         * 这个在mybatis-config配置文件中修改
         * <setting name="localCacheScope" value="STATEMENT"/>
         */
    }


}
