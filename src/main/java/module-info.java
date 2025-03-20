module co.edu.uniquindio.gestionproyecto.gestionproyectofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gestionproyecto.gestionproyectofx to javafx.fxml;
    exports co.edu.uniquindio.gestionproyecto.gestionproyectofx;
    opens co.edu.uniquindio.gestionproyecto.gestionproyectofx.controller;
    exports co.edu.uniquindio.gestionproyecto.gestionproyectofx.controller;
    opens co.edu.uniquindio.gestionproyecto.gestionproyectofx.model to javafx.base;
}