
package stacks;

import java.util.EmptyStackException;

public class MyStack {
    protected Node head;
    
    public MyStack(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void push(int x){
        head = new Node(x, head);
    }
    
    int top() throws EmptyStackException{
        if (isEmpty()) throw new EmptyStackException();
        return head.info;
    }
    
    public int pop() throws EmptyStackException{
        if (isEmpty()) throw new EmptyStackException();
        int x = head.info;
        head = head.next;
        return x;
    }
    
    public void traverse(){
        System.out.println("Display all values in the stack from the top to the bottom.");
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.info + " ");
            currentNode = currentNode.next;
        }
    } 
}
