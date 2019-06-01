
package assigment01;

import Entity.*;
import LinkedList.MyList;

public class Assigment01 {

    public static void main(String[] args) {
        //demoCustomer();
        demoProduct();
    }
    
    public static void demoCustomer(){
        MyList<Customer>  listCustomer = new MyList<>();
        listCustomer.addToHead(new Customer("01", "Minh", "0905901"));
        listCustomer.addToTail(new Customer("02", "Nam", "901"));
        listCustomer.addToHead(new Customer("03", "Van", "090"));
        Customer result = listCustomer.search(new Customer("04", "", ""));
        System.out.println(result);
    } 
    public static void demoProduct(){
        MyList<Product> listProduct = new MyList<>();
        listProduct.addToHead(new Product("01", "Minh", 23, 6.2));
        listProduct.addToHead(new Product("05", "Nam", 23, 6.5));
        listProduct.addToHead(new Product("02", "Thinh", 30, 6.2));
        listProduct.addToHead(new Product("03", "Loc", 50, 10.2));
        listProduct.addToHead(new Product("06", "Thanh", 63, 69.2));
        listProduct.traverse();
        //listProduct.sort();
        //listProduct.traverse();
        //listProduct.addAfterPosition(1, new Product("09", "Ni", 2, 9));
        //listProduct.traverse();
        //System.out.println(listProduct.search(new Product("05", "", 0, 0)));
        //listProduct.traverse();
        listProduct.deleteAfterNode(new Product("05", "", 0, 0));
        listProduct.traverse();
    }
}
