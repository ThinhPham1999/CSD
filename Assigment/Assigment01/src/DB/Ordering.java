
package DB;

public class Ordering {
    public String pcode;
    public String ccode;
    public int quantity;

    public Ordering() {
    }

    public Ordering(String pcode, String ccode, int quantity) {
        this.pcode = pcode;
        this.ccode = ccode;
        this.quantity = quantity;
    }

    public String getPcode() {
        return pcode;
    }

    public String getCcode() {
        return ccode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
