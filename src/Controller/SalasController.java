package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Model.Main;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.scene.layout.GridPane;
import Model.Sala;
import Controller.Metodos;

public class SalasController implements Initializable {

    @FXML
    private Button btVermut;
    @FXML
    private Button btMatine;
    @FXML
    private Button btAtrasAsientos;
    @FXML
    private Button btVespertino;
    private Main cambioE = new Main();
    private Metodos metodos = new Metodos();

    private Sala metodosSala = new Sala();
    @FXML
    private GridPane gridPane = new GridPane();
    private int contadorAsiento;
    @FXML
    private Button btBoleta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleBtMatineAction(ActionEvent event) {
        gridPane.setVisible(true);
        metodos.salaHorarioYAsientos(0);
        pintarAsientos();
    }

    @FXML
    private void handleBtVermutAction(ActionEvent event) {
        gridPane.setVisible(true);
        metodos.salaHorarioYAsientos(1);
        pintarAsientos();
    }

    @FXML
    private void handleBtVespertinoAction(ActionEvent event) {
        gridPane.setVisible(true);
        metodos.salaHorarioYAsientos(2);
        pintarAsientos();
    }

    @FXML
    private void handleBtAtrasAsientosAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazCatalogo.fxml");
    }

    @FXML
    private void handleBtBoletaAction(ActionEvent event) throws IOException {
        metodos.setTotalBoleta(contadorAsiento);
        cambioE.cambioEscena(event, "/View/interfazBoleta.fxml");
        contadorAsiento = 0;
    }

    @FXML
    private void handleAsientosAction(ActionEvent event) {
        Node node = (Node) event.getTarget();
        int x = gridPane.getRowIndex(node) == null ? 0 : gridPane.getRowIndex(node);
        int y = gridPane.getColumnIndex(node) == null ? 0 : gridPane.getColumnIndex(node);

        Metodos.salas[Metodos.sala].asignarXeY(x, y);
        if (metodosSala.verificarPosicionTabla(x, y) == true) {
            metodos.asientosSeleccionados(x, y);
            node.setStyle("-fx-background-color:green");
            contadorAsiento++;
        }
        Metodos.salas[Metodos.sala].seleccionarAsientos();
    }

    private void pintarAsientos() {
        gridPane.getChildren().forEach((Node node) -> {

            int rowIndex = gridPane.getRowIndex(node) == null ? 0 : gridPane.getRowIndex(node);

            int columnIndex = gridPane.getColumnIndex(node) == null ? 0 : gridPane.getColumnIndex(node);

            if (metodosSala.verificarPosicionTabla(rowIndex, columnIndex) == true) {
                node.setStyle("-fx-background-color:white");
            } else if (metodosSala.verificarPosicionTabla(rowIndex, columnIndex) == false) {
                node.setStyle("-fx-background-color:red");
            }

        });

    }

}
