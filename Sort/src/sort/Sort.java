/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

import java.util.ArrayList;

/**
 *
 * @author Thinh
 */
public class Sort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("A05", "Tran Quang", 7));
        list.add(new Employee("A03", "Nguyen An", 7));
        list.add(new Employee("A01", "Truong Phung", 5));
        list.add(new Employee("A04", "Pham Thi Lam", 2));
        list.add(new Employee("A02", "Do Trung Ton", 5));
        
//        BasicSort.selectSort(list);
        AdvancedSort.mergerSort(list, 0, list.size() - 1);
        AdvancedSort.print(list);
        
    }
    
}
