
package DB;

public class Product {
    private String pcode;
    private String pro_name;
    private int saled;
    private double price;

    public Product() {
    }

    public Product(String pcode, String pro_name, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public int getSaled() {
        return saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "pcode=" + pcode + ", pro_name=" + pro_name + ", saled=" + saled + ", price=" + price + '}';
    }
    
    
}
