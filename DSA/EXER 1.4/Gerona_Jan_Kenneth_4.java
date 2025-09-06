/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author jkdgerona
 */
public class Gerona_Jan_Kenneth_4 {

    /**
     * @param args the command line arguments
     */
    
public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner input = new Scanner( new File("C:\\Users\\jkdgerona\\Documents\\NetBeansProjects\\linkedlist\\src\\linkedlist\\numbers.txt"));
        IntSLList nums = new IntSLList();
        char action;
        int temp;
        
        
        while(input.hasNext()){
            action = input.next().charAt(0); //read the action first
            switch(action){
                case 'a':                   //if action is 'a' add to the head 
                    temp = input.nextInt();
                    nums.addToHead(temp);
                    System.out.println(temp +" is added to the head");
                    break;
                case 'b':                    //if action is 'b' add to the tail 
                    temp = input.nextInt();
                    nums.addToTail(temp);
                    System.out.println(temp +" is added to the tail");
                        break;
                case 'c':                    //if action is 'c' delete from the head 
                    if (nums.isEmpty()){     //check if linked list is empty
                        System.out.println("Linked list is empty");
                        break;
                    }else{
                        System.out.println(nums.head.info + " was deleted");
                        nums.deleteFromHead();
                        break;
                    }
                case 'd':                    //if action is 'd' delete from the tail 
                    if (nums.isEmpty()){     //check if linked list is empty
                        System.out.println("Linked list is empty");
                        break;
                    }else{
                        System.out.println(nums.tail.info + " was deleted");
                        nums.deleteFromTail();
                        break;
                    }
                case 'e':                    //if action is 'e' find the given integer from the linked list and delete
                    try{
                        temp = input.nextInt();
                        if (nums.isEmpty()){
                            System.out.println("Linked list is empty");
                            break;
                        }
                        if (nums.isInList(temp)){
                            nums.delete(temp);
                            System.out.println(""+temp+" is deleted");
                        }else{
                            System.out.println("Number is not found");
                        }
                    }catch(InputMismatchException e){
                        System.out.println("Invalid input");
                    }
            }
            nums.printAll();
            System.out.println("\n");
        }
        
        //print the final linked list
        System.out.println("----------------------------------------------------\nintegers currently in the linked list:");
        nums.printAll();
        System.out.println();
    }
    
}