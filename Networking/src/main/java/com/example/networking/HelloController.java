package com.example.networking;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private HBox HBOX;

    @FXML
    private ScrollPane SCROLPAN;

    @FXML
    private VBox VBOX;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button eBT;

    @FXML
    private TextField eTF;

    @FXML
    private Label lable;
    private Server server;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            server = new Server(new ServerSocket(1234));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Finding");
        }
        VBOX.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                SCROLPAN.setVvalue((Double) newValue);
            }
        });
        server.receiveMessageFromClient(VBOX);
        eBT.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String massage = eTF.getText();
                if (!massage.isEmpty()) {
                    HBox hbox = new HBox();
                    hbox.setAlignment(Pos.CENTER_RIGHT);
                    hbox.setPadding(new Insets(5, 5, 5, 10));
                    Text text = new Text(massage);
                    TextFlow textFlow = new TextFlow(text);
                    textFlow.setPadding(new Insets(5, 10, 5, 10));
                    text.setFill(Color.color(0.934, 0.945, 0.996));
                    hbox.getChildren().add(textFlow);
                    VBOX.getChildren().add(hbox);
                    server.sendMessageToClient(massage);
                    eTF.clear();
                }
            }
        });

    }
    public static void addLabel(String massage,VBox vbox){
        HBox hBox=new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.setPadding(new Insets(5,5,5,10));
        Text text=new Text(massage);
        TextFlow textFlow=new TextFlow(text);
        textFlow.setPadding(new Insets(5,10,5,10));
        hBox.getChildren().add(textFlow);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                vbox.getChildren().add(hBox);
            }
        });
    }


}

