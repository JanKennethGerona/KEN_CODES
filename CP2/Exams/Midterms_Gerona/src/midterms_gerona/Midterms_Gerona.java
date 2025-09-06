
package midterms_gerona;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jkdgerona
 */
public class Midterms_Gerona {
    
    public static int[][] spreadss (int [][] table,  int s, int p, int least, int input){
        
    Random rand = new Random();
    if (s + 1 <= table.length-1){ // Check if s+1 is within bounds
        table[s + 1][p] = rand.nextInt(2,8);}
    if (s - 1 >= 0 && table [s-1][p] != 0){ // Check if s-1 is within bounds
        table[s - 1][p] = rand.nextInt(2,8);}
    if (p + 1 <= table.length-1 && table [s][p+1] != 0){ // Check if p+1 is within bounds
        table[s][p + 1] = rand.nextInt(2,8);}
    if (p - 1 >= 0 && table [s][p-1] != 0){ // Check if p-1 is within bounds
        table[s][p - 1] = rand.nextInt(2,8);}
    return table;
    }
    
    
   
    public static int[][] spread(int[][] table, int s, int p, int least, int input) {
    if (s + 1 <= table.length - 1 && table[s + 1][p] != 0 && table[s + 1][p] != 9) {
        table[s + 1][p] = 1;
    }
    if (s - 1 >= 0 && table[s - 1][p] != 0 && table[s - 1][p] != 9) {
        table[s - 1][p] = 1;
    }
    if (p + 1 <= table.length - 1 && table[s][p + 1] != 0 && table[s][p + 1] != 9) {
        table[s][p + 1] = 1;
    }
    if (p - 1 >= 0 && table[s][p - 1] != 0 && table[s][p - 1] != 9) {
        table[s][p - 1] = 1;
    }
    return table;
}


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        // TODO code application logic here
        Scanner scanner = new Scanner (System.in);
        Random rand = new Random();
        int input = scanner.nextInt();
        int [][] table = new int [input][input];
        int [][] table2 = new int [input][input];
        int least = 1;
        boolean condition = true;
        int iteration = 1;
        
        for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 table[s][p] = table2[s][p] = rand.nextInt(2,8);
             }
         }
         
        table [0] [input-1] = 1;
        table2 [input/2][input/2] = table [input/2][input/2] = 9;
        
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
        
        
        for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 System.out.print(table[s][p] + " ");
             }
             System.out.println("\n");
         }
        
        
         while (condition == true){
         
         if (table2 [(input/2)+1][input/2]==1){
             System.out.println("anti digit, spread will stop");
             outFile.printf("anti digit detected, spread will stop\n");
             break;
         }
         if (table2 [(input/2)-1][input/2]==1){
             System.out.println("anti digit, spread will stop");
             outFile.printf("anti digit detected, spread will stop\n");
             break;
         }
         if (table2 [(input/2)][(input/2)+1]==1){
             System.out.println("anti digit, spread will stop");
             outFile.printf("anti digit detected, spread will stop\n");
             break;
         }
         if (table2 [(input/2)][(input/2)-1]==1){
             System.out.println("anti digit, spread will stop");
             outFile.printf("anti digit detected, spread will stop\n");
             break;
         }
         
         for (int s=0; s<input; s++){ //search
             for (int p=0; p<input; p++){
                 if (table[s][p] == least){
                     table2 = spread(table2, s, p, least, input);
                     table2[s][p] = 0;
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
                 if (table[s][p] != 0 && table[s][p] != 9){
                     condition = true;
                 }
             }
         }
        
        
        
        
        for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 System.out.print(table[s][p] + " ");
             }
             System.out.println("\n");
         }
        
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
    for (int s=0; s<input; s++){ //storage
             for (int p=0; p<input; p++){
                 if (table[s][p] == 1){
                     table[s][p] = rand.nextInt(2,8);
                 }
             }
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
         
    outFile.close();
    }
}


