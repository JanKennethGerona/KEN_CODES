/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact5_gerona;

import javax.swing.JOptionPane;

/**
 *
 * @author jkdgerona
 */
public class LabAct5_Gerona {
    
    public static String correct (String subject){
        return String.valueOf(subject.substring(0, 1).toUpperCase() + subject.substring(1).toLowerCase());
    }
    
    public static void inputSecond (){
        String input2nd = correct(JOptionPane.showInputDialog("Input 5 characters string: "));
        if (input2nd.length() != 5){
            JOptionPane.showMessageDialog (null, "Invalid length. Please try again!");
            inputSecond();
        }
        if (Character.isAlphabetic(input2nd.charAt(0)) && Character.isAlphabetic(input2nd.charAt(input2nd.length()-1))){
            JOptionPane.showMessageDialog (null, "Thank you for participating!");
            return;
        }else {
            int charSecond = input2nd.charAt(1);
            charSecond = charSecond - 48;
            if (charSecond%2 == 0){
                JOptionPane.showMessageDialog (null, "The second character of your input is EVEN!\n            Thank you for participating!");
                return;
            }else{
                JOptionPane.showMessageDialog (null, "The second character of your input is ODD!\n            Thank you for participating!");
                return;
            }
        }
    }
    
    public static void triangle (){
        JOptionPane.showMessageDialog (null, "I will be asking for three angles of a triangle from you.");
        double angle1 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input First Angle: ")));
        double angle2 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input Second Angle: ")));
        double angle3 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input Third Angle: ")));
        
        if (angle1 + angle2 + angle3 == 180 && angle1 != 0 && angle2 != 0 && angle3 != 0){
            JOptionPane.showMessageDialog (null, "Your Triangle is Valid! Thank you for participating!");
            return;
        }else {
            JOptionPane.showMessageDialog (null, "Your Triangle is Invalid!\nI will be asking for three lengths of a triangle from you.");
        double length1 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input First Length in meters: ")));
        double length2 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input Second Length in meters: ")));
        double length3 = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Input Third Length in meters: ")));
        
            if ( length1 == 0 || length2 == 0 || length3 == 0){
                JOptionPane.showMessageDialog (null, "There is no triangle that has a side of 0meters!");
                return;
            }
                if (length3 == length2 && length2 == length1){
                    JOptionPane.showMessageDialog (null, "Based on your input lengths, your triangle is Equilateral!");
                    JOptionPane.showMessageDialog (null, "Thank you for participating!");
                }else if (length3 == length2 || length2 == length1 || length1 == length3){
                    JOptionPane.showMessageDialog (null, "Based on your input lengths, your triangle is Isosceles!");
                    JOptionPane.showMessageDialog (null, "Thank you for participating!");
                }else if (length1 != length2 && length2 != length3 && length1 != length3){
                    JOptionPane.showMessageDialog (null, "Based on your input lengths, your triangle is Scalene!");
                    JOptionPane.showMessageDialog (null, "Thank you for participating!");
                }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String input = correct(JOptionPane.showInputDialog("Hello! What is your favorite food?\n                  Ice or Sugar? "));
        
        if (input.compareTo("Ice") != 0 && input.compareTo("Sugar") != 0){
            JOptionPane.showMessageDialog(null, "Invalid!! choose properly");
            main(null);
        }
        
        if (input.compareTo("Ice") == 0){
            inputSecond();
        }else {
            triangle();
        }
    }
    
    
}
