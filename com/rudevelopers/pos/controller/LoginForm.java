package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {
    public JFXPasswordField txtPassword;
    public JFXTextField txtEmail;
    public AnchorPane context;

    public void btnCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {

        setUi("SignUp");
    }

    public void btnSignInOnAction(ActionEvent actionEvent) {
    }

    public void setUi(String url) throws IOException {
       Stage stage= (Stage)context.getScene().getWindow();
       stage.setScene(
               new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
       );
       stage.centerOnScreen();

    }
}
