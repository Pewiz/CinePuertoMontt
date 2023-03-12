
package Controller;

import Model.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;



public class CatalogoController implements Initializable {

    @FXML
    private Button btSpiderMan, btAtras, btJohnWick, btCars;
    private Main cambioE = new Main();
    private Metodos metodos = new Metodos();


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      // TODO document why this method is empty
    }    

    @FXML
    private void handlebtSpiderManAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazSalas.fxml");
        metodos.setSala(0);
        
    }

    @FXML
    private void handleJohnWickAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazSalas.fxml");
        metodos.setSala(1);
    }

    @FXML
    private void handlebtCarsAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazSalas.fxml");
        metodos.setSala(2);
    }
    @FXML
    private void handlebtAtrasAction(ActionEvent event) throws IOException {
        cambioE.cambioEscena(event, "/View/interfazPrincipal.fxml");
    }
    
}
