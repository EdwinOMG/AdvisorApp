package com.example.databasehelp;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private ChoiceBox<String> major_box;
    @FXML
    private TextField text_id;

    @FXML
    private TextField text_name;

    @FXML
    private TextField text_email;

    @FXML
    private TextField text_address;

    @FXML
    private TextField text_number;



    @FXML
    private Button addbutton;

    private int majorNumber;

    private int idNum;





    @FXML
    private void initialize() {
        major_box.getItems().addAll("Computer Programming");
    }

    @FXML
    private void handleAddButton(ActionEvent event) {
        String studentId = text_id.getText();
        try {
            idNum = Integer.parseInt(studentId);
        } catch (NumberFormatException e) {
            System.err.println("Invalid Student ID: " + studentId);
            return;
        }//converting here cause textfield has to be string

        //grabbing all textfields on button press
        String studentName = text_name.getText();
        String studentEmail = text_email.getText();
        String studentAddress = text_address.getText();
        String studentNumber = text_number.getText();
        String selectedMajor = major_box.getValue();
        // can easily edit this, so when I add new majors just add numbers
        if ("Computer Programming".equals(selectedMajor)){
            majorNumber = 1;
        }
        ObservableList<Course> semester1Courses = DataCalls.selectCoursesBySemester(idNum, 1);

        // Print or use the retrieved values as needed
        System.out.println("Student ID: " + idNum);
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Email: " + studentEmail);
        System.out.println("Student Address: " + studentAddress);
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Selected Major: " + majorNumber);

        DataCalls.insertStudent(idNum, studentName, studentNumber, studentEmail, studentAddress, majorNumber);
        //clearing text fields after inserting the data
        text_id.setText("");
        text_name.setText("");
        text_email.setText("");
        text_address.setText("");
        text_number.setText("");

        retrieveStudentID studentIdInstance = new retrieveStudentID();
        studentIdInstance.setStudentId(idNum);
        System.out.println("maincontroller" + idNum);


        openAdvisorsheetGUI(idNum);
    }

        private void openAdvisorsheetGUI(int idNum) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/databasehelp/AdvisorSheetNew.fxml"));
                Parent root = loader.load();

                AdvisorSheetController advisorSheetController = loader.getController();

                advisorSheetController.setStudentId(idNum);

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





}