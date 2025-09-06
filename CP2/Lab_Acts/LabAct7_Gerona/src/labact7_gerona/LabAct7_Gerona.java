/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact7_gerona;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author jkdgerona
 */
public class LabAct7_Gerona {
    
    
    public static String propercase (String subject){
        return String.valueOf(subject.substring(0, 1).toUpperCase() + subject.substring(1).toLowerCase());
    }
    
    public static String lettergrade(int grade){
        if (grade>=92){
            return("A");
        }else if(grade<92&&grade>87){
            return("B+");
        }else if (grade<88&&grade>83){
            return("B");
        }else if (grade<84&&grade>79){
           return("C+");
        }else if (grade<80&&grade>75){
            return("C");
        }else if (grade<76&&grade>71){
            return("D");
        }else if(grade<72&&grade>0){
            return("F");
        }else{
            return("Invalid");
        }
    }
    
    public static double qpicalc(double grade){
        if (grade>=92){
            return 4.0;
        }else if(grade<92&&grade>87){
            return 3.5;
        }else if (grade<88&&grade>83){
            return 3.0;
        }else if (grade<84&&grade>79){
           return 2.5;
        }else if (grade<80&&grade>75){
            return 2.0;
        }else if (grade<76&&grade>71){
            return 1.0;
        }else if(grade<72&&grade>0){
            return 0;
        }else{
            return -1;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        // TODO code application logic here
        Scanner inFile = new Scanner(new FileReader("input.txt"));
        String name = inFile.next();
        int[][] grades= new int [5][3];
        String [] subjects = new String [5];
        double[] finalgrades = new double[5];
        String[] lettergrades = new String[5];
        double[] qpi = new double [5];
        double average;
        double avQPI;
        
        name = propercase(name.substring(0, name.indexOf("_"))).concat(" ").concat(propercase(name.substring(name.indexOf("_") + 1)));
        
        for (int i=0; i<=4; i++){
            subjects[i]=inFile.next();
            
            for (int j=0; j<=2; j++){
                grades[i][j] = inFile.nextInt();
                finalgrades[i] = (finalgrades[i]+grades[i][j]);
                }
            finalgrades[i] = finalgrades[i]/3;
            lettergrades[i] = lettergrade((int)finalgrades[i]);
            qpi[i] = qpicalc(finalgrades[i]);
            }
        for (int h =0; h<=4;h++){
            subjects[h]= propercase(subjects[h]);
        }
        
        average = (finalgrades[0]+finalgrades[1]+finalgrades[2]+finalgrades[3]+finalgrades[4])/5;
        avQPI = qpicalc((int)average);

        
            System.out.println(name);
            System.out.println(finalgrades[4]);
            System.out.println(lettergrades[4]);
            System.out.println(qpi[4]);
            System.out.println(avQPI);

        
        
        PrintWriter outFile = new PrintWriter("output.txt");
        outFile.printf("Grade Report\nName: %s\nSubject\t\t\tPre\t Mid\t PrF\t  Fin\t  LGr\t  QPI\n"
                + "%-12s\t\t%4d\t%4d\t%4d\t%-4.2f\t%4s\t%4.1f\n"
                + "%-12s\t\t%4d\t%4d\t%4d\t%-4.2f\t%4s\t%4.1f\n"
                + "%-12s\t\t%4d\t%4d\t%4d\t%-4.2f\t%4s\t%4.1f\n"
                + "%-12s\t\t%4d\t%4d\t%4d\t%-4.2f\t%4s\t%4.1f\n"
                + "%-12s\t\t%4d\t%4d\t%4d\t%-4.2f\t%4s\t%4.1f\n"
                + "-----------------------------------------------------------------------\n"
                + "Final QPI: %.2f", name, subjects[0], grades[0][0],grades[0][1],grades[0][2], finalgrades[0], lettergrades[0], qpi[0], 
                subjects[1], grades[1][0],grades[1][1],grades[1][2], finalgrades[1], lettergrades[1], qpi[1], 
                subjects[2], grades[2][0],grades[2][1],grades[2][2], finalgrades[2], lettergrades[2], qpi[2], 
                subjects[3], grades[3][0],grades[3][1],grades[3][2], finalgrades[3], lettergrades[3], qpi[3], 
                subjects[4], grades[4][0],grades[4][1],grades[4][2], finalgrades[4], lettergrades[4], qpi[4], avQPI);
        
        inFile.close();
        outFile.close();
    
    }
    
}
    

