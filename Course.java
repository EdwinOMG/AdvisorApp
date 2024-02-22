package com.example.databasehelp;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Course {
    private String courseID;
    private String courseName;
    private int courseCredits;
    private BooleanProperty selected;
    private String courseGrade;
    private String courseTerm;
    private String courseNotes;
    private boolean courseCompletion;
    private StudentCourseDetails studentCourseDetails;


    public Course(String courseID, String courseName, int courseCredits, boolean selected, StudentCourseDetails studentCourseDetails) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.selected = new SimpleBooleanProperty(selected);
        this.studentCourseDetails = studentCourseDetails;

    }
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseCredits(int courseCredits){
        this.courseCredits = courseCredits;
    }

    public int getCourseCredits(){
        return courseCredits;
    }

    public boolean isSelected(){
        return selected.get();
    }
    public void setSelected(boolean selected){
        this.selected.set(selected);
    }
    public BooleanProperty selectedProperty() {
        return selected;
    }


    public boolean getCourseCompletion() {
        return courseCompletion;
    }
    public void setCourseCompletion(boolean courseCompletion){
        this.courseCompletion = courseCompletion;
    }

    public StudentCourseDetails getStudentCourseDetails() {
        return studentCourseDetails;
    }

    public void setStudentCourseDetails(StudentCourseDetails studentCourseDetails) {
        this.studentCourseDetails = studentCourseDetails;
    }
}

