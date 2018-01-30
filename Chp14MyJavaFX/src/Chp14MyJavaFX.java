/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 *
 * @author Austyn
 */
public class Chp14MyJavaFX extends Application {
    
@Override   //Override the start method in the Appication class

    public void start(Stage primaryStage) {
        
        //Create a button and place it in the scene
        Button btOK = new Button("OK");
        Scene scene = new Scene(btOK, 200, 250);
        
        primaryStage.setTitle("MyJavaFX"); //Set the title
        primaryStage.setScene(scene); //Set the scene
        primaryStage.show(); //Set the stage
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
