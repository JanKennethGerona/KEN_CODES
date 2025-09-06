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
        Scanner search = new Scanner( new File("search.txt"));
        BST tree = new BST();
        ArrayList<Integer> searchNums = new ArrayList<Integer>();
        int temp;
        
        try{
        while(input.hasNext()){
            temp = input.nextInt();
            tree.insert(temp);
        }
        
        while(search.hasNext()){
            searchNums.add(search.nextInt());
        }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < searchNums.size(); i++) {
            tree.searchAndMoveToRoot(searchNums.get(i));
        }
        tree.breadthFirst();
        tree.averagePathLength();
        
        input = new Scanner( new File("bst.txt"));
        tree = new BST();
        try{
        while(input.hasNext()){
            temp = input.nextInt();
            tree.insert(temp);
        }
        
        } catch (Exception e){
            System.out.println("error");
        }
        for (int i = 0; i < searchNums.size(); i++) {
            tree.splay(searchNums.get(i));
        }

        tree.breadthFirst();
        tree.averagePathLength();
    }
    
    
}
