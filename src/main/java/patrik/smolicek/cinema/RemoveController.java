package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemoveController {
    @FXML
    TextField field;

    public void remove(){
        Customer a = null;
        for (Customer customer : SharedList.getList()) {
            if (Integer.parseInt(field.getText())== customer.getSeat()){
                a= customer;
            }
        }
        SharedList.removeList(a, windowTitle());
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }
    public void close(){
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }
    public String windowTitle(){
        Stage stage = (Stage) field.getScene().getWindow();
        return stage.getTitle();
    }
}
