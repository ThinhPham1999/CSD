package binary.searchtree;

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
    int height(Node root) {
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

    static void visit(Node p) {
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

    Node deleteRec(Node root, int info) {
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
    int minRight(Node root) {
        int min = root.info;
        while (root.left != null) {
            min = root.left.info;
            root = root.left;
        }
        return min;
    }
}
