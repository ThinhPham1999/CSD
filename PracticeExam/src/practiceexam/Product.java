
package practiceexam;

public class Product implements Comparable<Product>{
    private String ID;
    private String item;
    private int quantity;
    private int rate;

    public Product() {
    }

    public Product(String ID, String item, int quantity, int rate) {
        this.ID = ID;
        this.item = item;
        this.quantity = quantity;
        this.rate = rate;
    }

    public String getID() {
        return ID;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRate() {
        return rate;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        System.out.printf("%-10s%-20s%-10d%-10d\n", this.ID, this.item, this.quantity, this.rate);
        return "";
    }

    @Override
    public int compareTo(Product o) {
        return this.ID.compareToIgnoreCase(o.getID());
    }
    
    
}
