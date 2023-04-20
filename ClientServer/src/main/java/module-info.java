module com.example.clientserver {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clientserver to javafx.fxml;
    exports com.example.clientserver;
}