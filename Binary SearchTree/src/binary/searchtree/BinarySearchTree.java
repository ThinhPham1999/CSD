
package binary.searchtree;


public class BinarySearchTree {

   
    public static void main(String[] args) {
        demo();
    }
    
    public static void demo(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(8);
        binaryTree.root.left = new Node(7);
        binaryTree.root.right = new Node(10);
        
        if (binaryTree.search(binaryTree.root, 8) != null){
            System.out.println("Found.");
        }
        binaryTree.insert(11);
        binaryTree.breadth();
        System.out.println("");
        System.out.println(binaryTree.countNode());
        binaryTree.deleteKey(8);
        binaryTree.breadth();
        //binaryTree.breadth();
    }
    
}
