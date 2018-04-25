import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austyn
 */
public class RaiseFlag extends Application {
    
    Pane pane = new Pane();
    ImageView imageView = new ImageView("american-flag.gif");
    
    @Override
    public void start (Stage primaryStage) {
        
        pane.getChildren().add(imageView);
        imageView.setX(100);
        imageView.setY(300);
        
        setrun();
        
        Scene scene = new Scene(pane, 300, 400);
        primaryStage.setTitle("Flag Rising");
        primaryStage.setScene(scene);
        primaryStage.show();        
    } //End of start
    
    public void setrun() {
        new Thread(() -> {
            try {
                while (true) {
                    Platform.runLater(() ->
                        imageView.setY(imageView.getY() - 1)); //Sets how far the flag moves every time it moves
                    Thread.sleep(1000); //Sets the speed the flag moves
                } //End of while
            } //End of try
            catch (InterruptedException ex) {
                    } //End of catch
        }).start(); //End of new runnable in thread
    } //End of setrun
    public static void main(String[] args) {
        Application.launch(args);
    } //End of main
} //End of class
