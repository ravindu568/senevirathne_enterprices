package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/mydb","root","1234");
            String sql="INSERT INTO user VALUES (?,?)";

        }catch(ClassNotFoundException | SQLException){

        }



    }

    public void setUi(String url) throws IOException {
        Stage stage= (Stage)context.getScene().getWindow();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );
        stage.centerOnScreen();

    }
}
