
package listdatastructures;

import java.util.Random;
import java.util.Scanner;

public class MyList {
    Node head, tail;
    Node sorted;
    
    void myList(){
        head = tail = null;
    }
    
    boolean isEmpty(){
        return (head == null);
    }
    
    void clear(){
        head = tail = null;
    }
    
    void addToHead(int x){
        if (isEmpty()){
            head = tail = new Node(x);
        }else
        {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
        }
    }
    
    void addToTail(int x){
        Node q = new Node(x);
        if (isEmpty()){
            head = tail = q;
        }else{
            tail.next = q;
            tail = q;
        }
    }
    
    void addAfter(Node p, int x){
        if(p == null){
            System.out.println("The given previous node cannot be null");
            return;
        }
        
        Node new_node = new Node(x);
        new_node.next = p.next;
        p.next = new_node;
    }
    
    void visit(Node p){
        Node currentNode = head;
        while (currentNode != p && currentNode != null){
            currentNode = currentNode.next;
        }
        if (currentNode == null){
            System.out.println("Not have node p");
        }
        System.out.println(currentNode);
    }
    
    void traverse(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode);
            currentNode = currentNode.next;
        }
        System.out.println("");
    }
    
    int deleFromHead(){
        if(isEmpty()){
            tail = null;
            return -1;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.info;
    }
    
    int deleFromTail(){
        if (head == null){
            return 0;
        }
        
        Node last = tail;
        Node second_last = head;
        while(second_last.next != last){
            second_last = second_last.next;
        }
        second_last.next = null;
        tail = second_last;
        return last.info;
    }
    
    int deleAfter(Node p){
        if (p == null){
            System.out.println("p is not null.");
            return 0;
        }
        Node currentNode = head;
        while (currentNode.next != p && currentNode.next != null){
            currentNode = currentNode.next;
        }
        Node deleted_Node = currentNode.next;
        currentNode.next = deleted_Node.next;
        return deleted_Node.info;
    }
    
    void dele(int x){
        if (head == null){
            System.out.println("The list is empty");
            return;
        }
        
        Node currentNode = head;
        Node pre_Node = new Node();
        
        //find the node previous of the the node want to delete
        while(currentNode.info != x && currentNode.next != null){
            pre_Node = currentNode;
            currentNode = currentNode.next;
        }
        
        if (currentNode.next == null){
            System.out.println("The given list does not have x value.");
            return;
        }
        pre_Node.next = currentNode.next;
    }
    
    Node search(int x){
        if (isEmpty()){
            System.out.println("The list is empty.");
        }
        boolean check = false;
        Node currentNode = head;
        while(currentNode != null){
            if (currentNode.info == x){
                check = true;
                break;
            }
            currentNode = currentNode.next;
        }
        
        if(!check){
            System.out.println("The given list does not have x value.");
            return null;
        }
        return currentNode;
    }
    
    int count(){
        int d = 0;
        Node currentNode = head;
        while (currentNode != null){
            d++;
            currentNode = currentNode.next;
        }
        return d;
    }
    
    void dele_position(int position){
        if(isEmpty()){
            System.out.println("The list is empty.");
        }
        
        Node currentNode = head;
        if (position == 0){
            head = currentNode.next;
            return;
        }
        // find previous poistion delete
        for (int i = 0; currentNode != null && i < position; i++){
            currentNode = currentNode.next;
        }
        // Not found position
        if (currentNode == null || currentNode.next == null){
            System.out.println("The given list does not have x position.");
        }
        
        Node next = currentNode.next.next;// Stored pointer the next need to delete
        currentNode.next = next; // Unlink the deleted from the list
    }
    
    void sort(){
        sorted = null;
        Node currentNode = head;
        
        while(currentNode != null){
            Node next = currentNode.next;
            sortInsert(currentNode);
            currentNode = next;
        }
        head = sorted;
    }
    
    void sortInsert(Node newNode){
        // Specail case for head end
        if (sorted == null || sorted.info >= newNode.info){
            newNode.next = sorted; 
            sorted = newNode; 
        }else
        {
            Node currentNode = sorted;
            /* Locate the node before the point of insertion */
            while (currentNode.next != null && currentNode.next.info < newNode.info)  
            { 
                currentNode = currentNode.next; 
            } 
            newNode.next = currentNode.next; 
            currentNode.next = newNode;            
        }
    }
    
    void dele(Node p){
        if (isEmpty()){
            System.out.println("List is empty");
            return;
        }
        
        Node currentNode = head;
        if (p == head){
            head = p.next;
            return;
        }
        Node pre_Node = new Node();
        boolean check = false;
        while (currentNode != null){
            if (currentNode == p){
                check = true;
                break;
            }
            pre_Node = currentNode;
            currentNode = currentNode.next;
        }
        
        if (!check){
            System.out.println("Not found node p.");
            return;
        }
        pre_Node.next = currentNode.next;
    }
    
    //14. info to new array integer type
    int[] toArray(int n){
        int[] item = new int[n];
        int i = 0;
        for (Node x = head; x != null; x = x.next){
            item[i++] = x.info;
        }
        return item;
    }
    
    void addBefore(Node p, int x){
        if (isEmpty()){
            System.out.println("The given list is empty");
            return;
        }
        
        Node currentNode = head;
        Node preNode = new Node();
        
        while(currentNode.info != p.info && currentNode != null){
            preNode = currentNode;
            currentNode = currentNode.next;
        }
        
        Node newNode = new Node(x);
        preNode.next = newNode;
        newNode.next = currentNode;
    }
    
    //18. find max info
    int findMax(){
        Node currentNode = head;
        int max = head.info;
        
        while(currentNode != null){
            if (max < currentNode.info){
                max = currentNode.info;
            }
            currentNode = currentNode.next;
        }
        return max;
    }
    
    int findMin(){
        Node currentNode = head;
        int min = head.info;
        
        while(currentNode != null){
            if (min > currentNode.info){
                min = currentNode.info;
            }
            currentNode = currentNode.next;
        }
        return min;
    }
    
    int findSum(){
        Node currentNode = head;
        int sum = 0;
        while(currentNode != null){
            sum += currentNode.info;
            currentNode = currentNode.next;
        }
        return sum;
    }
    
    double findAvg(){
        if (isEmpty()){
            System.out.println("The given list is empty");
            return -1;
        }
        int arg = 0;
        int count = 0;
        Node currentNode = head;
        while (currentNode != null){
            count++;
            arg = arg + currentNode.info;
            currentNode = currentNode.next;
        }
        return (double)arg / (double)count;
    }
    
    //1. Create the list
    void createList(int listCount){
        int val;
        Random rnd = new Random();
        
        for (int i = 0; i < listCount; i++){
            val = rnd.nextInt(listCount);
            addToTail(val);
        }
    }
    
    boolean sorted(){
        if (head == null || head.next == null){
            return true;
        }
        Node currentNode = head;
        while (currentNode.next != null){
            if (currentNode.info > currentNode.next.info){
                return false;
            }
            currentNode = currentNode.next;
        }
        return true;
    }
}
