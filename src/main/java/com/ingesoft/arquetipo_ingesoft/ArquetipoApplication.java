package com.ingesoft.arquetipo_ingesoft;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ArquetipoApplication extends Application {
    @Override
    public void start(@SuppressWarnings("exports") Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("arquetipoview.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}