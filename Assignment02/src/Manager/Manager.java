/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.TaxPayer;
import Tree.AVLBinaryTree;
import Tree.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author thinh
 */
public class Manager {

    public static int menu() {
        System.out.println("-------TAXPAYER MANAGER-------");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & insert data");
        System.out.println("3. In-order traverse");
        System.out.println("4. Pre-order traverse");
        System.out.println("5. Breath-first traverse");
        System.out.println("6. In-order traverse to file");
        System.out.println("7. Search by code");
        System.out.println("8. Delete by code by copying");
        System.out.println("9. Simple balancing (or AVL tree)");
        System.out.println("10. Count number of taxpayers");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputLimit(0, 10);
        return choice;
    }

    public static void loadFile(AVLBinaryTree<TaxPayer> list, String filepath) {
        String thisLine = null;
        try {
            FileReader fr = new FileReader("test.txt");

            // open input stream test.txt for reading purpose.
            BufferedReader br = new BufferedReader(fr);

            while ((thisLine = br.readLine()) != null) {
                String[] parts = thisLine.split("\\|");
                list.insertTo(new TaxPayer(parts[0].trim(), parts[1].trim(), Double.parseDouble(parts[3].trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void visit(Node<TaxPayer> p, FileWriter fw) throws IOException {
        fw.write(p.getInfo().getCode() + " | " + p.getInfo().getName() + " | "
                + p.getInfo().getIncome() + " | " + p.getInfo().getDeduct() + " | "
                + p.getInfo().getTax() + "\n");
    }
    
    private static void inOrderFile(Node<TaxPayer> p, FileWriter fw) throws IOException{
        if (p == null) {
            return;
        }
        inOrderFile(p.left, fw);
        visit(p, fw);
        inOrderFile(p.right, fw);
    }
    
    public static void writeFile(AVLBinaryTree<TaxPayer> list) throws IOException{
        FileWriter fw = new FileWriter("test.txt");
        inOrderFile(list.root, fw);
        fw.close();
    }
    
    public static void search(AVLBinaryTree<TaxPayer> list){
        System.out.print("Enter code want to find: ");
        String code = Validate.checkInputString();
        Node<TaxPayer> found = list.search(list.root, new TaxPayer(code, "", 0));
        if (found != null){
            System.out.println(found.getInfo());
        }else{
            System.out.println("Not found.");
        }
    }
    
    public static void delete(AVLBinaryTree<TaxPayer> list){
        System.out.print("Enter code want to delete: ");
        String code = Validate.checkInputString();
        Node<TaxPayer> found = list.search(list.root, new TaxPayer(code, "", 0));
        if (found != null){
            list.delete(found.getInfo());
            System.out.println("Delete sucessfull.");
        }else{
            System.out.println("Not found this code.");
        }
    }
        
}
