import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Austyn
 */
public class DisplayClock extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        
        //Create the start and stop buttons
        Button btStart = new Button("Start");
        Button btStop = new Button("Stop");
        //Add the start and stop buttons to an HBox
        HBox hBox = new HBox(btStart, btStop);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setAlignment(Pos.CENTER);
        //Add the clock and hbox to a borderpane
        BorderPane borderPane = new BorderPane(clock, null, null, hBox, null);      
        
        EventHandler<ActionEvent> eventHandler = e -> {
            clock.setCurrentTime();
        };
        
        Timeline animation = new Timeline( 
         new KeyFrame(Duration.millis(1000), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        //Make the buttons stop and stop the clock when clicked.
        btStart.setOnAction(e -> animation.play());
        btStop.setOnAction(e -> animation.stop());
        
        primaryStage.setTitle("DisplayClock");
        //Place the borderpane with the clock and hbox in the scene
        primaryStage.setScene(new Scene(borderPane));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
