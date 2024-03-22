package patrik.smolicek.cinema;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class CinemaController {
    @FXML
    Pane p01,p02,p03,p04,p05,p06,p07,p08,p09,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20;
    @FXML
    Rectangle rec1,rec2,rec3,rec4,rec5,rec6,rec7,rec8,rec9,rec10,rec11,rec12,rec13,rec14,rec15,rec16,rec17,rec18,rec19,rec20;

    public void start(){
        SharedList.list(windowTitle());
        update();
    }


    public void customerAdditionWindow(javafx.scene.input.MouseEvent event){
                Rectangle clickedRectangle = (Rectangle) event.getSource();
                int intValue = Integer.parseInt(clickedRectangle.getId().substring(3));
                Color color=(Color) clickedRectangle.getFill();
                if(!color.equals(Color.BLACK)){
                    try {
                    Stage addStage = new Stage();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customerAddition.fxml"));
                    Scene scene = new Scene(loader.load(), 400, 300);
                    addStage.setScene(scene);
                    addStage.setTitle(windowTitle());
                    addStage.setResizable(false);
                    addStage.setAlwaysOnTop(false);
                    AddCustomerController controller = loader.getController();
                    controller.SetSeatNumber(intValue);
                    addStage.showAndWait();
                    update();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }
    public void customerRemovalWindow(){
        try {
            Stage removeStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customerRemoval.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customerList.fxml"));
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
        Rectangle[] rectangles={rec1,rec2,rec3,rec4,rec5,rec6,rec7,rec8,rec9,rec10,rec11,rec12,rec13,rec14,rec15,rec16,rec17,rec18,rec19,rec20};
        for(int x=0;x<20;x++){
            rectangles[x].setFill(Color.WHITE);
        }
        for (Customer customer : SharedList.getList()) {
            rectangles[customer.getSeat() - 1].setFill(Color.BLACK);
        }

    }
    public void selected(MouseEvent fxEvent){
        Rectangle rectangle = (Rectangle) fxEvent.getSource();
        Color color= (Color) rectangle.getFill();
        if(color.equals(Color.WHITE)) {
            rectangle.setFill(Color.LIGHTBLUE);
        }
    }
    public void unselect(MouseEvent fxEvent){
        Rectangle rectangle = (Rectangle) fxEvent.getSource();
        Color color= (Color) rectangle.getFill();
        if(color.equals(Color.LIGHTBLUE)) {
            rectangle.setFill(Color.WHITE);
        }
    }

    public String windowTitle(){
        Stage stage = (Stage) rec1.getScene().getWindow();
        return stage.getTitle();
    }

}
