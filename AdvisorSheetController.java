package com.example.databasehelp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import static com.example.databasehelp.DataCalls.updateStudentCourseDetails;

public class AdvisorSheetController {
    @FXML
    private ImageView imageView1;

    @FXML
    private ImageView imageView2;

    @FXML
    private ImageView imageView3;

    @FXML
    private ImageView imageView4;
    @FXML
    private ImageView imageView5;
    @FXML
    private ImageView imageView6;
    @FXML
    private ImageView imageView7;
    @FXML
    private TableView<Course> pre_table;
    @FXML
    private TableView<Course> first_table;
    @FXML
    private TableView<Course> second_table;
    @FXML
    private TableView<Course> third_table;
    @FXML
    private TableView<Course> fourth_table;


    @FXML
    private TableColumn<Course, Boolean> course_completion;


    @FXML
    private TableColumn<Course, String> course_id;
    @FXML
    private TableColumn<Course, String> course_name;
    @FXML
    private TableColumn<Course, Integer> course_credits;
    @FXML
    private TableColumn<StudentCourseDetails, String> course_term;
    @FXML
    private TableColumn<StudentCourseDetails, String> course_grade;
    @FXML
    private TableColumn<StudentCourseDetails, String> course_notes;

    private int studentId;


    public void setStudentId(int studentId) {
        this.studentId = studentId;
        System.out.println("Received studentId in AdvisorSheetController: " + studentId);

    }

    @FXML
    private void initialize() {


        //Load images
        Image image1 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.15.23 PM.png").toExternalForm());
        Image image2 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.15.31 PM.png").toExternalForm());
        Image image3 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.25.56 PM.png").toExternalForm());
        Image image4 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.41.31 PM.png").toExternalForm());
        Image image5 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.41.46 PM.png").toExternalForm());
        Image image6 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 5.12.37 PM.png").toExternalForm());
        Image image7 = new Image(getClass().getResource("/Images/Screenshot 2024-02-20 at 4.42.13 PM.png").toExternalForm());

        // Set images to ImageViews
        imageView1.setImage(image1);
        imageView2.setImage(image2);
        imageView3.setImage(image3);
        imageView4.setImage(image4);
        imageView5.setImage(image5);
        imageView6.setImage(image6);
        imageView7.setImage(image7);


        ObservableList<Course> semester1Courses = DataCalls.selectCoursesBySemester(studentId, 1);
        System.out.println(semester1Courses);

        ObservableList<Course> coursesList = FXCollections.observableArrayList(semester1Courses);

        for (Course course : semester1Courses) {
            // For each course, get the associated StudentCourseDetails
            StudentCourseDetails studentCourseDetails = DataCalls.getStudentCourseDetails(studentId, course.getCourseID());

            // Set the StudentCourseDetails for the course
            course.setStudentCourseDetails(studentCourseDetails);

        }

        course_id.setCellValueFactory(new PropertyValueFactory<>("courseID"));
        course_name.setCellValueFactory(new PropertyValueFactory<>("courseName"));
        course_credits.setCellValueFactory(new PropertyValueFactory<>("courseCredits"));
        course_completion.setCellFactory(column -> new CheckBoxTableCell<>());

        course_notes.setCellValueFactory(new StudentCourseDetailsCellValueFactory("courseNotes"));
        course_notes.setCellFactory(TextFieldTableCell.forTableColumn());
        course_notes.setOnEditCommit(event -> updateDatabase(event, "courseNotes"));

        course_term.setCellValueFactory(new StudentCourseDetailsCellValueFactory("courseTerm"));
        course_term.setCellFactory(TextFieldTableCell.forTableColumn());
        course_term.setOnEditCommit(event -> updateDatabase(event, "courseTerm"));

        course_grade.setCellValueFactory(new StudentCourseDetailsCellValueFactory("courseGrade"));
        course_grade.setCellFactory(TextFieldTableCell.forTableColumn());
        course_grade.setOnEditCommit(event -> updateDatabase(event, "courseGrade"));

        // Set the editable columns to the table
        first_table.setEditable(true);
        first_table.setItems(coursesList);
    }


    private void updateDatabase(TableColumn.CellEditEvent<?, String> event, String propertyName) {
        try {
            Object editedObject = event.getRowValue();
            System.out.println(studentId);

            if (editedObject instanceof StudentCourseDetails) {
                System.out.println("got to if loop");

                StudentCourseDetails editedCourse = (StudentCourseDetails) editedObject;

                // Check if the record already exists
                boolean recordExists = DataCalls.doesStudentCourseDetailsExist(studentId, editedCourse.getCourseID());

                // If the record doesn't exist, insert a new one
                if (!recordExists) {
                    DataCalls.insertStudentCourseDetails(studentId, editedCourse.getCourseID(), editedCourse);
                    System.out.println("record does not exist got here");
                } else {
                    updateStudentCourseDetails(studentId, editedCourse.getCourseID(), editedCourse);
                    System.out.println("updating instead");
                }
            } else {
                System.out.println("shouldn't get here");
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions as needed
        }
    }
}


