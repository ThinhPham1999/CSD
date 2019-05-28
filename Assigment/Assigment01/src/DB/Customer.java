
package DB;

public class Customer {
    private String ccode;
    private String cus_name;
    private String phone;

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getCcode() {
        return ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", cus_name=" + cus_name + ", phone=" + phone + '}';
    }
    
    
}
