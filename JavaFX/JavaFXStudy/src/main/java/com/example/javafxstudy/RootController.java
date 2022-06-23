package com.example.javafxstudy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {
    @FXML private TextField IDField;
    @FXML private TextField PWField;
    @FXML private Button btn1;
    @FXML private Button btn2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        btn1.setOnAction(e->handle1(e));
//        btn1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                String msg = "you typed: " + IDField.getText();
////                label.setText(msg);
//            }
//        });
//        btn2.setOnAction(e->handleBtn2Action(e));
    }


    public void handle1(ActionEvent e) {
        System.out.println("Login");
    }

    public void loginAction(ActionEvent e) {
        String inputID = IDField.getText();
        System.out.println(inputID);
        String inputPW = PWField.getText();
        System.out.println(inputPW);
    }
    public void abcAction(ActionEvent e){

    }
}
