package co.edu.uniquindio.gestionproyecto.gestionproyectofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GestionController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("hola gente hermosa");
    }
}