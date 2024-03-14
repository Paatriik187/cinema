package patrik.smolicek.cinema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginApp extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginApp.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(false);
            stage.show();

        }

        public static void main(String[] args) {launch();}
}
