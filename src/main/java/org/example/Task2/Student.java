package org.example.Task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {

    //region Fields
    private static final long serialVersionUID = 2L;
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

    public Student() {};

    //endregion

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(GPA);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readObject() + "Иванович";
        age = (Integer) in.readObject() + 5;
        GPA = (Double) in.readObject();
    }

    @Override
    public String toString() {
        return "Имя студента: " + getName() + '\'' +
                "Возраст: " + getAge() + '\'' +
                "Средний балл: " + getGPA();
    }
}
