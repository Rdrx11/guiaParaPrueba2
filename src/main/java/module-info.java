module org.example.guiaparaprueba2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens org.example.guiaparaprueba2 to javafx.fxml;

    opens org.example.guiaparaprueba2.Model to javafx.base, javafx.fxml, com.google.gson;

    opens org.example.guiaparaprueba2.controller to javafx.fxml;

    exports org.example.guiaparaprueba2;
}