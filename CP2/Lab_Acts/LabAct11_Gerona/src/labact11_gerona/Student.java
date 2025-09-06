/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labact11_gerona;

/**
 *
 * @author jkdgerona
 */
public class Student extends Person {
    private String studID;
    private String program;
    private int yearLvl; 
    static int noStudents;
    private double [ ] grade = new double [3];
   
    public Student() {
        noStudents++;
    }

    public Student(String name) {
        super(name);
        noStudents++;
    }

    public Student(String name, int age) {
        super(name, age);
        noStudents++;
    }

    public Student(String studID, String name, int age) {
        super(name, age);
        setStudID(studID);
        noStudents++;
    }

    public Student(String program, String name, int age, String studID) {
        super(name, age);
        setStudID(studID);
        setProgram(program);
        noStudents++;
    }

    public Student(String studID, String program, int yearLvl, String name, int age) {
        super(name, age);
        setStudID(studID);
        setProgram(program);
        setYearLvl(yearLvl);
        noStudents++;
    }

    public void setStudID(String studID) {
        this.studID = studID;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setYearLvl(int yearLvl) {
        this.yearLvl = yearLvl;
    }
    public void setGrade(double[] grade) {
        for (int i = 0; i<3; i++){
        this.grade = grade;
        }
    }

    public String getStudID() {
        return studID;
    }

    public String getProgram() {
        return program;
    }

    public int getYearLvl() {
        return yearLvl;
    }

    public static int getNoStudents() {
        return noStudents;
    }
    public String getGrade() {
        return ""+grade[0]+"|"+grade[1]+"|"+grade[2]+"     "+(grade[0]+grade[1]+grade[2])/3;
    }
    
    
    @Override
    public String intro(){
        return "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nStudent ID: " + this.getStudID() + "\nProgram: " +
                this.getProgram() + "\nYearLvl: " + this.getYearLvl();
    }
    
    
    public String summarize(){
        return this.getName() +"\n"+ this.getProgram()+" - "+this.getYearLvl()+"\nPre |Mid |PrF     Final\n"+this.getGrade();
    }

    
    
}
