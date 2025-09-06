/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentSort;

/**
 *
 * @author kengerona
 */
public class Student {
    private String lastname, firstname, course;
    private char gender;
    private int yearlevel;    
    private double qpi;
    
    public Student(String lastname, String firstname, String course, char gender, int yearlevel, double qpi) {
    	this.lastname = lastname;
    	this.firstname = firstname;    	
    	this.course = course;
    	this.gender = gender;
    	this.yearlevel = yearlevel;
        this.qpi = qpi;
    }
    
    @Override
    public String toString() {    	
        return String.format("Name: %-30s  Course: %-20s  Gender: %c  Year: %d  QPI: %-3.2f", (lastname + ", " + firstname), course, gender, yearlevel, qpi );
    }
    
    public void setGender(char gender){
        this.gender = gender;
    }
    
    public char getGender(){
        return gender;
    }
    
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setCourse(String course){
        this.course = course;
    }
    
    public String getCourse(){
        return course;
    }
    
    public void setYearLevel(int yearlevel){
        this.yearlevel = (yearlevel < 1 || yearlevel > 4)?1:yearlevel;        
    }
    
    public int getYearLevel(){
        return yearlevel;
    }
    
    public double getQpi() {
        return qpi;
    }

    public void setQpi(double qpi) {
        this.qpi = (qpi < 0 || qpi > 4)?0:qpi;        
    }
}
