/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentSort;
import java.util.*;
import java.io.*;
/*
 *
 * @author kengerona
 */
public class Main {
    
    public static void CoursesSort(ArrayList<String> courses){
         String temp;
         int j;
         for (int i = 1; i < courses.size(); ++i) {
            temp = courses.get(i);
            for (j = i - 1; j >= 0 ; j--) {
                if (courses.get(j).compareToIgnoreCase(temp)>0){
                    courses.set(j+1, courses.get(j));
                }else break;
            }
            courses.set(j+1, temp);
        }
    }
    
    public static void StudentsSort(ArrayList<Student> students){
         Student temp;
         int j;
         for (int i = 1; i < students.size(); ++i) {
            temp = students.get(i);
            for (j = i - 1; j >= 0 ; j--) {
                if (students.get(j).getLastname().compareToIgnoreCase(temp.getLastname())>0){
                    students.set(j+1, students.get(j));
                }else if(students.get(j).getLastname().compareToIgnoreCase(temp.getLastname())==0){
                    if (students.get(j).getFirstname().compareToIgnoreCase(temp.getFirstname())>0){
                        students.set(j+1, students.get(j));
                    }
                }else break;
            }
            students.set(j+1, temp);
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner( new File("C:\\Users\\kenge\\Downloads\\ateneoSystem-20240427T031515Z-001\\ateneoSystem\\src\\studentSort\\student.txt"));
        ArrayList<ArrayList<Student>> students = new ArrayList<>();
        ArrayList<Student> Origstudents = new ArrayList<>();
        ArrayList<Student> tempo = new ArrayList<>();
        ArrayList<String> courses = new ArrayList<>();
        students.add(Origstudents);
        
        Student temp;
        String lastname = "", firstname = "",course = "";
        char gender = 'n';
        int yearLevel = 0;
        double qpi = 0;
        
        //read the file into an arraylist of students
        while(input.hasNext()){
            try{
            lastname = input.nextLine();
            firstname = input.nextLine();
            gender = input.nextLine().charAt(0);
            course = input.nextLine();
            yearLevel = input.nextInt();
            qpi = input.nextDouble();
            input.nextInt();
            }catch(NoSuchElementException e){
                
            }
            temp = new Student(lastname, firstname, course, gender, yearLevel, qpi);
            Origstudents.add(temp);
            
        }
        
        //identify how many courses there are and store them in an array at the same time sort them
        for (int i = 0; i < Origstudents.size(); i++) {
            if (!courses.contains(Origstudents.get(i).getCourse().toUpperCase())){
                courses.add(Origstudents.get(i).getCourse().toUpperCase());
            }
        }
        CoursesSort(courses);

        /*search for the students that belongs to a particular course and store them in a categorized 
        array by their courses while also sorting them by last name and firstname*/
        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < Origstudents.size(); j++) {
                if(Origstudents.get(j).getCourse().compareToIgnoreCase(courses.get(i))==0){
                    tempo.add(Origstudents.get(j));
                }
            }
            StudentsSort(tempo);
            students.add(new ArrayList<Student>(tempo));
            tempo.clear();
        }
        
        //print the entire 2d array
        for (int i = 1; i < students.size(); i++) {
            System.out.println("-----------------------------------------------" + courses.get(i-1).toUpperCase() + "-----------------------------------------------");
            for (int j = 0; j < students.get(i).size() ; j++) {
                System.out.println(students.get(i).get(j).toString());
            }
        }
    }
}
