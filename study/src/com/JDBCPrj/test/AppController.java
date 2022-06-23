package com.JDBCPrj.test;

import com.JDBCPrj.DBManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class AppController implements Initializable {
    DBManager dbm = new DBManager();
    @FXML private TextField IDField;
    @FXML private TextField PWField;
    @FXML private Button btn1;
    @FXML private Button btn2;

    private String userName, userID, userPW;

    public AppController(String userID, String userPW){
        this.userID = userID;
        this.userPW = userPW;
    }

    public void loginAction(ActionEvent e) {
        dbm.getConnection();
        dbm.login(IDField.getText(), PWField.getText());
        dbm.close();
    }
    public void abcAction(ActionEvent e){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public String getUserName(){return userName;}
    public String getUserID(){return userID;}
    public String getUserPW(){return userPW;}
}

