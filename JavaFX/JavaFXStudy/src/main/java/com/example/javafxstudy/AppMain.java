package com.example.javafxstudy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;

public class AppMain extends Application {
    public static void main(String[] args) {
        launch(args); // 메인 윈도우 생성
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("로그인 화면입니다!");
        primaryStage.setScene(scene);
        primaryStage.show(); // 메인 윈도우 보여짐
//
//        Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
//        Scene sc = new Scene(hello-view);
//        ps.setTitle("로그인");
//        ps.setScene(sc);
//        ps.show();
//
//
    }
}
