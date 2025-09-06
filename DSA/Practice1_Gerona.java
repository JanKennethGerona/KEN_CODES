/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testtesttest;
import java.util.*;
/**
 *
 * @author jkdgerona
 */
public class Testtesttest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        Random rand = new Random();
        int total, average, count;
        total = 0;
        count = 0;
        
        for (int i = 0; i < 100; i++){
            nums.add(rand.nextInt(1000));
            total += nums.get(i);
        }
        
        average = total/100;
        
        for (int i = 0; i<nums.size(); i++){
            if (nums.get(i) < average){
                count++;
            }
        }
        
        
        System.out.println(nums);
        System.out.println("Average                           : " + average);
        System.out.println("Count of numbers less than average: " + count);
    }
    
}
