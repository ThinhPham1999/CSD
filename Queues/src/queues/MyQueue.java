
package queues;


public class MyQueue {

    protected Node head, tail;

    // Declear or clear listQueue
    public MyQueue() {
        head = tail = null;
    }

    // check Empty
    public boolean isEmpty() {
        return (head == null);
    }

    // return first element without moving it
    int front() throws Exception {
        if (isEmpty()) {
            throw new Exception();
        }
        return (head.info);
    }
    
    // Take the first element from the queue
    public int dequeue() throws Exception {
        if (isEmpty()){
            throw new Exception();
        }
        int x = head.info;
        head = head.next;

        if (head == null) {
            tail = null;
        }
        return (x);
    }

    // Put the element x at the end of the queue
    void enqueue(int x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }
    
    public void traverse(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.info + " ");
            currentNode = currentNode.next;
        }
    }
}
