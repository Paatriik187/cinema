package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MovieSelectionController {
    public void runmov(MouseEvent event){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(CinemaApp.class.getResource("cinema.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle(((Node) event.getSource()).getId());
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(false);
            stage.show();
            CinemaController controller = fxmlLoader.getController();
            controller.Numbering();
            controller.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
