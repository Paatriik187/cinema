module com.example.smolicekcinema {
    requires javafx.controls;
    requires javafx.fxml;


    exports patrik.smolicek.cinema;
    opens patrik.smolicek.cinema to javafx.fxml;
}