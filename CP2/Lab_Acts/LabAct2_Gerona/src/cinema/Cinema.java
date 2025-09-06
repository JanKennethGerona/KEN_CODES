/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinema;

import javax.swing.JOptionPane;

/**
 *
 * @author jkdgerona
 */
public class Cinema {

    
    public static double grossIncome (double price, double sold){
        
        double gross = price*sold;
        return gross;
    }
    
    public static double donationMade (double gross){
        double donation = gross*0.1;
        return donation;
    }
    
    public static void output (String movieName, int ticketSold, double gross, double donate){
        JOptionPane.showMessageDialog(null, " Movie name: " + movieName + "\n Number of Tickets Sold: " + ticketSold + " \n Gross amount: ₱" + gross + "\n Amount donated: ₱" + donate + "\n Net Sale: ₱" + (gross-donate));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
        
        String movieName = JOptionPane.showInputDialog("Movie Name: ");
        double ticketPrice = Double.parseDouble(JOptionPane.showInputDialog("Ticket Price: "));
        int ticketSold = Integer.parseInt(JOptionPane.showInputDialog("Number of Tickets Sold: "));
        double gross, donate;
        
        
        gross = grossIncome (ticketPrice, ticketSold);
        donate = donationMade (gross);
        output(movieName, ticketSold, gross, donate);
        
        
        
             
    }
    
}