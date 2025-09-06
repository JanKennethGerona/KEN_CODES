import java.util.*;
/**
 *
 * @author jkdgerona
 */
public class BST {

    protected BSTNode root;

    public BST() {
        root = null;
    }

    protected void visit(BSTNode p) {
        System.out.print(p.key + " ");
    }

    public BSTNode search(BSTNode p, int el) {
        while (p != null) {
            if (el == p.key) {
                return p;
            } else if (el < p.key) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void breadthFirst() {
        BSTNode p = root;
        Queue<BSTNode> queue = new LinkedList<>();
        if (p != null) {
            queue.add(p);
            while (!queue.isEmpty()) {
                p = (BSTNode) queue.remove();
                visit(p);
                if (p.left != null) {
                    queue.add(p.left);
                }
                if (p.right != null) {
                    queue.add(p.right);
                }
            }
        }
    }

    public void preorder() {
        preorder(root);
    }

    public void inorder() {
        inorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    protected void preorder(BSTNode p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }

    protected void inorder(BSTNode p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }

    protected void postorder(BSTNode p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }

    public void iterativePreorder() {
        BSTNode p = root;
        Stack travStack = new Stack();
        if (p != null) {
            travStack.push(p);
            while (!travStack.isEmpty()) {
                p = (BSTNode) travStack.pop();
                visit(p);
                if (p.right != null) {
                    travStack.push(p.right);
                }
                if (p.left != null) // left child pushed after right
                {
                    travStack.push(p.left);// to be on the top of the 
                }// stack;
            }
        }
    }

    public void iterativeInorder() {
        BSTNode p = root;
        Stack travStack = new Stack();
        while (p != null) {
            while (p != null) { // stack the right child (if any)
                if (p.right != null) // and the node itself when going
                {
                    travStack.push(p.right); // to the left;
                }
                travStack.push(p);
                p = p.left;
            }
            p = (BSTNode) travStack.pop();// pop a node with no left child
            while (!travStack.isEmpty() && p.right == null) {// visit it and all
                visit(p); // nodes with no right child;
                p = (BSTNode) travStack.pop();
            }
            visit(p); // visit also the first node with
            if (!travStack.isEmpty()) // a right child (if any);
            {
                p = (BSTNode) travStack.pop();
            } else {
                p = null;
            }
        }
    }


    public void MorrisInorder() {
        BSTNode p = root;
        BSTNode tmp;
        while (p != null) {
            if (p.left == null) {
                visit(p);
                p = p.right;
            } else {
                tmp = p.left;
                while (tmp.right != null
                        && // go to the rightmost node of
                        tmp.right != p) // the left subtree or
                {
                    tmp = tmp.right; // to the temporary parent of p;
                }
                if (tmp.right == null) {// if 'true' rightmost node was
                    tmp.right = p; // reached, make it a temporary
                    p = p.left; // parent of the current root,
                } else { // else a temporary parent has been
                    visit(p); // found; visit node p and then cut
                    tmp.right = null; // the right pointer of the current
                    p = p.right; // parent, whereby it ceases to be
                } // a parent;
            }
        }
    }

    public void insert(int el) {
        BSTNode p = root;
        BSTNode prev = null;
        while (p != null) { // find a place for inserting new node;
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        if (root == null) // tree is empty;
        {
            root = new BSTNode(el);
        } else if (prev.key < el) {
            prev.right = new BSTNode(el);
        } else {
            prev.left = new BSTNode(el);
        }
    }

    public void deleteByMerging(int el) {
        BSTNode tmp;
        BSTNode node;
        BSTNode p = root, prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child: its left
            {
                node = node.left; // child (if any) is attached to its 
            }// parent;
            else if (node.left == null) // node has no left child: its right
            {
                node = node.right; // child is attached to its parent;
            } else { // be ready for merging subtrees;
                tmp = node.left; // 1. move left
                while (tmp.right != null) // 2. and then right as far as
                {
                    tmp = tmp.right; // possible;
                }
                tmp.right
                        = // 3. establish the link between
                        node.right; // the rightmost node of the left
// subtree and the right subtree;
                node = node.left; // 4
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node; // 5.
            }
        } else if (root != null) {
            System.out.println("key " + el + " is not in the tree");
        } else {
            System.out.println("the tree is empty");
        }
    }

    public void deleteByCopying(int el) {
        BSTNode node;
        BSTNode p = root;
        BSTNode prev = null;
        while (p != null && p.key != el) { // find the node p
            prev = p; // with element el;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) // node has no right child;
            {
                node = node.left;
            } else if (node.left == null) // no left child for node;
            {
                node = node.right;
            } else {
                BSTNode tmp = node.left; // node has both children;
                BSTNode previous = node; // 1.
                while (tmp.right != null) { // 2. find the rightmost
                    previous = tmp; // position in the
                    tmp = tmp.right; // left subtree of node;
                }
                node.key = tmp.key; // 3. overwrite the reference 
// of the key being deleted;
                if (previous == node) // if node's left child's
                {
                    previous.left = tmp.left; // right subtree is null;
                } else {
                    previous.right = tmp.left; // 4.
                }
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("key " + el + " is not in the tree");
        } else {
            System.out.println("the tree is empty");
        }
    }
    
    public void leaves (){
        System.out.println("leaves:");
        System.out.println(countLeaves(root));
    }
    
   private int countLeaves(BSTNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }
   
   public void height() {
        System.out.println("height:");
        System.out.println(height(root));
    }

    
    private int height(BSTNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
