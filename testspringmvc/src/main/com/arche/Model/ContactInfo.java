package arche.Model;

/**
 * Created by ZhangGuozhao on 2017/9/11.
 */
public class ContactInfo {
    private String tel;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
