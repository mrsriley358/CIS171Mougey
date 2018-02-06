/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.*;
import javafx.scene.control.*;

/**
 *
 * @author Austyn
 */
public class Ch_14GUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Create pane to hold image views
        Pane pane = new StackPane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image image = new Image("hylian_crest_by_miraclegrowafro-d5uv0n8.jpg");
        pane.getChildren().add(new ImageView(image));
        
        Button btn = new Button();
        btn.setText("Navi");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
        @Override
        public void handle(ActionEvent event) {
            System.out.println("HEY LISTEN!");
            }
        });
        
        pane.getChildren().add(btn);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Hylian Crest");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
