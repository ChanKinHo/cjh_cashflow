CREATE TABLE cashflow.player
(
		id INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '主键id',
		name VARCHAR(50) COMMENT '玩家名称',
		room_code VARCHAR(50) COMMENT '所在房间号',
		career VARCHAR(5) COMMENT '玩家职业',
		is_rich VARCHAR(2) DEFAULT '0' COMMENT '是否跳出老鼠圈, 1-yes, 0-no',
		created_date TIMESTAMP COMMENT '创建时间'
)ENGINE=INNODB COMMENT '玩家表';

CREATE UNIQUE INDEX player_room_code_uidx on cashflow.player(room_code);
CREATE INDEX player_name_idx ON cashflow.player(name);