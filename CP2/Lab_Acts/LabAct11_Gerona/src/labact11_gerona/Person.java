/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labact11_gerona;

/**
 *
 * @author jkdgerona
 */
public abstract class Person {
    private String name;
    private int age;
    static int noPerson; 

    public Person() {
        noPerson++;
    }

    public Person(String name) {
        setName(name);
        noPerson++;
    }
    

    public Person(String name, int age) {
        setName(name);
        setAge(age);
        noPerson++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getNoPerson() {
        return noPerson;
    }
    
    
    abstract String intro();

    
}
