package co.edu.uniquindio.gestionproyecto.gestionproyectofx.controller;

import co.edu.uniquindio.gestionproyecto.gestionproyectofx.model.Proyecto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProyectoController {

    @FXML
    private TextField txtId, txtNombre, txtCoste;

    @FXML
    private TableView<Proyecto> tblResultado;

    @FXML
    private TableColumn<Proyecto, String> colNombre, colID;

    @FXML
    private TableColumn<Proyecto, Float> colCoste;

    @FXML
    private Button btnAgregarProyecto;
    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnActualizar;

    private final ObservableList<Proyecto> listaProyectos = FXCollections.observableArrayList();

    @FXML
    void onAgregarProyecto(ActionEvent event) {
        if (txtNombre.getText().isEmpty() || txtId.getText().isEmpty() || txtCoste.getText().isEmpty()) {
            System.out.println("Error: Todos los campos son obligatorios.");
            return;
        }

        try {
            Proyecto proyecto = new Proyecto();
            proyecto.setNombreProyecto(txtNombre.getText());
            proyecto.setCodigoProyecto(txtId.getText());
            proyecto.setCosteProyecto(Float.parseFloat(txtCoste.getText()));

            listaProyectos.add(proyecto);

            txtNombre.clear();
            txtId.clear();
            txtCoste.clear();
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido en el campo de coste.");
        }
    }
    @FXML
    void onActualizarProyecto(ActionEvent event) {
        String idProyecto = txtId.getText().trim(); // Obtener ID

        if (idProyecto.isEmpty() || txtNombre.getText().isEmpty() || txtCoste.getText().isEmpty()) {
            System.out.println(" Error: Todos los campos son obligatorios para actualizar.");
            return;
        }

        try {
            float nuevoCoste = Float.parseFloat(txtCoste.getText().trim()); // Convertir coste a float
            Proyecto proyectoAActualizar = buscarProyecto(idProyecto);

            if (proyectoAActualizar != null) {
                proyectoAActualizar.setNombreProyecto(txtNombre.getText().trim());
                proyectoAActualizar.setCosteProyecto(nuevoCoste);
                tblResultado.refresh(); // Refrescar la tabla
                System.out.println(" Proyecto actualizado correctamente.");
                txtId.clear();
                txtNombre.clear();
                txtCoste.clear();
            } else {
                System.out.println(" Error: No se encontró un proyecto con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println(" Error: El coste debe ser un número válido.");
        }
    }

    @FXML
    void onEliminarProyecto(ActionEvent event) {
        String idProyecto = txtId.getText().trim(); // Obtener el ID ingresado

        if (idProyecto.isEmpty()) {
            System.out.println(" Error: Ingresa un ID válido para eliminar.");
            return;
        }

        Proyecto proyectoAEliminar = buscarProyecto(idProyecto);

        if (proyectoAEliminar != null) {
            listaProyectos.remove(proyectoAEliminar); // Eliminar el proyecto
            System.out.println(" Proyecto eliminado correctamente.");
            txtId.clear(); // Limpiar campo de ID
        } else {
            System.out.println(" Error: No se encontró un proyecto con ese ID.");
        }
    }


    @FXML
    void initialize() {
        colID.setCellValueFactory(new PropertyValueFactory<>("codigoProyecto"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreProyecto"));
        colCoste.setCellValueFactory(new PropertyValueFactory<>("costeProyecto"));

        tblResultado.setItems(listaProyectos);
    }
    private Proyecto buscarProyecto(String codigoProyecto) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getCodigoProyecto().equals(codigoProyecto)) {
                return proyecto;
            }
        }
        return null;
    }
}

