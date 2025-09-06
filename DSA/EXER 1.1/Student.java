/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication4;

/**
 *
 * @author jkdgerona
 */
public class Student {
    private String lastName;
    private String firstName; 
    private String course;
    private int[] grades;

    public Student(String lastName, String firstName, String course, int[] grades) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.course = course;
        this.grades = grades;
    }
    
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCourse() {
        return course;
    }

    public int[] getGrades() {
        return grades;
    }
   
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
    
    public boolean hasFailingGrade(){
        for (int i = 0; i<grades.length; i++){
            if (grades[i] < 75){
                return true;
            }
        }
        return false;
    }
    
    public double average(){
        double total = 0;
        for (int i = 0; i<grades.length; i++){
            total += grades[i];
        }
        return total/grades.length;
    }

    public void print(){
        System.out.println(String.format("Name: %s, %s\nCourse: %s\nAverage: %.2f\n--------------------------------------------------", 
                                         this.lastName, this.firstName, this.course, this.average()));
    }
}
