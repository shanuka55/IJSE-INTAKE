package controller;

import com.jfoenix.controls.*;
import controller.crudController.StudentCrudController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import model.Student;
import utill.CrudUtil;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentFormcontroller implements Initializable {
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
        try{
            if (CrudUtil.execute("DELETE FROM student WHERE student_Id=?",txtStuentId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Deleted Successfully...!").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!"+e).show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        Student s=new Student(txtStuentId.getText(), txtStuentName.getText(), txtStudentEmail.getText(),txtContact.getText(), txtAddress.getText(),txtNIC.getText());

        try{
            if(CrudUtil.execute("UPDATE student SET student_Name=?,email=?,contact=?, address=?, nic=?  WHERE student_Id=?",s.getName(), s.getMail(), s.getContact(), s.getAddress(), s.getNic(), s.getId())){
                new Alert(Alert.AlertType.CONFIRMATION, "Student Updated Successfully...!").show();
            }
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Try Again....!").show();
        }
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setStudentIds();
    }

    private void setStudentIds() {
        try {

            ObservableList<String> ObList = FXCollections.observableArrayList(
                    StudentCrudController.getAllIds()
            );
            cmbStudentId.setItems(ObList);


            cmbStudentId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                String id= (String) newValue;

                ResultSet result = null;
                try {
                    result = CrudUtil.execute("SELECT * FROM student WHERE student_Id=?",id);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    if (result.next()) {
                        txtStuentId.setText(result.getString(1));
                        txtStuentName.setText(result.getString(2));
                        txtStudentEmail.setText(result.getString(3));
                        txtContact.setText(result.getString(4));
                        txtAddress.setText(result.getString(5));
                        txtNIC.setText(result.getString(6));
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Empty Result").show();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            });
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
