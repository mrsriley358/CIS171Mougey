/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Austyn
 */
public class Exc_14_7 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        int ver = 0;
        int hor = 0;
        int check = 1; 
        
        //Create the GridPane and its properties
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.4));
        pane.setHgap(2);
        pane.setVgap(2);
        
        //Create the text boxes in the grid pane using a loop to create the 10 by 10 and adding a random 0 or 1.
        while (check == 1) {
            int rNum =(Math.random()<0.5)?0:1;
            pane.add(new TextField(Integer.toString(rNum)), ver, hor);
            ver++;
            if (ver == 10) {
                ver = 0;
                hor++;
                if (hor == 10) {
                    check = 0;
                }
            }
        }
        
        //Add and display the scene
        Scene scene = new Scene(pane, 500, 360);
        
        primaryStage.setTitle("Exc_14.7");
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
