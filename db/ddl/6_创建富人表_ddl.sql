CREATE TABLE cashflow.rich_table
(
		id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id',
		player_id INT COMMENT '玩家id',
		room_code VARCHAR(50) COMMENT '房间号码',
		rich_cash_flow BIGINT COMMENT '现金流',
		created_date TIMESTAMP COMMENT '创建时间',
		updated_date TIMESTAMP COMMENT '更新时间'
)ENGINE=INNODB COMMENT '富人表';

CREATE UNIQUE INDEX rich_table_room_code_uidx ON cashflow.rich_table(room_code);