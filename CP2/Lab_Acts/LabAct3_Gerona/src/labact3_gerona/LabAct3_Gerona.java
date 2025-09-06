package labact3_gerona;
import javax.swing.JOptionPane;
/**
 *
 * @author jkdgerona
 */
public class LabAct3_Gerona {
    
    public static String Propercasing (String first, String last) {
        String full = (first.substring(0, 1).toUpperCase() + first.substring(1).toLowerCase()) + " " + 
                      (last.substring(0, 1).toUpperCase() + last.substring(1).toLowerCase());
        return full;
    }
    
    public static double Average (double math, double science, double oop) {
        double average = (math + science + oop) / 3;
        return average;
    }
    
    public static double EndOfWorld (int age, double average){
        double end = Math.floor(age*average);
        return end;
    }
    
    public static void print (String fullName, int age, double average, double years){
         String sentence = String.format("Hello! I'm %s, %d-years old, having an average grade of %.2f in my class. The world would probably end in %,.0f years.\n", fullName, age, average, years);
         JOptionPane.showMessageDialog(null, sentence);
    }
    
    
    public static void main(String[] args) {
        
        String firstName = JOptionPane.showInputDialog("First Name: ");
        String lastName = JOptionPane.showInputDialog("Last Name: ");
        int age =  Math.abs(Integer.parseInt(JOptionPane.showInputDialog("Age: ")));
        double gradeMath = Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Math Grade: ")));
        double gradeScience =  Math.abs(Double.parseDouble(JOptionPane.showInputDialog("Science Grade: ")));
        double gradeOOP =  Math.abs(Double.parseDouble(JOptionPane.showInputDialog("OOP Grade: ")));
        
        String fullName = Propercasing(firstName, lastName);
        double average = Average(gradeMath, gradeScience, gradeOOP);
        double endWorld = Math.floor(EndOfWorld(age, average));
        print(fullName, age, average, endWorld);
    }
    
}
