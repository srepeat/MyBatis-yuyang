-- 创建用户表
CREATE TABLE t_user(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50)
)

SELECT * FROM t_user ORDER BY id DESC;

CREATE TABLE t_role(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(50)
)
INSERT INTO t_role(NAME) VALUES ('PM-项目经理'),('SE-软件工程师'),('PG-程序员'),('TL-组长'),('GL-组长'),
('QC-品质控制'),('SA-软件架构师'),('CMO/CMS-配置管理'),('SYSTEM-系统管理员');


DELETE FROM t_user_role WHERE userid = #{userid} and roleid in 
