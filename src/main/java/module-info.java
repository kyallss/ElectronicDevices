module org.example.electronicdevices {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.electronicdevices to javafx.fxml;
    exports org.example.electronicdevices;
}