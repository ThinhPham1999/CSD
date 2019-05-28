
package queues;


public class Node {
    public int info;

    public Node next;

    public Node(int x, Node p) {
        info = x;
        next = p;
    }

    public Node(int x) {
        this(x, null);
    }

    @Override
    public String toString() {
        return info + "";
    }
    
    
}
