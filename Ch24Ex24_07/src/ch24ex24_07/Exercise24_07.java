/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch24ex24_07;

import java.util.LinkedList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author Austyn
 */
public class Exercise24_07 extends Application {
    //Class level variable
    protected static LinkedList<Integer> list = new LinkedList<>();
    private LinkedListView view = new LinkedListView();
    private Button btSearch = new Button("Search");
    private Button btInsert = new Button("Insert");
    private Button btDelete = new Button("Delete");
    private TextField tfNumber = new TextField();
    private TextField tfIndex = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5);
        hBox.getChildren().addAll(new Label("Enter a value: "),
                                  tfNumber,
                                  new Label("Enter an index: "),
                                  tfIndex,
                                  btSearch,
                                  btInsert,
                                  btDelete);
        hBox.setAlignment(Pos.CENTER);
        
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(view);
        borderPane.setBottom(hBox);
        
        Label lblStatus = new Label();
        borderPane.setTop(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
        
        //Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 800, 250);
        primaryStage.setTitle("Exercise24_07: Linked List Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        view.repaint();
        tfNumber.setPrefColumnCount(2);
        tfIndex.setPrefColumnCount(2);
        
        btSearch.setOnAction(e -> {
            lblStatus.setText("");
            if (!list.contains(Integer.parseInt(tfNumber.getText()))) {
                lblStatus.setText("Key is not in the list");
            }
            else {
                lblStatus.setText("Key is in the list");
            }
            view.repaint();
        });
        
        btInsert.setOnAction(e -> {
            lblStatus.setText("");
            if (tfIndex.getText().trim().length() > 0) {
                list.add(Integer.parseInt(tfIndex.getText()), Integer.parseInt(tfNumber.getText()));
            }
            else {
                list.add(Integer.parseInt(tfNumber.getText()));
            }
            view.repaint();
        });
        
        btDelete.setOnAction(e -> {
            lblStatus.setText("");
            if (!list.contains(Integer.parseInt(tfNumber.getText()))) {
                lblStatus.setText("Key is not in the list");
            }
            else {
                lblStatus.setText("Key is deleted from the list");
                list.remove(new Integer(Integer.parseInt(tfNumber.getText())));
                view.repaint();
            }
        });
    } //End of start
    
    public LinkedList<Integer> get_List() {
        return list;
    }
    
    public void set_List(LinkedList<Integer> theList) {
        this.list = theList;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
} //End of class
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Austyn
 */
class LinkedListView extends Pane {
    private int startingX = 20;
    private int startingY = 20;
    private int boxWidth = 50;
    private int boxHeight = 20;
    private int arrowLineLength = 30;
    private int hGap = 80;
    
    
    
    protected void repaint() {
        getChildren().clear();
        
        if (Exercise24_07.list.size() == 0) {         //Empty list - load head and tail
            getChildren().add(new Text(startingX, startingY, "head: null"));
            getChildren().add(new Text(startingX, startingY + 15, "tail: null"));
        } //End of if
        else {
            getChildren().add(new Text(startingX, startingY, "head"));
            
            int x = startingX + 30;
            int y = startingY + 20;
            
            drawArrowLine(startingX + 5, startingY, x, y);
            
            for (int i = 0; i < Exercise24_07.list.size(); i++) {
                Rectangle rectangle = new Rectangle(x, y, boxWidth, boxHeight);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                getChildren().add(rectangle);
                
                getChildren().add(new Line(x + arrowLineLength, y, x + arrowLineLength, y + boxHeight));
                
                if (i < Exercise24_07.list.size() - 1) {
                    drawArrowLine(x + 40, y + boxHeight / 2, x + hGap, y + boxHeight / 2);
                } //End of if
                
                getChildren().add(new Text(x + 10, y + 15, Exercise24_07.list.get(i) + ""));
                
                x = x + hGap;
            } //End of for
            
            getChildren().add(new Text(x, startingY, "tail"));
            drawArrowLine(x, startingY, x - hGap, y);
        } //End of else
    } //End of repaint
    
    public void drawArrowLine(double x1, double y1, double x2, double y2) {
        getChildren().add(new Line(x1, y1, x2, y2));
        
        //Find slope of the line
        double slope = ((((double) y1) - (double) y2))
                / (((double) x1) - (((double) x2)));
        
        double arctan = Math.atan(slope);
        
        //This will flip the arrow 45 off a
        //Perpindicular line at pt x2
        double set45 = 1.57 / 2;
        
        //Arrows should alway point towards i, not i + 1
        if (x1 < x2) {
            //Add 90 degrees to arrow lines
            set45 = -1.57 * 1.5;
        } //End of if
        
        //Set length of arrows
        int arrlen = 15;
        
        getChildren().add(new Line(x2, 
                                   y2, 
                                  (x2 +  (Math.cos(arctan + set45) * arrlen)), 
                                  (y2) + (Math.sin(arctan + set45) * arrlen)));
        
        getChildren().add(new Line(x2, 
                                   y2, 
                                  (x2 +  (Math.cos(arctan - set45) * arrlen)), 
                                  (y2) + (Math.sin(arctan - set45) * arrlen)));
    } //End of drawArrowLine
} //End of class LinkedListView