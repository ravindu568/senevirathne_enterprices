package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.rudevelopers.pos.dao.dataBaseAccessCode;
import com.rudevelopers.pos.dto.UserDto;
import com.rudevelopers.pos.util.PasswordManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class LoginForm {
    public JFXPasswordField txtPassword;
    public JFXTextField txtEmail;
    public AnchorPane context;

    public void btnCreateAnAccountOnAction(ActionEvent actionEvent) throws IOException {

        setUi("SignUp");
    }

    public void btnSignInOnAction(ActionEvent actionEvent) {

        try{

            UserDto ud= dataBaseAccessCode.findUser(txtEmail.getText());
            if(ud!=null){

                if(PasswordManager.passChecker(txtPassword.getText(),ud.getPassword())){

                    System.out.println("Completed");
                    setUi("DashBoardForm");


                }else{

                    new Alert(Alert.AlertType.WARNING,"Check your password and Try Again").show();

                }
            }else{
                new Alert(Alert.AlertType.WARNING,"Try Again!").show();
            }


        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING,"Try Again!").show();

        } catch (IOException e) {
            throw new RuntimeException(e);
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
