import javafx.animation.Animation;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Austyn
 */
public class RacingCar extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Create the panes
        Pane pane = new Pane();
        HBox hBox = new HBox();
        
        //Add the car and buttons
        Image image = new Image ("car.jpg");
        ImageView imageView = new ImageView(image);
        Line line = new Line(-500, 100, 2000, 100);
        line.setStroke(Color.WHITE);
        Button bt = new Button("Pause/Resume");
        hBox.setAlignment(Pos.CENTER);
        
        //Place the car and buttons into the panes
        pane.getChildren().addAll(line,imageView);
        hBox.getChildren().add(bt);
        //Place the panes into a BorderPane
        //BorderPane(Node center, Node top, Node right, Node bottom, Node left)
        BorderPane bp = new BorderPane(hBox, null, null, pane, null);
        
        //Set the path the car will move on
        PathTransition pt = new PathTransition();
        pt.setDuration(new Duration(2000));
        pt.setPath(line);
        pt.setNode(imageView);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        //Add the event for up and down arrow keys to increase and decrease speed
        bp.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pt.setRate(pt.getRate() + 1);
                }
            if (e.getCode() == KeyCode.DOWN) {
                pt.setRate(pt.getRate() - 1);
            }
        });
        
        //Give the button the pause and play action
        bt.setOnMousePressed(e -> pt.pause());
        bt.setOnMouseReleased(e -> pt.play());
        
        Scene scene = new Scene(bp, 1700, 400);
        primaryStage.setTitle("Racing Car");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        bp.requestFocus();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
