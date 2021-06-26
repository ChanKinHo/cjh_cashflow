alter TABLE rat_table add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE estate_company add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE estate_company add COLUMN rich_table_id int COMMENT '富人表id';

alter TABLE stock add COLUMN room_code VARCHAR(50) COMMENT '房间号码';

alter TABLE rat_table add COLUMN player_name VARCHAR(50) COMMENT '玩家名称';

alter TABLE rat_table add COLUMN career_name VARCHAR(50) COMMENT '职业名称';

alter TABLE player add COLUMN career_name VARCHAR(50) COMMENT '职业名称';

alter TABLE rich_table add COLUMN month_cash_flow bigint COMMENT '老鼠现金流';

alter TABLE rich_table add COLUMN player_name VARCHAR(50) COMMENT '玩家名称';

alter TABLE rich_table add COLUMN init_cash_flow bigint COMMENT '初始现金流';

alter TABLE rich_table add COLUMN win_cash_flow bigint COMMENT '获胜现金流';