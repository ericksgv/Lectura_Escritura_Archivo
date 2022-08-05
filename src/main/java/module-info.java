module com.ingesoft.arquetipo_ingesoft {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ingesoft.arquetipo_ingesoft to javafx.fxml;
    exports com.ingesoft.arquetipo_ingesoft;
}