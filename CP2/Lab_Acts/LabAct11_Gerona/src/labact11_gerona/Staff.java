/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labact11_gerona;

/**
 *
 * @author jkdgerona
 */
public class Staff extends Person{
    private int empID;
    private String remarks;
    private String department;
    static int noStaffs;

    public Staff() {
        noStaffs++;
    }

    public Staff(String name) {
        super(name);
        noStaffs++;
    }

    public Staff(String name, int age) {
        super(name, age);
        noStaffs++;
    }

    public Staff(int empID, String name, int age) {
        super(name, age);
        setEmpID (empID);
        noStaffs++;
    }

    public Staff(int empID, String remarks, String name, int age) {
        super(name, age);
        setEmpID (empID);
        setRemarks(remarks);
        noStaffs++;
    }

    public Staff(int empID, String remarks, String department, String name, int age) {
        super(name, age);
        setEmpID (empID);
        setRemarks(remarks);
        setDepartment(department);
        noStaffs++;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getEmpID() {
        return empID;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getDepartment() {
        return department;
    }

    public static int getNoStaffs() {
        return noStaffs;
    }

    @Override
    public String intro(){
        return "Name: " + this.getName() + "\nAge: " + this.getAge() + "\nEmployee ID: " + this.getEmpID() + "\nRemarks: " + this.getRemarks() + 
                "\nDepartment: " + this.getDepartment();
    }
    
    
    
}
