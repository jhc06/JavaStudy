package com.java.JDBC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
    @FXML private TextField IDField;
    @FXML private PasswordField PWField;
    @FXML private TextField nameField;
    @FXML private Button btnCreate;
    @FXML private Button btnLogin;
    @FXML private Button btnChange;
    @FXML private Button btnClose;
    @FXML private TextField nameFieldNew;
    private OracleDAO od;
    private LoginInfo info;


    //// 입력한 ID와PW를 DB와 비교 후 일치 시 로그인 성공. 실패 시 실패 창(Select문)
    public void btnLogin(ActionEvent e){
        // info는 Client로부터 입력된 값을 저장한 객체.
        info = new LoginInfo(IDField.getText(), PWField.getText(), nameField.getText(), nameFieldNew.getText());

        if(od.login(info)==1){
            System.out.println("로그인하였습니다. 로그인된 Main page로 이동");
        } else if(od.login(info)==0) {
            System.out.println("로그인에 실패하였습니다. 로그인 화면으로 이동");
        } else if(od.login(info)==-1){
            System.out.println("오류가 발생하였습니다. 로그인 화면으로 이동");
        }
    }

    // 입력한 ID,PW, NAME을 DB와 비교 후 일치 시 DB의 비밀번호를 변경(Update문)
    public void btnChange(ActionEvent e){
        info = new LoginInfo(IDField.getText(), PWField.getText(), nameField.getText(), nameFieldNew.getText());

        if(od.loginChangeAccount(info)==1){
            System.out.println("비밀번호를 정상적으로 변경하였습니다. 메인 화면으로 이동");
        } else if(od.loginChangeAccount(info)==0) {
            System.out.println("일치하는 정보가 찾을 수 없습니다. 로그인 화면으로 이동");
        } else if(od.loginChangeAccount(info)==-1){
            System.out.println("오류가 발생하였습니다. 로그인 화면으로 이동");
        }
    }

    // 입력한 ID, PW, NAME을 DB와 비교 후 기존ID와 중복 시 실패. 미 중복 시 정보 입력(INSERT문)
    public void btnCreate(ActionEvent e){
        info = new LoginInfo(IDField.getText(), PWField.getText(), nameField.getText(), nameFieldNew.getText());

        if(od.loginCreateAccount(info)==1){
            System.out.println("가입에 성공하였습니다. 메인 화면으로 이동");
        } else if(od.loginCreateAccount(info)==0) {
            System.out.println("이미 가입된 아이디입니다. 로그인 화면으로 이동");
        } else if(od.loginCreateAccount(info)==-1){
            System.out.println("오류가 발생하였습니다. 로그인 화면으로 이동");
        }
    }

    // 입력한 ID, PW, NAME을 DB와 비교 후 일치 시 정보 삭제(DELETE문)
    public void btnClose(ActionEvent e){
        info = new LoginInfo(IDField.getText(), PWField.getText(), nameField.getText(), nameFieldNew.getText());

        if(od.loginCloseAccount(info)==1){
            System.out.println("계정을 정상적으로 삭제하였습니다. 메인 화면으로 이동");
        } else if(od.loginCloseAccount(info)==0) {
            System.out.println("일치하는 정보를 찾을수 없습니다. 로그인 화면으로 이동");
        } else if(od.loginCloseAccount(info)==-1){
            System.out.println("오류가 발생하였습니다. 로그인 화면으로 이동");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        od = new OracleDAO();
        od.connect();
        btnLogin.setOnAction(e->{
            try{
                btnLogin(e);
            } catch (Exception e1){
            }
        });
        btnCreate.setOnAction(e->{
            try{
                btnCreate(e);
            } catch (Exception e1){
            }
        });
        btnChange.setOnAction(e->{
            try{
                btnChange(e);
            } catch (Exception e1){
            }
        });

        btnClose.setOnAction(e->{
            try{
                btnClose(e);
            } catch (Exception e1){
            }
        });
    }
}
