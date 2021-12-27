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
    private static final int STUDENTS_COUNT = 15;

    private Model(){/*empty constructor*/}

    public static Model getInstance(){
        if(instance == null) {
            instance = new Model();
            InitializeModel();
        }
        return instance;
    }

    private static void InitializeModel() {
        data = new LinkedList<Student>();

        // Student's Data Initialization
        {
            Student student; //temp

            for (int i = 0; i < STUDENTS_COUNT; ++i) {
                student = new Student();
                student.setId(i);
                student.setName("name_" + i);
                //checkbox = false by default

                addNewStudent(student);
            }
        }
    }




    public LinkedList<Student> getData() {
        return data;
    }

    public static void addNewStudent(Student student) {
        getInstance().getData().add(student);
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