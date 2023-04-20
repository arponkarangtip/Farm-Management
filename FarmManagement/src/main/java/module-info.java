module com.example.farmmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.farmmanagement to javafx.fxml;
    exports com.example.farmmanagement;
}