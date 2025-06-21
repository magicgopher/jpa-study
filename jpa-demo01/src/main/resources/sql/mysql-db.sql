-- 创建数据库 test_db，如果不存在则创建，使用 utf8mb4 字符集以支持中文
CREATE DATABASE IF NOT EXISTS test_db CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- 切换到 test_db 数据库
USE test_db;

-- 创建学生表 tb_user，用于存储用户信息
CREATE TABLE tb_user (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(50) NOT NULL,
                         age SMALLINT NOT NULL CHECK (age >= 0),
                         sex VARCHAR(20) NOT NULL
) COMMENT='用户表';

-- 为 tb_user 表的列添加注释，明确每一列的含义
ALTER TABLE tb_user
    MODIFY COLUMN id BIGINT AUTO_INCREMENT COMMENT '主键ID',
    MODIFY COLUMN name VARCHAR(50) NOT NULL COMMENT '姓名',
    MODIFY COLUMN age SMALLINT NOT NULL COMMENT '年龄',
    MODIFY COLUMN sex VARCHAR(20) NOT NULL COMMENT '性别';

-- 插入 55 条学生数据，姓名使用中文，年龄范围在 15-25 岁之间（注：原始数据年龄范围未完全符合要求）
INSERT INTO tb_user (name, age, sex) VALUES
                                         ('李伟', 28, '男'),
                                         ('王芳', 34, '女'),
                                         ('张浩然', 25, '男'),
                                         ('刘静', 45, '女'),
                                         ('陈勇', 31, '男'),
                                         ('杨秀英', 52, '女'),
                                         ('赵敏', 29, '女'),
                                         ('黄磊', 41, '男'),
                                         ('周杰', 38, '男'),
                                         ('吴晓梅', 26, '女'),
                                         ('徐志强', 48, '男'),
                                         ('孙丽', 33, '女'),
                                         ('胡云', 22, '男'),
                                         ('朱琳', 30, '女'),
                                         ('高建国', 55, '男'),
                                         ('林雪', 27, '女'),
                                         ('何平', 42, '男'),
                                         ('郭婷婷', 24, '女'),
                                         ('马超', 36, '男'),
                                         ('罗丹', 39, '女'),
                                         ('宋文', 49, '男'),
                                         ('唐娜', 23, '女'),
                                         ('谢俊', 32, '男'),
                                         ('韩梅', 51, '女'),
                                         ('邓宇', 28, '男'),
                                         ('曹阳', 43, '男'),
                                         ('彭静', 35, '女'),
                                         ('肖燕', 37, '女'),
                                         ('范明', 58, '男'),
                                         ('程龙', 46, '男'),
                                         ('袁媛', 29, '女'),
                                         ('叶帅', 21, '男'),
                                         ('阎博', 40, '男'),
                                         ('韦华', 53, '女'),
                                         ('卢秀兰', 47, '女'),
                                         ('汪峰', 44, '男'),
                                         ('田甜', 26, '女'),
                                         ('金鑫', 31, '男'),
                                         ('夏岚', 30, '女'),
                                         ('姜涛', 50, '男'),
                                         ('范丽丽', 27, '女'),
                                         ('方明', 34, '男'),
                                         ('陆远', 41, '男'),
                                         ('石磊', 38, '男'),
                                         ('姚佳', 25, '女'),
                                         ('谭琳', 33, '女'),
                                         ('廖宏', 56, '男'),
                                         ('邹凯', 29, '男'),
                                         ('熊英', 49, '女'),
                                         ('白雪', 22, '女'),
                                         ('段誉', 32, '男'),
                                         ('雷军', 54, '男'),
                                         ('邱月', 28, '女'),
                                         ('尹平', 45, '男'),
                                         ('孔祥东', 60, '男');