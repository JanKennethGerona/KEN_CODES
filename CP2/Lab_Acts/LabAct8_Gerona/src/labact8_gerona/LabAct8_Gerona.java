/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact8_gerona;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jkdgerona
 */
public class LabAct8_Gerona {
    
    public static int rowscalc(int[] row){
        int rowTotal = 0;
        for (int i=0; i<row.length; i++){
            System.out.printf("%-3d ", row[i]);
            rowTotal += row[i];
        }
        System.out.printf("%-3d \n", rowTotal);
        return rowTotal;
    }
    
    public static int[] columncalc(int table [][]){
        int[] columnTotal = new int [table.length];
        for (int s=0; s<table.length; s++){
             for (int p=0; p<table.length; p++){
                 columnTotal[s] += table [p][s];
             }
             
             System.out.printf("%-3d ", columnTotal[s]);
         } 
        return columnTotal;
    }
    
    public static int diag(int table [][]){
        int diagonal = 0;
        for (int k=0; k<table.length;k++){
            diagonal += table[k][k];
        }
        System.out.println(diagonal);
        return diagonal;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
         Scanner inFile = new Scanner(new FileReader("CP2\\Lab_Acts\\LabAct8_Gerona\\input.txt"));
         int input = inFile.nextInt();
       
         
         int [][] table = new int [input][input];
         int[] rowsum = new int [input];
         int[] columnsum = new int [input];
         int diagonal;
         
         for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 table[s][p] = inFile.nextInt();
             }
         }

         for (int i=0; i<input; i++){ //calculations
             rowsum[i]=rowscalc(table[i]);     
         }
         columnsum = columncalc(table);
         diagonal = diag(table);
         
         boolean compare = true; //comparison
         
         for (int h=0; h<input; h++){
             if (rowsum[h] != diagonal){
                 compare = false;
             }
             if (columnsum[h] != diagonal){
                 compare = false;
             }
         }
         
         if (compare == true){ //print result
             System.out.println("\nMagic Square detected!");
         }else{
             System.out.println("\nNo Magic Squares here!");
         }
         
         PrintWriter outFile = new PrintWriter("output.txt");
         outFile.printf(" ");
         for (int k = 0; k<input;k++){ //outfile
             for (int l =0; l<input;l++){
                 outFile.printf("-----");
             }
             outFile.printf("\n");
            for (int g = 0; g<input; g++){
                outFile.printf("| %02d ", table[k][g]);
            }
             outFile.printf("| %03d\n ", rowsum[k]);
         }
         for (int f =0; f<=input;f++){
             outFile.printf("____ ");
         }
         outFile.printf("\n");
         for (int t =0; t<input; t++){
             outFile.printf("  %03d", columnsum[t]);
         }
         outFile.printf("| %03d\n", diagonal);
         
         if (compare == true){ //print result
             outFile.printf("\nMagic Square detected!");
         }else{
             outFile.printf("\nNo Magic Squares here!");
         }
         
         
         inFile.close();
         outFile.close();
    }
    
}
