module org.example.guiaparaprueba2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.guiaparaprueba2 to javafx.fxml;
    exports org.example.guiaparaprueba2;
}