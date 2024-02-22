package com.example.databasehelp;

public class StudentCourseDetails {
    private String courseGrade;
    private String courseTerm;
    private String courseNotes;
    private boolean courseCompletion;
    private String courseID;
    private int studentId;



    public StudentCourseDetails(String courseGrade, String courseTerm, String courseNotes, boolean courseCompletion, String courseID) {
        this.courseGrade = courseGrade;
        this.courseTerm = courseTerm;
        this.courseNotes = courseNotes;
        this.courseCompletion = courseCompletion;
        this.courseID = courseID;
    }

    public String getCourseGrade() {
        return courseGrade;
    }
    public void setCourseGrade(String courseGrade){
        this.courseGrade = courseGrade;
    }
    public String getCourseTerm() {
        return courseTerm;
    }
    public void setCourseTerm(String courseTerm){
        this.courseTerm = courseTerm;
    }

    public String getCourseNotes() {
        return courseNotes;
    }
    public void setCourseNotes(String courseNotes){
        this.courseNotes = courseNotes;
    }
    public boolean getCourseCompletion() {
        return courseCompletion;
    }
    public void setCourseCompletion(boolean courseCompletion){
        this.courseCompletion = courseCompletion;
    }


    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
}
