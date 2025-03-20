module co.edu.uniquindio.gestionproyecto.gestionproyectofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gestionproyecto.gestionproyectofx to javafx.fxml;
    exports co.edu.uniquindio.gestionproyecto.gestionproyectofx;
}