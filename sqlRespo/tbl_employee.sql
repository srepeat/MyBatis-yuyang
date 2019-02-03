-- 员工表
CREATE TABLE tbl_employee(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
last_name VARCHAR(255),
gender CHAR(1),
email VARCHAR(255)
);

SELECT * FROM tbl_employee WHERE id = 1;


-- 部门表
CREATE TABLE tbl_dept(
id INT(11) PRIMARY KEY AUTO_INCREMENT,
dept_name VARCHAR(255)
)

-- 增加列
ALTER TABLE tbl_employee ADD COLUMN d_id INT(11);

ALTER TABLE tbl_employee ADD COLUMN enumStart VARCHAR(50);

-- 增加主外键关系
ALTER TABLE tbl_employee ADD CONSTRAINT fk_emp_dept FOREIGN KEY(d_id) REFERENCES tbl_dept(id)

-- 关联查询表
SELECT e.id id,e.last_name lastName,e.gender sex,e.email email ,e.d_id d_id,d.id did,d.dept_name nameDept FROM tbl_employee e,tbl_dept d WHERE e.d_id = d.id  
AND e.id = 1
e.d_id = d.id 
e.id = d.id 


-- 连表查询  用部门的id与员工外键的id等于，通过部门id查询员工id
SELECT d.id did,d.dept_name dept_name,
	e.id eid,e.last_name last_name,e.gender gender,e.email email
FROM tbl_dept d LEFT JOIN tbl_employee e ON d.id = e.d_id WHERE d.id=1


SELECT * FROM tbl_employee WHERE id IN (1,2,4)


-- 分表查询，mybatis的分布查询可以开启懒加载
SELECT * FROM tbl_dept WHERE id = 1
SELECT * FROM tbl_employee WHERE id = 832
-- 求数量
SELECT COUNT(id)AS id_nums FROM tbl_employee
-- 平均值
SELECT AVG(id) AS SUM FROM tbl_employee;


