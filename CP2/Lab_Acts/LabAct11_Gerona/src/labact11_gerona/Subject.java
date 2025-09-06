/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labact11_gerona;

/**
 *
 * @author kenge
 */
public class Subject {
    private String subjId;
    private String description;
    private String classification;
    static int noOfSubs;

    public Subject() {
        noOfSubs++;
    }

    public Subject(String subjId) {
        setSubjId(subjId);
        noOfSubs++;
    }

    public Subject(String subjId, String description) {
        setSubjId(subjId);
        setDescription(description);
        noOfSubs++;
    }

    public Subject(String subjId, String description, String classification) {
        setSubjId(subjId);
        setDescription(description);
        setClassification(classification);
        noOfSubs++;
    }
    

    public void setSubjId(String subjId) {
        this.subjId = subjId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public static void setNoOfSubs(int noOfSubs) {
        Subject.noOfSubs = noOfSubs;
    }
    
    

    public String getSubjId() {
        return subjId;
    }

    public String getDescription() {
        return description;
    }

    public String getClassification() {
        return classification;
    }

    public static int getNoOfSubs() {
        return noOfSubs;
    }
    
    
    public String summarize(){
        return "Subject ID: " + this.getSubjId() + "\nSubject Name/Description: " + this.getDescription() + "\nClassification: " + this.getClassification();
    }

    
}
