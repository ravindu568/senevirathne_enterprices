package com.rudevelopers.pos.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.rudevelopers.pos.dao.dataBaseAccessCode;
import com.rudevelopers.pos.dto.CustomerDto;
import com.rudevelopers.pos.view.tm.CustomerTM;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
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
    public AnchorPane context;
    public TableView<CustomerTM> tbl;
    public JFXButton backtoHomtBtn;

    private String searchText=" ";
    public void initialize() throws SQLException, ClassNotFoundException {

//        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
//        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
//        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
//        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
//        colOperation.setCellValueFactory(new PropertyValueFactory<>("deleteBtn"));


//        loadAllCustomer(searchText);
    }

    private void loadAllCustomer(String searchText) throws SQLException, ClassNotFoundException {

        ObservableList<CustomerTM> observableList= FXCollections.observableArrayList();
        int counter=1;
        for(CustomerDto dto: dataBaseAccessCode.searchCustomers(searchText)){

            Button btn=new Button("Delete");
            CustomerTM tm=new CustomerTM(
                    counter,dto.getName(),dto.getEmail(),dto.getContact(),dto.getSalary(),btn
            );
            observableList.add(tm);
            counter++;

        }
        tbl.setItems(observableList);

    }

    public void btnSaveUpdateOnAction(ActionEvent actionEvent) {

        try{

            if(
                    dataBaseAccessCode.createCustomer(
                            txtEmail.getText(),txtName.getText(),txtContact.getText(),Double.parseDouble(txtSalary.getText())
                    )
            ){
                new Alert(Alert.AlertType.CONFIRMATION,"User Saved!").show();
                clearFields();
//                loadAllCustomer(searchText);
            }else{
                new Alert(Alert.AlertType.WARNING,"Didnt send").show();
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

    public void backtoHomeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("DashBoardForm");
    }
    public void setUi(String url) throws IOException {
        Stage stage= (Stage)context.getScene().getWindow();
        stage.centerOnScreen();
        stage.setScene(
                new Scene(FXMLLoader.load(getClass().getResource("../view/"+url+".fxml")))
        );

    }
}
