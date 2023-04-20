package com.example.farmmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResistreApplication extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResistreApplication.class.getResource("Resistre.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cattle Deatails!!!");
        stage.setScene(scene);
        stage.show();
    }
}
