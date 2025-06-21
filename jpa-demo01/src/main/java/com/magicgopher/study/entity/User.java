package com.magicgopher.study.entity;

import jakarta.persistence.*;

/**
 * @Author: MagicGopher <gopher997@gmail.com>
 * @CreateDate: 2025-06-19 05:05:44
 * @Version: v1.0.1
 * @Description: 用户实体
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 这里设置主键由数据库自动生成，通常是自增长的。
    @Column(name = "id")
    private Long Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "age")
    private Integer Age;

    @Column(name = "sex")
    private String Sex;

    /**
     * 空参构造方法
     */
    public User() {
    }

    /**
     * 有参数构造方法
     * @param name 姓名
     * @param age 年龄
     * @param sex 性别
     */
    public User(String name, Integer age, String sex) {
        Name = name;
        Age = age;
        Sex = sex;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Sex='" + Sex + '\'' +
                '}';
    }
}
