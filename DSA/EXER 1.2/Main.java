/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication4;

import java.io.*;
import java.util.*;

/**
 *
 * @author jkdgerona
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        Scanner input = new Scanner( new File("C:\\Users\\jkdgerona\\Documents\\NetBeansProjects\\JavaApplication4\\src\\javaapplication4\\students.txt"));
        ArrayList<Student> students = new ArrayList<>();
        int[] tempGrades;
        String lastName, firstName, Course;
        double highestAverage = 0; int numFailing = 0;
        
        //Read the File
        while(input.hasNext()){
            tempGrades = new int[5];
            lastName = input.next();
            firstName = input.next();
            Course = input.next();
            for (int j = 0; j<5; j++){
                tempGrades[j] = input.nextInt();
            }
            students.add(new Student(lastName, firstName, Course, tempGrades));
        }
        
        //Scan for the highest average and count the number of students that has failing grades
        for (int i = 0; i < students.size(); i++) {
            if (highestAverage < students.get(i).average())
                highestAverage = students.get(i).average();
            
            if (students.get(i).hasFailingGrade())
                numFailing++;
        }
        
        //print the highest grades
        System.out.println("Highest WOHOOO!!!\n");
        for (int i = 0; i < students.size(); i++) {
            if (highestAverage == students.get(i).average()){
                students.get(i).print();
            }
        }
        
        //Print the number of students that has failing grades and display their details
        System.out.println("Number of Students that has Failing Grade(s): " + numFailing + "\n--------------------------------------------------");
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).hasFailingGrade()){
                students.get(i).print();
            }
        }    
        
        
            
         
    }
    
}
