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
public class MultipleStageDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create a scene and place a button in the scene
        Scene scene = new Scene(new Button("OK"), 200, 250);
        
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Stage stage = new Stage();
        stage.setTitle("Second Stage");
        stage.setScene(new Scene(new Button("New Stage"), 200, 250));
        stage.show();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
