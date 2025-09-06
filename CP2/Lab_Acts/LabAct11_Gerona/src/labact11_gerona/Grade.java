/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labact11_gerona;

/**
 *
 * @author jkdgerona
 */
public class Grade {
    private String subjCode;
    private String studId;
    private double [ ] grade = new double [3];
    static int noOfGrade;

    public Grade() {
        noOfGrade++;
    }

    public Grade(String subjCode) {
        this.subjCode = subjCode;
        noOfGrade++;
    }

    public Grade(String subjCode, String studId) {
        this.subjCode = subjCode;
        this.studId = studId;
        noOfGrade++;
    }
    public Grade(String subjCode, String studId, double[] grade) {
        this.subjCode = subjCode;
        this.studId = studId;
        setGrade(grade);
        noOfGrade++;
    }
    

    public void setSubjCode(String subjCode) {
        this.subjCode = subjCode;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public void setGrade(double[] grade) {
        for (int i = 0; i<3; i++){
        this.grade = grade;
        }
    }

    public String getSubjCode() {
        return subjCode;
    }

    public String getStudId() {
        return studId;
    }

    public double[] getGrade() {
        return grade;
    }

    public static int getNoOfGrade() {
        return noOfGrade;
    }
    
    public String checker(){
        return "Prelims: " + this.grade[0] + "Midterms: " + this.grade[1] + "Prefi: " + this.grade[2];
    }
    
    public String check(){
        return (grade[0]+grade[1]+grade[2])/3>74? "passed" : "failed";
    }
    
    
    
}
