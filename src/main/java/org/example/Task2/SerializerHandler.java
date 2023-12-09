package org.example.Task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class SerializerHandler {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();


    public static void writeToFile(String fileName, Student student) {
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(fileName), student);
            } else if (fileName.endsWith(".bin")) {
                try(FileOutputStream fileOS = new FileOutputStream(fileName);
                    ObjectOutputStream objectOS = new ObjectOutputStream(fileOS)) {
                    objectOS.writeObject(student);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(new File(fileName), student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Сериализация успешно завершена");
    }

    public static Student readFromFile(String fileName) {
        Student student = new Student();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, Student.class);
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream objectIS = new ObjectInputStream(new FileInputStream(file))) {
                        student = (Student) objectIS.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, Student.class);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Десериализация успешно завершена");
        return student;
    }
}
