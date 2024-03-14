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
    @FXML
    ListView<String> view;
    @FXML
    Label freeSeatsText;
    public void field(){
        /*/
        List<String> movies = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\javaprojekty\\filmy\\zoznamfilmov.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                movies.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ObservableList<String> observableList = FXCollections.observableArrayList(movies);
        view.setItems(observableList);
/*/
    }
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
    public void movieWindow(){
        String selectedItem = view.getSelectionModel().getSelectedItem();
        if(selectedItem!=null) {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(CinemaApp.class.getResource("cinema.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                stage.setTitle(selectedItem);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.setAlwaysOnTop(false);
                stage.show();
                CinemaController controller = fxmlLoader.getController();
                controller.Numbering();
                controller.start();
                freeSeatsText.setText("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void addMovie(){
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(CinemaApp.class.getResource("movieAddition.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 250, 150);
            stage.setTitle("Pridanie filmu");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(false);
            stage.showAndWait();
            field();
            freeSeatsText.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void freeSeats(){
        int x=0;
        String selectedItem = view.getSelectionModel().getSelectedItem();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\javaprojekty\\filmy\\"+selectedItem+".txt"));
        while (reader.readLine()!=null) {
            x++;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        freeSeatsText.setText(20-x+" Volnych miest");
    }
}
