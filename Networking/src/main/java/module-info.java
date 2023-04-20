module com.example.networking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.networking to javafx.fxml;
    exports com.example.networking;
}