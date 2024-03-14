package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Label stav;

    static String user="admin";
    static String password="a";
    public void login(){
        if (usernameField.getText().equals(user) && passwordField.getText().equals(password)) {
            try {
                Stage movieSelection = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("movieSelection.fxml"));
                Scene scene = new Scene(loader.load(), 856, 680);
                movieSelection.setScene(scene);
                movieSelection.setTitle("Vyber filmu");
                movieSelection.setResizable(false);
                movieSelection.setAlwaysOnTop(false);
                movieSelection.show();
                MovieSelectionController controller = loader.getController();
                controller.field();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) stav.getScene().getWindow();
            stage.close();
        } else {
            stav.setText("Neplatné údaje!");
        }
    }
}
