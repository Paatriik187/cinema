package patrik.smolicek.cinema;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class AdditionController {
    @FXML
    TextField field;
    public void addMovie() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\javaprojekty\\filmy\\zoznamfilmov.txt"));
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\javaprojekty\\filmy\\zoznamfilmov.txt",true));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\javaprojekty\\filmy\\"+field.getText()+".txt", true));
            if(reader.readLine()==null){
                writer2.write(field.getText());
            }
            else{
                writer2.write("\n"+field.getText());
            }
            writer2.close();
            Stage stage = (Stage) field.getScene().getWindow();
            stage.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
    public void cancel(){
        Stage stage = (Stage) field.getScene().getWindow();
        stage.close();
    }
}
