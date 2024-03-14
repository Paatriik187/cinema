package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCustomerController {
    @FXML
    TextField Name;
    @FXML
    TextField Seat;
    @FXML
    Label error;
    @FXML
    Button cancel;

    public void addCustomer(){
        if(Seat.getText().isEmpty()||Integer.parseInt(Seat.getText())>20||Integer.parseInt(Seat.getText())<1){
        error.setText("Neplatné číslo sedačky");
        }
        else if(freeSeats(Integer.parseInt(Seat.getText()))){
            error.setText("Miesto zabrané");
        }
        else if(Name.getText().isEmpty()){
            error.setText("Napíšte meno");
        }
        else{
            Customer customer = new Customer(Integer.parseInt(Seat.getText()), Name.getText());
            SharedList.addList(customer);
            WriterReader.write(customer.toString(), Title());
            Stage stage = (Stage) Name.getScene().getWindow();
            stage.close();
        }
    }
    public void cancel(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
    public boolean freeSeats(int a){
        for (Customer customer : SharedList.getList()) {
            if(customer.getSeat()==a){
                return true;
            }
        }
        return false;
    }
    public String Title(){
        Stage stage = (Stage) Name.getScene().getWindow();
        return stage.getTitle();
    }
}
