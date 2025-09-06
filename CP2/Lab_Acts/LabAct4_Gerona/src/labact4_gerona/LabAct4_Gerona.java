/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact4_gerona;
import java.util.Random;
import java.io.*;
import java.util.*;
/**
 *
 * @author jkdgerona
 */
public class LabAct4_Gerona {
    
    public static String correct (String subject){
        return String.valueOf(subject.substring(0, 1).toUpperCase() + subject.substring(1).toLowerCase());
    }
    
    public static String unibersity (String uni) {
        return String.valueOf(uni.substring(0,uni.indexOf("_")) + (" ").concat(uni.substring(uni.indexOf("y")+2, uni.indexOf("y")+3)).toUpperCase().concat(uni.substring(uni.indexOf("y")+3)));
    }

    public static String randomizer (String subject){
        Random random = new Random();
        return String.valueOf(subject + " " + random.nextInt(1000, 10000));
    }
    
    public static double highestGrade (double math, double progs, double robs){
        double highest = Math.max(Math.max(math, progs), robs);
        return highest;
    }
    
    public static double average (double math, double progs, double robs){
        double average = (math + progs + robs)/3;
        return average;
        
    }
    
    public static int reward (double average){
        int reward = (int)(Math.floor(average*1000));
        return reward;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        Scanner inFile = new Scanner(new FileReader("CP2\\Lab_Acts\\LabAct4_Gerona\\src\\labact4_gerona\\LabAct4.txt"));
        String person = inFile.next();
        String university = inFile.next();
        String math = (inFile.next());
        String programming = inFile.next();
        String robotics = inFile.next();
        double mathGrade = Math.abs(inFile.nextDouble());
        double progsGrade = Math.abs(inFile.nextDouble());
        double robsGrade = Math.abs(inFile.nextDouble());
        inFile.nextLine();
        String messenger = inFile.nextLine();
        double highest, average;
        int reward;
        
        person = correct (person);
        university = correct (university);
        university = unibersity (university);
        math = correct (math);
        math = randomizer (math);
        programming = correct (programming);
        programming = randomizer (programming);
        robotics = correct (robotics);
        robotics = randomizer (robotics);
        messenger = correct (messenger);
        highest = highestGrade(mathGrade, progsGrade, robsGrade);
        average = average (mathGrade, progsGrade, robsGrade);
        reward = reward (average);
        
        System.out.println("Randoms:");
        System.out.println(math);
        System.out.println(programming);
        System.out.println(robotics);
        
        PrintWriter outFile = new PrintWriter("CP2\\Lab_Acts\\LabAct4_Gerona\\src\\labact4_gerona\\output.txt");
        outFile.printf("Welcome Everyone!\n\nWe are honored to have Mr.%s of %s visit the school this semester. In his stay here, he took three classes: %s, %s, %s.\nHis highest grade between the subjects was %.2f with an overall average of %.2f. For this achievement he will be awarded P%,d by the president.\n\n\nYours Truly\n%s" 
             , person, university, math, programming, robotics, highest, average, reward, messenger);
        // TODO code application logic here
        inFile.close();
        outFile.close();
    }
    
}
