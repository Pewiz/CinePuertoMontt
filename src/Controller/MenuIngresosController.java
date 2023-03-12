
package Controller;

import Model.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MenuIngresosController implements Initializable {
    private Main cambioE = new Main();
    @FXML
    private Button btIngresosSala,btIngresosTotales,btAtrasMenuIngresos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO document why this method is empty
    }    

    @FXML
    private void handleBtIngresosSalaAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazIngresosPorSala.fxml");
    }

    @FXML
    private void handleBtIngresosTotalesAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazIngresosTotales.fxml");
    }

    @FXML
    private void handleBtAtrasMenuIngresosAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazPrincipal.fxml");
    }
    
}
