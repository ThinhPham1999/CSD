
package binary.searchtree;


public class BinarySearchTree {

   
    public static void main(String[] args) {
        demo();
    }
    
    public static void demo(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(60);
        binaryTree.root.left = new Node(70);
        binaryTree.root.right = new Node(80);
        //binaryTree.root.left.left = new Node(40);
        //binaryTree.root.left.right = new Node(55);
        
//        if (binaryTree.search(binaryTree.root, 8) != null){
//            System.out.println("Found.");
//        }
//        //binaryTree.insert(11);
//        //binaryTree.insert(30);
//        binaryTree.breadth();
//        System.out.println("");
//        System.out.println(binaryTree.countNode());
//        //binaryTree.deleteKey(8);
//        //binaryTree.breadth();
//        System.out.println(binaryTree.max());
//        System.out.println(binaryTree.min());
//        System.out.println(binaryTree.MaxPath());
        System.out.println(binaryTree.isAVL(binaryTree.root));
        System.out.println(binaryTree.isHeap());
        //binaryTree.breadth();
    }
    
}
