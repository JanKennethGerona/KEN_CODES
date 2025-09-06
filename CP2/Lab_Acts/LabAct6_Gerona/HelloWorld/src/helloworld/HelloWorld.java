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

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("Name: ");
        char first = name.charAt(0);
        char last = name.charAt(name.length() - 1);
        
        if ( first < 'a'){
            System.out.println("yes");
        }else return;
        if (last=='0' || last== 'Z'){
            System.out.println("Yes");
        }else return;
        
        if (name.compareTo("Sentence") < 0){
            System.out.println(name.compareTo("Sentence"));
            System.out.println("YES!!!");
        }else return;
        
        
        
             
    }
    
}
