/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact10_gerona;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author jkdgerona
 */
public class LabAct10_Gerona {
    
    public static int[][] spread (int [][] table,  int s, int p, int least){
        if (s + 1 < table.length-1) // Check if s+1 is within bounds
        table[s + 1][p] = least;
    if (s - 1 >= 0) // Check if s-1 is within bounds
        table[s - 1][p] = least;
    if (p + 1 < table.length-1) // Check if p+1 is within bounds
        table[s][p + 1] = least;
    if (p - 1 >= 0) // Check if p-1 is within bounds
        table[s][p - 1] = least;
    
    
    return table;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        // TODO code application logic here
        // TODO code application logic here
         Scanner inFile = new Scanner(new FileReader("table.txt"));
         int input = inFile.nextInt();
         int [][] table = new int [input][input];
         int [][] table2 = new int [input][input];
         int least = 100;
         boolean condition = true;
         int iteration = 1;
         
         for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 table[s][p] = inFile.nextInt();
                 table2[s][p] = table[s][p];
             }
         }
         
         PrintWriter outFile = new PrintWriter("output.txt");
         outFile.printf("Original\n ");
         for (int k = 0; k<input;k++){ //outfile
             for (int l =0; l<input;l++){
                 outFile.printf("-----");
             }
             outFile.printf("\n");
            for (int g = 0; g<input; g++){
                outFile.printf("| %02d ", table[k][g]);
            }
             outFile.printf("\n");
         }
         
         outFile.printf("\n");
         for (int t =0; t<input; t++){
             
         }
         
         
         for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                 if (table[s][p] < least){
                     least = table[s][p];
                 }
             }
         }
         while (condition == true){
         for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                 if (table[s][p] == least){
                     table2 = spread(table2, s, p, least);
                 }
             }
         }
         
        for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                     table[s][p] = table2[s][p];
             }
         }
        
        condition = false;
        for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                 if (table[s][p] != least){
                     condition = true;
                 }
             }
         }
         
         for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                 System.out.print(table[s][p]+" ");
                 }
             System.out.println("\n");
             }
             System.out.println("\n\n");
             
             outFile.printf("#%d iteration\n", iteration);
             for (int k = 0; k<input;k++){ //outfile
             for (int l =0; l<input;l++){
                 outFile.printf("-----");
             }
             outFile.printf("\n");
            for (int g = 0; g<input; g++){
                outFile.printf("| %02d ", table[k][g]);
            }
             outFile.printf("\n");
         }
         
         outFile.printf("\n");
         for (int t =0; t<input; t++){
             
         }
         
         iteration += 1;
    }
         
         
         inFile.close();
        outFile.close();
    }
}
