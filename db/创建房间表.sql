CREATE TABLE cashflow.room
(
		id INT UNSIGNED NOT NULL PRIMARY KEY auto_increment COMMENT '主键id',
		name VARCHAR(50) COMMENT '房间名称',
		code VARCHAR(50) COMMENT '房间号码',
		creator VARCHAR(50) COMMENT '创建人',
		created_date TIMESTAMP COMMENT '创建时间'
) COMMENT '房间对局表';

CREATE UNIQUE INDEX room_code_uidx on cashflow.room(code);
CREATE INDEX room_name_idx on cashflow.room(name);