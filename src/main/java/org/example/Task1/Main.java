package org.example.Task1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Alex", 22, 4.2);

        try(FileOutputStream fileOS = new FileOutputStream("studentInfo.bin");
            ObjectOutputStream objectOS = new ObjectOutputStream(fileOS)) {
                objectOS.writeObject(student);
        }

        try(FileInputStream fileIS = new FileInputStream("studentInfo.bin");
            ObjectInputStream objectIS = new ObjectInputStream(fileIS)) {
                student = (Student) objectIS.readObject();
        }

        System.out.printf("Имя студента - %s\nВозраст студента - %d\nСредний балл обучения - %f",
                student.getName(), student.getAge(), student.getGPA());

    }
}