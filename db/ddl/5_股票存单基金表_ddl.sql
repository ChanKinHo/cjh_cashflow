CREATE TABLE cashflow.stock
(
		id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id',
		rat_table_id INT COMMENT '对应老鼠表id',
		name VARCHAR(50) COMMENT '股票名称',
		total_count INT COMMENT '总股数',
		per_cost BIGINT COMMENT '每股成本',
		interest BIGINT COMMENT '利息/分红',
		created_date TIMESTAMP COMMENT '创建时间'
)ENGINE=INNODB COMMENT '股票存单基金表';