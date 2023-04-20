package com.example.farmmanagement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CattleCodeApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ResistreApplication.class.getResource("CattleCode.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Cattle Code!!!");
        stage.setScene(scene);
        stage.show();
    }
}
