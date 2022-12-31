package Controller;

import Model.Main;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class IngresosPorSalaController implements Initializable {

    private Main cambioE = new Main();
    private Metodos method = new Metodos();
    @FXML
    private Button btPeli1, btPeli2, btPeli3, btAtrasIng;
    @FXML
    private TextArea  taxtoIngresoPorSala;
    @FXML
    private Label totalDineroPorSala, nCantidadBoletasPorSala;
    @FXML
    private Pane paneIngreoPorSala;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleBtAtrasIngAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazMenuIngresos.fxml");
    }

    @FXML
    private void handleBtPeli1Action(ActionEvent event) throws IOException {
        paneIngreoPorSala.setVisible(true);
        taxtoIngresoPorSala.setText(method.muestraContenido("sala1.txt"));
        totalDineroPorSala.setText(String.valueOf(method.costoPorSala(0)));
        nCantidadBoletasPorSala.setText(String.valueOf(method.getSumaCantidad(0)));
    }

    @FXML
    private void handleBtPeli2Action(ActionEvent event) throws IOException {
        paneIngreoPorSala.setVisible(true);
        taxtoIngresoPorSala.setText(method.muestraContenido("sala2.txt"));
        totalDineroPorSala.setText(String.valueOf(method.costoPorSala(1)));
        nCantidadBoletasPorSala.setText(String.valueOf(method.getSumaCantidad(1)));
    }

    @FXML
    private void handleBtPeli3Action(ActionEvent event) throws IOException {
        paneIngreoPorSala.setVisible(true);
        taxtoIngresoPorSala.setText(method.muestraContenido("sala3.txt"));
        totalDineroPorSala.setText(String.valueOf(method.costoPorSala(2)));
        nCantidadBoletasPorSala.setText(String.valueOf(method.getSumaCantidad(2)));
    }

}
