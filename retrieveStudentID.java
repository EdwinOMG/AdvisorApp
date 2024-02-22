package com.example.databasehelp;

public class retrieveStudentID {
    private int studentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    // Static method to get a singleton instance
    private static retrieveStudentID instance;

    public static retrieveStudentID getInstance() {
        if (instance == null) {
            instance = new retrieveStudentID();
        }
        return instance;
    }
}