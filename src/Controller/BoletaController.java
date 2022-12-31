
package Controller;

import Model.Main;
import Model.Boleta;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;

public class BoletaController implements Initializable {
    
    private Main cambioE = new Main();
    private Metodos method = new Metodos();
    @FXML
    private Button btImprimir;
    @FXML
    private Label nombrePelicula;
    @FXML
    private Label fecha;
    @FXML
    private Label nTransaccion;
    @FXML
    private Label nSala;
    @FXML
    private Label horario;
    @FXML
    private Label coordenadaAsientos;
    @FXML
    private Label nPersona;
    @FXML
    private Label totalPrecioBoleta;
    private int numeroSala;

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
       Boleta bol = method.boleta();
       
       nombrePelicula.setText(bol.getNombrePelicula());
       fecha.setText(bol.getFecha());
       nTransaccion.setText(String.valueOf(bol.getId()));
       nSala.setText(String.valueOf(bol.getSala()));
       horario.setText(bol.getHorario());
       coordenadaAsientos.setText(bol.getAsiento());
       nPersona.setText(String.valueOf(bol.getCosto()/3000));
       totalPrecioBoleta.setText(String.valueOf(bol.getCosto()));
       
       numeroSala=bol.getSala();
    }    


    @FXML
    private void handleBtImprimirAction(ActionEvent event) throws IOException {
        method.ventaPorSala(numeroSala);
        //JOptionPane.showMessageDialog(null, "IMPRIMIDO");
        cambioE.cambioEscena(event, "/View/interfazCatalogo.fxml");
    }
    
}
