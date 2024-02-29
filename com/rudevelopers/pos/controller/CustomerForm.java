package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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
    }
}
