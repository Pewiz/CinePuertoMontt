package Model;
 /*
Modifiaciones desde el pc
*/

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/interfazPrincipal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    public void cambioEscena(ActionEvent event, String url) throws IOException{
        Parent loader = FXMLLoader.load(getClass().getResource(url));
        Scene scene = new Scene(loader);
        Stage stage = (Stage)  ((Node) event.getSource()).getScene().getWindow(); //Se accede a la ventana
        stage.setScene(scene);
        stage.show();
    }
    

    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
