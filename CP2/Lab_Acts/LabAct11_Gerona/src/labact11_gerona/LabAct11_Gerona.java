/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labact11_gerona;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author jkdgerona
 */
public class LabAct11_Gerona {
    
    public static void viewstudents (Student[] students){
        for (int i = 0; i < Student.getNoStudents(); i++){
            JOptionPane.showMessageDialog(null, students[i].summarize());
        }
    }
    public static void reviewsubjects (Subject[] subjects){
        for (int i = 0; i < Subject.getNoOfSubs(); i++){
            JOptionPane.showMessageDialog(null, subjects[i].summarize());
        }
    }
    
    public static Student[] studentsMenu (Student[] students){
        int index = Student.getNoStudents()-1;
        
        int choice = Integer.parseInt(JOptionPane.showInputDialog("STUDENT MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
        while (choice ==1 && index <10){
            index = Student.getNoStudents();
            students[index] = new Student();
            students[index].setName(JOptionPane.showInputDialog("Name: "));
            students[index].setAge(Integer.parseInt(JOptionPane.showInputDialog("Age: ")));
            students[index].setStudID("OOP2024000" + Student.getNoStudents());
            students[index].setProgram(JOptionPane.showInputDialog("Program: "));
            students[index].setYearLvl(Integer.parseInt(JOptionPane.showInputDialog("Year Level: ")));
            JOptionPane.showMessageDialog(null, "Student Information Successfully Saved");
            
            choice = Integer.parseInt(JOptionPane.showInputDialog("STUDENT MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
            
        }
        
        return students;
    }
    
    public static Staff[] staffsMenu (Staff[] staffs){
        int index = Staff.getNoStaffs();
        int choice = Integer.parseInt(JOptionPane.showInputDialog("STAFF MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
        while (choice ==1 && index <10){
            index = Staff.getNoStaffs();
            staffs[index] = new Staff();
            staffs[index].setName(JOptionPane.showInputDialog("Name: "));
            staffs[index].setAge(Integer.parseInt(JOptionPane.showInputDialog("Age: ")));
            staffs[index].setEmpID(Integer.parseInt(JOptionPane.showInputDialog("Employee ID: ")));
            staffs[index].setRemarks(JOptionPane.showInputDialog("Remarks: "));
            staffs[index].setDepartment(JOptionPane.showInputDialog("Department: "));
            JOptionPane.showMessageDialog(null, "Staff Information Successfully Saved");
            
            choice = Integer.parseInt(JOptionPane.showInputDialog("STAFF MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
            
            
        }
        
        return staffs;
    }
    
    public static Subject[] subjectsMenu (Subject[] subjects){
        int index = Subject.getNoOfSubs();
        int choice = Integer.parseInt(JOptionPane.showInputDialog("SUBJECT MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
        while (choice ==1 && index <10){
            index = Subject.getNoOfSubs();
            subjects[index] = new Subject();
            subjects[index].setDescription(JOptionPane.showInputDialog("Subject Name: "));
            subjects[index].setSubjId(subjects[index].getDescription().substring(0,1)+"000" + Subject.getNoOfSubs());
            subjects[index].setClassification(JOptionPane.showInputDialog("Classification (e.g. GE, CS, IT) : "));
            System.out.println(Subject.getNoOfSubs());
            JOptionPane.showMessageDialog(null, "Subject Information Successfully Saved");
            
            choice = Integer.parseInt(JOptionPane.showInputDialog("SUBJECT MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
            
            
        }
        
        return subjects;
    }
    
    public static Student[] gradesMenu (Grade[] grades, Student[] students){
        int choice = Integer.parseInt(JOptionPane.showInputDialog("GRADE MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
        int index;
        while (choice ==1){
        index = Integer.parseInt(JOptionPane.showInputDialog("What number is the student you want to grade?"));
        grades[index] = new Grade();
        double[] grado = new double[3];
        for (int i=0; i<3; i++){
            grado[i] = Double.parseDouble(JOptionPane.showInputDialog("Grade: "));
        }
        students[index].setGrade(grado);
            System.out.println(students[index].intro());
        JOptionPane.showMessageDialog(null, "Grade Information Successfully Saved");
        
        choice = Integer.parseInt(JOptionPane.showInputDialog("SUBJECT MENU\n(1)ADD\n(2)BACK to Main Menu\n"));
        }
        return students;
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner scan = new Scanner (System.in);
        int choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
        int choice2, choice3;
        Staff[] staffs = new Staff[10];
        Student[] students = new Student[10];
        Subject[] subjects = new Subject[10];
        Grade[] grades = new Grade[10];
        
        
        while (choice != 4){
        if (choice != 1 && choice != 2 && choice != 3){
            System.out.println("Invalid Choice you piece of shit!");
        }else if(choice == 1){
            choice2 = Integer.parseInt(JOptionPane.showInputDialog("You are a ____?\n(1)Student\n(2)Staff\n(3)View Students List"));
            if (choice2 == 1){
                students = studentsMenu(students);
                choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
            }else if (choice2 == 2){
                staffs = staffsMenu(staffs);
                choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
            }else if (choice2 == 3){
                viewstudents(students);
            }
        }else if (choice == 2){
            choice3 = Integer.parseInt(JOptionPane.showInputDialog("Do you want to create a Subject or view existing subjects?\n(1)Create\n(2)View"));
            if (choice3 == 1){
                subjects = subjectsMenu(subjects);
                choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
            }else if (choice3 == 2){
                reviewsubjects(subjects);
                choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
            }
        }else if (choice == 3){
           students = gradesMenu(grades, students);
           choice = Integer.parseInt(JOptionPane.showInputDialog("What do you want to create?\n(1)Person\n(2)Subject\n(3)Grade Subjects\n\n(4)Exit"));
        }
        }
        
        System.out.println(Subject.getNoOfSubs());
        System.out.println(subjects[0].summarize());
        System.out.println(Subject.getNoOfSubs());
        System.out.println(subjects[1].summarize());
        System.out.println(Subject.getNoOfSubs());
        System.out.println(subjects[2].summarize());
        System.out.println(Subject.getNoOfSubs());
        System.out.println(subjects[3].summarize());
        
    }

   
    
}
