CREATE TABLE cashflow.rat_table
(
		id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id',
		career VARCHAR(5) COMMENT '职业',
		player_id INT COMMENT '玩家id',
		is_init VARCHAR(2) DEFAULT '0' COMMENT '是否初始表 1-是 0-否',
		passive_income BIGINT COMMENT '被动收入',
		total_income BIGINT COMMENT '总收入',
		total_pay BIGINT COMMENT '总支出',
		month_cash_flow INT COMMENT '月现金流',
		salary BIGINT COMMENT '工资',
		pay_per_child BIGINT COMMENT '每个小孩支出',
		child_count INT DEFAULT 0 COMMENT '小孩个数',
		tax_pay BIGINT COMMENT '个人所得税支出',
		house_pay BIGINT COMMENT '房屋贷款支出',
		education_pay BIGINT COMMENT '教育贷款支出',
		car_pay BIGINT COMMENT '汽车贷款支出',
		credit_card_pay BIGINT COMMENT '信用卡支出',
		extra_pay BIGINT COMMENT '额外支出',
		other_pay BIGINT COMMENT '其他支出',
		children_pay BIGINT COMMENT '小孩支出',
		bank_pay BIGINT COMMENT '银行贷款支出',
		house_loan BIGINT COMMENT '住房贷款',
		education_loan BIGINT COMMENT '教育贷款',
		car_loan BIGINT COMMENT '汽车贷款',
		credit_card BIGINT COMMENT '信用卡透支',
		extra_debt BIGINT COMMENT '额外负债',
		bank_loan BIGINT COMMENT '银行贷款',
		bank_store BIGINT COMMENT '银行存款',
		created_date TIMESTAMP COMMENT '创建时间',
		updated_date TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB COMMENT '老鼠表';

CREATE UNIQUE INDEX rat_table_palyer_id_uidx ON cashflow.rat_table(player_id);
