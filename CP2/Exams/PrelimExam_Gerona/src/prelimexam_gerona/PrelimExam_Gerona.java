/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prelimexam_gerona;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jkdgerona
 */
public class PrelimExam_Gerona {
    
    public static String correct (String subject){
        return String.valueOf(subject.substring(0, 1).toUpperCase() + subject.substring(1).toLowerCase());
    }
    
    public static double totalProfit (double totalguest){
        double profit = (totalguest*300);
        profit = profit*0.8;
        return profit;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        // TODO code application logic here
        Scanner inFile = new Scanner(new FileReader("C:\\Users\\jkdgerona\\Desktop\\labacts\\5\\PrelimExam_Gerona\\src\\prelimexam_gerona\\record.txt"));
        String hotelName = inFile.next();
        String addressName = inFile.next();
        String addressNumber = inFile.next();
        String number = inFile.next();
        String date = inFile.next();
        String room1Name = inFile.next();
        String room1Time = inFile.next();
        String room2Name = inFile.next();
        String room2Time = inFile.next();
        String room3Name = inFile.next();
        String room3Time= inFile.next();
        String room4Name = inFile.next();
        String room4Time = inFile.next();
        
        hotelName = correct(hotelName.substring(0, hotelName.indexOf("_"))).concat(" ").concat(correct(hotelName.substring(hotelName.indexOf("_") + 1, hotelName.indexOf("_") + 8)))
                .concat(" ").concat(correct(hotelName.substring(hotelName.indexOf("_") + 9)));
        String addressComplete = correct(addressName.substring(0, addressName.indexOf("_"))).concat(" ").concat(correct(addressName.substring(addressName.indexOf("_") + 1)))
                                .concat(", ").concat(addressNumber);
        
        String welcome = ("Welcome to " + hotelName + "!"); 
        JOptionPane.showMessageDialog(null, welcome);
        String userName = (JOptionPane.showInputDialog("UserName: "));
        String room5Name = (JOptionPane.showInputDialog("Room Booked: "));
        int room5Guest = Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Number of Guests: ")));
        String room5Time = (JOptionPane.showInputDialog("Duration of Stay: "));
        String end = ("New entry has been recorded. Thank you for visiting " + hotelName + "!");
        JOptionPane.showMessageDialog(null, end);
        number = number.replace('_', ' ');
        date = date.replace('_', '/');
        
        room1Name = correct(room1Name);
        room2Name = correct(room2Name);
        room3Name = correct(room3Name);
        room4Name = correct(room4Name);
        room5Name = correct(room5Name);
        
        Random random = new Random();        
        int room1Guest = random.nextInt(1, 10);
        int room2Guest = random.nextInt(1, 10);
        int room3Guest = random.nextInt(1, 10);
        int room4Guest = random.nextInt(1, 10);
        
        double room1Profit = room1Guest*300;
        double room2Profit = room2Guest*300;
        double room3Profit = room3Guest*300;
        double room4Profit = room4Guest*300;
        double room5Profit = room5Guest*300;
        int totalGuest = (room1Guest + room2Guest + room3Guest + room4Guest + room5Guest);
        double totalProfit = totalProfit(totalGuest);
        
        PrintWriter outFile = new PrintWriter("C:\\Users\\jkdgerona\\Desktop\\labacts\\5\\PrelimExam_Gerona\\src\\prelimexam_gerona\\transcipt.txt");
        outFile.printf("%s\n%s\n%s\n\nHotel Booking Record - %s\n"
                        + "*****************************************************************\n"
                + "Room\t\tParty\t\t  Duration\t\t Profit\n"
                + "%s\t\t %d\t\t%11s\t\t%,8.2f\n"
                + "%s\t\t %d\t\t%11s\t\t%,8.2f\n"
                + "%s\t\t %d\t\t%11s\t\t%,8.2f\n"
                + "%s\t\t %d\t\t%11s\t\t%,8.2f\n"
                + "%s\t\t %d\t\t%11s\t\t%,8.2f\n"
                + "*****************************************************************\n\n"
                + "No. of Guests:\t\t\t%d\n"
                + "Total Earned: \t\t\t%,.2f\n"
                + "Updated by %s", hotelName, addressComplete, number, date, room1Name, room1Guest, room1Time, room1Profit, room2Name, room2Guest, room2Time, room2Profit,
                                     room3Name, room3Guest, room3Time, room3Profit, room4Name, room4Guest, room4Time, room4Profit, room5Name, room5Guest, room5Time, room5Profit,
                                     totalGuest, totalProfit, userName);
        
        inFile.close();
        outFile.close();
    }
    
}
