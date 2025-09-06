/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skiplist;
import java.io.*;
import java.util.*;
/**
 *
 * @author jkdgerona
 */
public class UseIntSkipList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner data = new Scanner( new File("C:\\Users\\jkdgerona\\Documents\\NetBeansProjects\\skipList\\src\\skiplist\\data.txt"));
        Scanner searchvalue = new Scanner( new File("C:\\Users\\jkdgerona\\Documents\\NetBeansProjects\\skipList\\src\\skiplist\\searchvalue.txt"));
        IntSkipList list1 = new IntSkipList(4);
        IntSkipList list2 = new IntSkipList(5);
        IntSkipList list3 = new IntSkipList(6);
        IntSkipList list4 = new IntSkipList(7);
        ArrayList<Integer> search = new ArrayList<Integer>();
        int temp;
        while (data.hasNext()){
            temp = data.nextInt();
            list1.skipListInsert(temp);
            list2.skipListInsert(temp);
            list3.skipListInsert(temp);
            list4.skipListInsert(temp);
        }
        while(searchvalue.hasNext()) {
            search.add(searchvalue.nextInt());
        }
        System.out.println("USING 4 AS MAX LEVEL\n--------------------");
        for (int i = 0; i < search.size(); i++) {
            list1.skipListSearch(search.get(i));
        }
        System.out.println("\n\nUSING 5 AS MAX LEVEL\n--------------------");
        for (int i = 0; i < search.size(); i++) {
            list2.skipListSearch(search.get(i));
        }
        System.out.println("\n\nUSING 6 AS MAX LEVEL\n--------------------");
        for (int i = 0; i < search.size(); i++) {
            list3.skipListSearch(search.get(i));
        }
        System.out.println("\n\nUSING 7 AS MAX LEVEL\n--------------------");
        for (int i = 0; i < search.size(); i++) {
            list4.skipListSearch(search.get(i));
        }
    }
}
