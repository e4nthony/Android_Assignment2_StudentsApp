package com.example.android_assignment2_studentsapp.model;

import com.example.android_assignment2_studentsapp.Student;

import java.util.LinkedList;
import java.util.List;

/***
 * Singleton - (Lazy Initialization)
 */
public class Model {
    private static Model instance;
    private static LinkedList<Student> data;

    private Model(){/*empty constructor*/}

    public static Model getInstance(){
        if(instance == null) {
            instance = new Model();
            data = new LinkedList<Student>();
        }
        return instance;
    }

    public LinkedList<Student> getData() {
        return data;
    }

    public void addNewStudent(Student student) {
        data.add(student);
    }

    /***
     * @param student -
     * @return - new students count
     */
    public int deleteStudent(Student student) {
        data.remove(student);
        return getSize();
    }

    public int getSize() {
        return data.size();
    }
}