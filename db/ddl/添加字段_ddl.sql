alter TABLE rat_table add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE estate_company add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE stock add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE rat_table add COLUMN player_name VARCHAR(50) COMMENT '玩家名称';

alter TABLE rat_table add COLUMN career_name VARCHAR(50) COMMENT '职业名称';

alter TABLE player add COLUMN career_name VARCHAR(50) COMMENT '职业名称';