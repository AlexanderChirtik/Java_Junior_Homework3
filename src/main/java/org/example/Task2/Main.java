package org.example.Task2;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Alexander", 24, 4.7);
        SerializerHandler.writeToFile("newFile.json", student);
        student = SerializerHandler.readFromFile("newFile.json");
        System.out.println(student);
    }
}
