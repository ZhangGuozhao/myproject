package cn.itit123.springdemo3;

/**
 * Created by ZhangGuozhao on 2017/10/30.
 */
public class ITDragon {
    private Integer id;
    private String account;
    private String password;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "ITDragon [id=" + id + ", account=" + account + ", password="
                + password + "]";
    }
}
