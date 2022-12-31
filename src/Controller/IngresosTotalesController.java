
package Controller;

import Model.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;


public class IngresosTotalesController implements Initializable {
    private Main cambioE = new Main();
    private Metodos method = new Metodos();
    
    @FXML
    private Button btAtrasIngresosTotales;
    @FXML
    private Pane paneIngreoPorSala;
    @FXML
    private Label totalDineroTotales;
    @FXML
    private Label nCantidadBoletasTotales;
    @FXML
    private TextArea taxtoIngresoTotal;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        totalDineroTotales.setText(String.valueOf(method.costoTotal()));
        nCantidadBoletasTotales.setText(String.valueOf(method.getCantidadTotalBoleta()));
        try {
            taxtoIngresoTotal.setText(method.muestraContenido("totalSala.txt"));
        } catch (IOException ex) {
            Logger.getLogger(IngresosTotalesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleBtAtrasIngresosTotalesAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazMenuIngresos.fxml");
    }
    
}
