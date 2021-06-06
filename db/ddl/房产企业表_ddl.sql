CREATE TABLE cashflow.estate_company
(
		id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id',
		rat_table_id INT COMMENT '对应老鼠表id',
		name VARCHAR(50) COMMENT '资产名称',
		down_payment BIGINT COMMENT '首付',
		total_cost BIGINT COMMENT '总成本',
		loan BIGINT COMMENT '资产贷款',
		month_cash_flow BIGINT COMMENT '月现金流',
		type VARCHAR(2) COMMENT '类型 1-房地产 2-企业',
		created_date TIMESTAMP COMMENT '创建时间'
)ENGINE=INNODB COMMENT '房产企业表';