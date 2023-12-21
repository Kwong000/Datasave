module com.example.myfirstradapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.myfirstradapp to javafx.fxml;
    exports com.example.myfirstradapp;
}