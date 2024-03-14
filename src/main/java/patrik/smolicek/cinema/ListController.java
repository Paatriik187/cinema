package patrik.smolicek.cinema;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Comparator;

public class ListController {
    @FXML
    ListView view;
    public void vyp(){
        ObservableList<Customer> observableList= FXCollections.observableArrayList(SharedList.getList());
        observableList.sort(Comparator.comparingInt(Customer::getSeat));
        view.setItems(observableList);
    }
}
