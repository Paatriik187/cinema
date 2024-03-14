package patrik.smolicek.cinema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MovieSelectionApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MovieSelectionApp.class.getResource("movieSelection.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 856, 680);
        stage.setTitle("Vyber filmu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setAlwaysOnTop(false);
        stage.show();
        MovieSelectionController controller = fxmlLoader.getController();
        controller.field();
    }

    public static void main(String[] args) {launch();}
}
