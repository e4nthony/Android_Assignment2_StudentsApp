package com.example.android_assignment2_studentsapp;

public class Student {
    private String name = "";
    private int id = -1;
    private boolean cb = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCb() {
        return cb;
    }

    public void setCb(boolean cb) {
        this.cb = cb;
    }


}
