/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practiceexam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Thinh
 */
public class PracticeExam {
    
    private static final Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create ArrayList has 5 elements
        ArrayList<Product> list = new ArrayList<>(); 
        add(list, "F01", "CPU", 10, 200);
        add(list, "F05", "Keyboard", 20, 15);
        add(list, "F03", "Mouse", 25, 10);
        add(list, "F02", "LCD", 30, 120);
        add(list, "F04", "USB", 15, 20);
//        traverse(list);
//        System.out.println("");
//        //BasicSort.selectSort(list);
//        //BasicSort.bubbleSort(list);
//        //BasicSort.insertionSort(list);
//        //AdvancedSort.quickSort(list, 5, 0, 4);
//        //AdvancedSort.heapSort(list);
//        AdvancedSort.mergerSort(list, 0, 4);
//        traverse(list);
//        search(list, "CPU");
//        search(list, "Head Phone");
        while (true){
            int choice = menu();
            switch(choice){
                case 1:
                    System.out.print("Enter ID: ");
                    String ID = sc.nextLine();
                    System.out.print("Enter item: ");
                    String item = sc.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine().trim());
                    System.out.print("Enter rate: ");
                    int rate = Integer.parseInt(sc.nextLine().trim());
                    add(list, ID, item, choice, choice);
                    break;
                case 2:
                    traverse(list);
                    System.out.println("");
                    break;
                case 3:
                    System.out.print("Enter item want to search: ");
                    String searchItem = sc.nextLine().trim();
                    search(list, searchItem);
                    break;
                case 4:
                    BasicSort.insertionSort(list);
                    break;
                case 5: 
                    BasicSort.selectSort(list);
                    break;
                case 6: 
                    BasicSort.bubbleSort(list);
                    break;
                case 7: 
                    AdvancedSort.quickSort(list, list.size(), 0, list.size() - 1);
                    break;
                case 8: 
                    AdvancedSort.mergerSort(list, 0, list.size() - 1);
                    break;
                case 9: 
                    AdvancedSort.heapSort(list);
                    break;
                case 0:
                    return;
            }
        }
    }
    
    public static void add(ArrayList<Product> list, String ID, String item, int quatity, int rate){
        Product new_Product = new Product(ID, item, quatity, rate);
        list.add(new_Product);
    }
    
    public static void traverse(ArrayList<Product> list){
        for (Product pro: list){
            System.out.print(pro);
        }
    }
    
    public static Product search(ArrayList<Product> list, String name){
        for (Product pro:list){
            if (pro.getItem().equalsIgnoreCase(name)){
                System.out.println(name + " FOUND");
                return pro;
            }
        }
        System.out.println(name + " NOT FOUND");
        return null;
    }
    
    public static int menu(){
        System.out.println("-----PRODUCT MANAGER-----");
        System.out.println("1. Add item");
        System.out.println("2. Print all items");
        System.out.println("3. Search");
        System.out.println("4. Insertion Sort");
        System.out.println("5. Seletion Sort");
        System.out.println("6. Bubble Sort");
        System.out.println("7. Quick sort");
        System.out.println("8. Merge Sort");
        System.out.println("9. Heap Sort");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine().trim());
        return choice;
    }
}
