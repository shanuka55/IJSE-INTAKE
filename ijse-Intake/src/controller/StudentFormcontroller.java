package controller;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import model.Student;
import utill.CrudUtil;

import java.sql.SQLException;

public class StudentFormcontroller {
    public JFXTextField txtStuentName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXButton btnStudentTable;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public JFXComboBox cmbStudentId;
    public JFXButton btnAddStudent;
    public JFXTextField txtStudentEmail;
    public JFXTextField txtNIC;
    public JFXTextField txtStuentId;


    public void btnStudentTableOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        Student student = new Student(txtStuentId.getText(), txtStuentName.getText(), txtStudentEmail.getText(),txtContact.getText(), txtAddress.getText(),txtNIC.getText());

        try {
            if (CrudUtil.execute("INSERT INTO student VALUES (?,?,?,?,?,?)",student.getId(), student.getName(), student.getMail(), student.getContact(), student.getAddress(), student.getNic())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Saved Successfully...!").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
    }
}
