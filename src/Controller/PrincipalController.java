package Controller;

import Model.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PrincipalController implements Initializable {

    
    private Main cambioE = new Main();
    private Metodos method = new Metodos();
    @FXML
    private Button btIngresos,btCatalogo,btSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO document why this method is empty
    }

    @FXML
    private void handleBtIngresosAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazMenuIngresos.fxml");
    }

    @FXML
    private void handleBtCatalogoAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazCatalogo.fxml");
    }

    @FXML
    private void handleBtSalirAction(ActionEvent event) {
       Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
       method.eliminarContenidoDelArchivoDeTexto("sala1.txt");
       method.eliminarContenidoDelArchivoDeTexto("sala2.txt");
       method.eliminarContenidoDelArchivoDeTexto("sala3.txt");
       method.eliminarContenidoDelArchivoDeTexto("totalSala.txt");
       stage.close();
    }

    

}
