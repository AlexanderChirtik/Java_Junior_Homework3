package org.example.Task1;

import java.io.Serializable;

public class Student implements Serializable {

    //region Fields
    private String name;
    private int age;
    private transient double GPA;

    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    //endregion

    //region Constructors
    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    //endregion
}
