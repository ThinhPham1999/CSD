package binary.searchtree;

import java.lang.annotation.Target;

public class BinaryTree {

    Node root;

    //1. check tree is empty?
    boolean isEmpty() {
        return root == null;
    }

    //2. delete(or clear) the tree.
    void clear() {
        root = null;
    }

    //3. Search node having value x.
    // Return value if yes, null if not found.
    Node search(Node p, int x) {
        if (p == null) {
            return (null);
        }
        if (p.info == x) {
            return p;
        } else if (p.info < x) {
            return search(p.right, x);
        } else {
            return search(p.left, x);
        }
    }

    //4. insert value x to the tree
    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node p = root;
        Node pre = null;
        while (p != null) {
            if (p.info == x) {
                System.out.println("Value " + x + "is existed in tree.");
                return;
            }
            pre = p;
            if (x < p.info) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x < pre.info) {
            pre.left = new Node(x);
        } else {
            pre.right = new Node(x);
        }
    }

    //5. Traverse a tree.
    void breadth() {
        int h = height(root);

        System.out.println("Level Order Tree Traversal: ");
        for (int i = 1; i <= h; i++) {
            printLevel(root, i);
        }
    }

    // caculate height of binary tree
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        // count height in each subtree
        int lheight = height(root.left);
        int rheight = height(root.right);
        // return higher value
        if (lheight > rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    // print Node
    void printLevel(Node root, int level) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            System.out.print(root.info + " ");
        } else if (level > 1) {
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

    //6.Preoder
    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    private static void visit(Node p) {
        System.out.print(p.info + " ");
    }

    //7.Inorder
    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    //8.PostOrder
    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        inOrder(p.right);
        visit(p);
    }

    // Count leaf of tree
    int countLeaf(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return countLeaf(node.left) + countLeaf(node.right);
        }
    }

    //9. Count and return number of nodes in the tree
    int countNode() {
        if (root == null) {
            return 0;
        } else {
            return getSize(root);
        }
    }

    int getSize(Node p) {
        int count = 1;
        if (p.left != null) {
            count += getSize(p.left);
        }
        if (p.right != null) {
            count += getSize(p.right);
        }
        return count;
    }

    //10. delete a node having value x
    void deleteKey(int info) {
        root = deleteRec(root, info);
    }

    private static Node deleteRec(Node root, int info) {
        // if tree is empty
        if (root == null) {
            return root;
        }

        //find node have value x
        if (info < root.info) {
            deleteRec(root.left, info);
        } else if (info > root.info) {
            deleteRec(root.right, info);
        } else {
            //if found Node having value x
            // if Node have 1 or no subtrue;
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // if Node have 2 subtree
            // min value in right binary tree become root
            root.info = minRight(root.right);
            // delete Node become root
            root.right = deleteRec(root.right, root.info);
        }
        return root;
    }

    //find min value in right binary tree
    private static int minRight(Node root) {
        int min = root.info;
        while (root.left != null) {
            min = root.left.info;
            root = root.left;
        }
        return min;
    }

    //11. Find and return the node with minimum value in the tree.  
    Node min() {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    //12. Find and return the node with maximun value in the tree
    Node max() {
        if (isEmpty()) {
            return null;
        }
        Node p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }

    //13. Return the sum of all values in the tree.  
    int sum() {
        if (isEmpty()) {
            return 0;
        } else {
            return sumNode(root);
        }
    }

    int sumNode(Node p) {
        int count = p.info;
        if (p.left != null) {
            count += sumNode(p.left);
        }
        if (p.right != null) {
            count += sumNode(p.right);
        }
        return count;
    }

    //14. Return the average of all values in the tree.
    double avg() {
        if (isEmpty()) {
            return 0;
        } else {
            return sumNode(root) / getSize(root);
        }
    }

    //15. The height of a tree is the maximum number of  edges on a path from the root to a leaf node (thus the height of a tree with root only is 0).
    //Write a  function that returns the height of a binary tree.
    int heightOfTree() {
        return height(root) - 1;
    }

    //16. The cost of a path in a tree is sum of the keys of the nodes participating  in that path. 
    //Write a  function that returns the cost of the most expensive  path from the root to a leaf node.
    // it means find path have max value;
    static int maxPath = Integer.MIN_VALUE;
    static Node targetNode = null;

    int MaxPath() {
        if (isEmpty()) {
            return 0;
        }
        calculatePath(root, 0);
        return maxPath;
    }

    private static void calculatePath(Node node, int currentSum) {
        // when found leaf
        if (node == null) {
            return;
        }

        currentSum += node.info;
        if (maxPath < currentSum) {
            maxPath = currentSum;
            // take the current node(may be leaf)
            targetNode = node;
        }

        // find maxPath in left subtree and right subtree
        calculatePath(node.left, currentSum);
        calculatePath(node.right, currentSum);
    }

    //17. Write a  function to determine whether a given binary tree is AVL or not.
    // Tree is AVL is the tree which each node in tree has |heightleft - heightright| <= 1 
    boolean isAVL(Node root) {
        if (root == null) {
            return true;
        }
        // count height in each subtree
        int lheight = height(root.left);       
        int rheight = height(root.right);
        
        if (Math.abs(lheight - rheight) <= 1
                && isAVL(root.left)
                && isAVL(root.right)) {
            return true;
        }
        // not AVL 
        return false;
    }
    
    //19. Write a  function to determine whether a given binary tree is a heap.
    
}
