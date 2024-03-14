package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class CinemaController {
    @FXML
    Text Seats;
    @FXML
    Text Numbering1;
    @FXML
    Text Numbering2;
    @FXML
    Text Numbering3;
    @FXML
    Text Numbering4;
// ▫ ▪
    static String freeSeats ="▫ ▫ ▫ ▫ ▫ \n▫ ▫ ▫ ▫ ▫ \n▫ ▫ ▫ ▫ ▫ \n▫ ▫ ▫ ▫ ▫";
    static String[] pole = freeSeats.split(" ");
    public void start(){
        SharedList.list(windowTitle());
        update();
    }


    public void customerAdditionWindow(){
            try {
                Stage addStage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("customerAddition.fxml"));
                Scene scene = new Scene(loader.load(), 400, 300);
                addStage.setScene(scene);
                addStage.setTitle(windowTitle());
                addStage.setResizable(false);
                addStage.setAlwaysOnTop(false);
                addStage.showAndWait();
                update();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void customerRemovalWindow(){
        try {
            Stage removeStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerRemoval.fxml"));
            Scene scene = new Scene(loader.load(), 200, 100);
            removeStage.setScene(scene);
            removeStage.setTitle(windowTitle());
            removeStage.setResizable(false);
            removeStage.setAlwaysOnTop(false);
            removeStage.showAndWait();
            update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void customerListWindow(){
        try {
            Stage listStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("customerList.fxml"));
            Scene scene = new Scene(loader.load(), 400, 300);
            listStage.setScene(scene);
            listStage.setTitle(windowTitle());
            listStage.setResizable(false);
            listStage.setAlwaysOnTop(false);
            ListController controller = loader.getController();
            listStage.show();
            controller.vyp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void update(){
        pole = freeSeats.split(" ");
        for (Customer customer : SharedList.getList()) {
            if(pole[customer.getSeat() - 1].equals("\n▫")) {pole[customer.getSeat() - 1] = "\n▪";}
            else{pole[customer.getSeat() - 1] = "▪";}
        }
        Seats.setText(fieldToString(pole));
    }
    private static String fieldToString(String[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);

            if (i < array.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
    public void Numbering(){
        Numbering1.setText("01   02   03   04   05");
        Numbering2.setText("06   07   08   09   10");
        Numbering3.setText("11   12   13   14   15");
        Numbering4.setText("16   17   18   19   20");
    }
    public String windowTitle(){
        Stage stage = (Stage) Numbering1.getScene().getWindow();
        return stage.getTitle();
    }

}
