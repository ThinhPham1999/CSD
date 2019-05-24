package singlylinkedlist;

import java.util.*;
import java.io.IOException;

public class SinglyLinkedList1 {

    class Node {

        int info;
        Node next;

        Node() {
        }

        Node(int x, Node p) {
            info = x;
            next = p;
        }
    }

    Node head, tail;

    SinglyLinkedList1() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void add(int x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    void traverse() {
        Node p = head;
        while (p != null) {
            System.out.print("  " + p.info);
            p = p.next;
        }
        System.out.println();
    }

    Node search(int x) {
        //Tìm và trả về phần tử có giá trị bằng x (info)
        Node p;
        p = null;
        return p;
    }

    void dele(int x) {
        //Xóa phần tử có giá trị bằng x (info)
    }

    int deleFromHead() {
        if (isEmpty()) {
            tail = null;
            return -1;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.info;
    }

    void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        Node new_node = new Node(x, null);
        new_node.next = p.next;
        p.next = new_node;
    }

    int findMax() {
        Node currentNode = head;
        int max = head.info;

        while (currentNode != null) {
            if (max < currentNode.info) {
                max = currentNode.info;
            }
            currentNode = currentNode.next;
        }
        return max;
    }
    
    public static void menu(){
        System.out.println("1. Max of the list. ");
        System.out.println("2. Delete from head.");
        System.out.println("3. Add a node with x value after the node p.");
        System.out.println("0. Exit.");
    }
    
    //----------------------------------------------------------
    public static void main(String[] args) {
        SinglyLinkedList1 L = new SinglyLinkedList1();
        int x;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a list of numbers: (Press zero to stop)");
        do {
            Scanner inp = new Scanner(System.in);
            x = inp.nextInt();
            if (x != 0) {
                L.add(x);
            }
        } while (x != 0);

        System.out.print("List of numbers: ");
        L.traverse();
        
        while(true){
            menu();
            System.out.print("Enter your choice(0 -> 3): ");
            int choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Exit.");
                    return;
                case 1:
                    System.out.print("Max of the list: ");
                    System.out.println(L.findMax());
                    break;
                case 2:
                    System.out.println("Delete from head");
                    L.deleFromHead();
                    System.out.println("New list.");
                    L.traverse();
                    break;
                case 3:
                    System.out.println("Add after");
                    System.out.print("Enter the value: ");
                    int value = sc.nextInt();
                    L.addAfter(L.head.next.next, value);
                    System.out.println("New list:");
                    L.traverse();
                    break;
                default:
                    System.out.println("Wrong. Enter again.");
                    break;
            }
        }
    }
}
