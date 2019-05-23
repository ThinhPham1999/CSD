/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listdatastructures;

/**
 *
 * @author thinh
 */
public class Node {
    int info;
    Node next;

    public Node() {
    }

    public Node(int info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    Node(int x){
        this(x, null);
    }

    @Override
    public String toString() {
        return "Node.info: " + info ;
    }
    
    
}
