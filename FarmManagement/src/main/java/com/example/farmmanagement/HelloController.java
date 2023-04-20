package com.example.farmmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField ageTF;

    @FXML
    private TextField ccodeTF;

    @FXML
    private TextField colorTF;

    @FXML
    private Button csubBT;

    @FXML
    private TextField heightTF;

    @FXML
    private Button regBT;

    @FXML
    private TextField weightTF;
    private Object root;
    private Stage stage;
    private Scene scene;

    @FXML
    void csubBT(MouseEvent event) throws IOException{
        String code=ccodeTF.getText();
        root= FXMLLoader.load(HelloApplication.class.getResource("CattleCode.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void regBT(MouseEvent event) throws IOException {
        root= FXMLLoader.load(HelloApplication.class.getResource("Resistre.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene((Parent) root);
        stage.setScene(scene);
        stage.show();




    }

}
