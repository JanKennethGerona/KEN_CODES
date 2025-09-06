/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact9_gerona;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jkdgerona
 */
public class LabAct9_Gerona {
    
    public static int rowscalc(int[] row){
        int rowTotal = 0;
        for (int i=0; i<row.length; i++){
            rowTotal += row[i];
        }
        return rowTotal;
    }
    
    public static int[] columncalc(int table [][]){
        int[] columnTotal = new int [table.length];
        for (int s=0; s<table.length; s++){
             for (int p=0; p<table.length; p++){
                 columnTotal[s] += table [p][s];
             }
         } 
        return columnTotal;
    }
    
    public static int diag(int table [][]){
        int diagonal = 0;
        for (int k=0; k<table.length;k++){
            diagonal += table[k][k];
        }
        return diagonal;
    }
    
    
    
    public static int[] randomizerzz(int table[], int n){
        Random rand = new Random();
        for (int s=0; s<n; s++){ //storage
             
                 table[s] = (rand.nextInt((40/n), (80/n)));
             
         }
        return table;
    }
    
    
    public static int [][] scenarioB(int n, int sum[], int table[][]){
        for (int h=0; h<n; h++){
                 while (sum[h]<40 || sum[h]>60){
                         table [h]= randomizerzz(table[h], n);
                         sum[h]=rowscalc(table[h]);
                         
                     
                 }
    }
        return table;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        //TODO code application logic here
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        Random rand = new Random();
        int[][]table= new int [n][n];
        int[] rowsum = new int [n];
        int[] columnsum = new int [n];
        int diagonal;
        boolean comparerow = true;
        boolean comparecolumn = true;
        
        
        for (int s=0; s<n; s++){ //storage
             for (int p=0; p<n; p++){
                 table[s][p] = rand.nextInt(0,100);
             }
         }
        
        for (int i=0; i<n; i++){ //calculations
             rowsum[i]=rowscalc(table[i]);     
         }
         columnsum = columncalc(table);
         diagonal = diag(table);
         
         PrintWriter outFile = new PrintWriter("output.txt");
         outFile.printf("First Table\n ");
         for (int k = 0; k<n;k++){ //outfile
             for (int l =0; l<n;l++){
                 outFile.printf("-----");
             }
             outFile.printf("\n");
            for (int g = 0; g<n; g++){
                outFile.printf("| %02d ", table[k][g]);
            }
             outFile.printf("| %03d\n ", rowsum[k]);
         }
         for (int f =0; f<=n;f++){
             outFile.printf("____ ");
         }
         outFile.printf("\n");
         for (int t =0; t<n; t++){
             outFile.printf("  %03d", columnsum[t]);
         }
         outFile.printf("| %03d\n\n\n\n", diagonal);
        
        
             
        for (int h=0; h<n; h++){
             if (rowsum[h]<40 || rowsum[h]>60){
                 comparerow = false;
             }
             if (columnsum[h]<40 || columnsum[h]>60){
                 comparecolumn = false;
             }
         }
        
        if (comparerow == false){
            table = scenarioB(n, rowsum, table);
            comparerow = true;
        }
        
        if (comparecolumn == false){
            table = scenarioB(n, columnsum, table);
            comparecolumn = true;
        }
        
     
        
        for (int s=0; s<n; s++){ 
             for (int p=0; p<n; p++){
                 System.out.print(table[s][p] + " ");
             }
             System.out.println("\n");
         }
        
        for (int i=0; i<n; i++){ //calculations
             rowsum[i]=rowscalc(table[i]);     
         }
         columnsum = columncalc(table);
         diagonal = diag(table);
        
        for (int s=0; s<n; s++){
            System.out.print( rowsum[s] + " ");
        }
        System.out.println("\n");
        for (int s=0; s<n; s++){
            System.out.print( columnsum[s] + " ");
        }
        
       
         outFile.printf("Second Table\n ");
         for (int k = 0; k<n;k++){ //outfile
             for (int l =0; l<n;l++){
                 outFile.printf("-----");
             }
             outFile.printf("\n");
            for (int g = 0; g<n; g++){
                outFile.printf("| %02d ", table[k][g]);
            }
             outFile.printf("| %03d\n ", rowsum[k]);
         }
         for (int f =0; f<=n;f++){
             outFile.printf("____ ");
         }
         outFile.printf("\n");
         for (int t =0; t<n; t++){
             outFile.printf("  %03d", columnsum[t]);
         }
         outFile.printf("| %03d\n", diagonal);
         
         
         outFile.close();
         scanner.close();
    }
    }
    

