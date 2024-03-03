package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.rudevelopers.pos.dao.dataBaseAccessCode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class SignUp {
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public AnchorPane context;

    public void btnAlreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoginForm");
    }

    public void btnRegisterNowOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        try{

            if(dataBaseAccessCode.createUser(txtEmail.getText(),txtPassword.getText())){
                new Alert(Alert.AlertType.CONFIRMATION,"User Saved!").show();
                clearFields();
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();
            }


        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING,"Try Again!").show();

        }



    }

    private void clearFields() {

        txtEmail.clear();
        txtPassword.clear();
    }

    public void setUi(String url) throws IOException {
        Stage stage= (Stage)context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );

    }
}
