import java.io.*;
import java.util.*;

/**
 *
 * @author jkdgerona
 */
public class BSTMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner input = new Scanner( new File("bst.txt"));
        BST tree = new BST();
        int temp;
        
        while(input.hasNext()){
            temp = input.nextInt();
            tree.insert(temp);
        }
        
        System.out.println("breadth-first:");
        tree.breadthFirst();
        System.out.println("\npre-order:");
        tree.preorder();
        System.out.println("\nin-order:");
        tree.inorder();
        System.out.println("\npost-order");
        tree.postorder();
        System.out.println("");
        tree.leaves();
        tree.height();
        
    }
    
    
}
