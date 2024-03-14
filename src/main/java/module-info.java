module com.example.smolicekcinema {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.smolicekcinema to javafx.fxml;
    exports com.example.smolicekcinema;
    exports patrik.smolicek.cinema;
    opens patrik.smolicek.cinema to javafx.fxml;
}