package patrik.smolicek.cinema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CinemaApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CinemaApp.class.getResource("cinema.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Kino listky");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(false);
        stage.show();
        CinemaController controller = fxmlLoader.getController();
        controller.Numbering();
        controller.start();

    }

    public static void main(String[] args) {launch();}
}
