
package assignment02;

import Entity.TaxPayer;
import Tree.*;
import java.io.IOException;
import Manager.*;

public class Assignment02 {

    
    public static void main(String[] args) throws IOException {
        AVLBinaryTree<TaxPayer> list = new AVLBinaryTree<>();
        
//        list.insertTo(new TaxPayer("S010", "Nam", 5000));
//        list.insertTo(new TaxPayer("S020", "Van", 6500));
//        list.insertTo(new TaxPayer("S030", "Thinh", 7800));
//        list.insertTo(new TaxPayer("S040", "Nam", 9000));
//        list.insertTo(new TaxPayer("S050", "Van", 12000));
//        list.insertTo(new TaxPayer("S025", "Thinh", 3000));
//        list.insertTo(new TaxPayer("S007", "Thinh", -1));
//        list.insertTo(new TaxPayer("S008", "Thinh", 01));
//        list.insertTo(new TaxPayer("S009", "Thinh", 02));
//        list.delete(new TaxPayer("S010", "", 10));
        //list.insertTo(new TaxPayer("007", "Thinh", 10000));
        //System.out.println("S010".compareToIgnoreCase("S011"));
        //Manager.Manager.writeFile(list);
        Manager.loadFile(list, "test.txt");
        list.preOrder(list.root);
        System.out.println("");
        
        Manager.search(list);
        Manager.delete(list);
        
    }
    
}
