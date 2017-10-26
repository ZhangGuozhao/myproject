package com.testhibernate.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by ZhangGuozhao on 2017/9/26.
 */
@Entity
@Table(name = "t_test", schema = "testhiberante", catalog = "")
public class TTest {
    private String id;
    private String username;
    private String password;
    private String sex;

    @Id
    @Column(name = "id", nullable = false, length = 50)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = true, length = 30)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 30)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 10)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TTest tTest = (TTest) o;

        if (id != null ? !id.equals(tTest.id) : tTest.id != null) return false;
        if (username != null ? !username.equals(tTest.username) : tTest.username != null) return false;
        if (password != null ? !password.equals(tTest.password) : tTest.password != null) return false;
        if (sex != null ? !sex.equals(tTest.sex) : tTest.sex != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
}
