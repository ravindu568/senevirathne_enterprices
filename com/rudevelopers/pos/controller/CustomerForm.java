package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.rudevelopers.pos.dao.dataBaseAccessCode;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class CustomerForm {
    public JFXTextField txtEmail;
    public JFXTextField txtName;
    public JFXTextField txtContact;
    public JFXTextField txtSalary;
    public TextField txtSearch;
    public JFXButton btnSaveUpdate;
    public TableColumn colId;
    public TableColumn colEmail;
    public TableColumn colName;
    public TableColumn colContact;
    public TableColumn colSalary;
    public TableColumn colOperation;

    public void btnSaveUpdateOnAction(ActionEvent actionEvent) {

        try{

            if(
                    dataBaseAccessCode.createCustomer(
                            txtEmail.getText(),txtName.getText(),txtContact.getText(),Double.parseDouble(txtSalary.getText())
                    )
            ){
                new Alert(Alert.AlertType.CONFIRMATION,"User Saved!").show();
                clearFields();
            }

        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING,"Try Again!").show();

        }


    }

    private void clearFields() {

        txtEmail.clear();
        txtName.clear();
        txtContact.clear();
        txtSalary.clear();

    }
}
