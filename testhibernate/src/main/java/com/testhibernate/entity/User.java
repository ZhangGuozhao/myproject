package com.testhibernate.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by ZhangGuozhao on 2017/9/25.
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
//   Integer类型做主键  自增  GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
//    private Long id;

//    下面用uuid做主键 String类型
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "username",length = 50)
    private String username;
    @Column(name = "password",length = 10)
    private String password;
    @Column(name = "sex",length = 10)
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
