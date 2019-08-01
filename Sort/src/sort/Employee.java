/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sort;

/**
 *
 * @author Thinh
 */
public class Employee implements Comparable<Employee>{
    private String ID;
    private String name;
    private int level;

    public Employee() {
    }

    public Employee(String ID, String name, int level) {
        this.ID = ID;
        this.name = name;
        this.level = level;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        System.out.printf("%-10s%-20s%-10d\n", this.ID, this.name, this.level);
        return "";
    }

    @Override
    public int compareTo(Employee o) {
        return this.ID.compareToIgnoreCase(o.ID);
    }
    
    
}
