/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helloworld;
import javax.swing.JOptionPane;
/**
 *
 * @author jkdgerona
 */
public class HelloWorld {

    public static void intro (String name, int height, double weight){

        JOptionPane.showMessageDialog(null, "I'm " + name + ", " + height + "cm tall and weighs " + weight + "kg.");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("Name: ");
        System.out.print("Name: "+ name);
        int height = Integer.parseInt(JOptionPane.showInputDialog("Height: "));
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Weight: "));
        
        
        intro(name, height, weight);
        
        
        
        
             
    }
    
}
