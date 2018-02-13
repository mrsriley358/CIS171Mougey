/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Austyn
 */
public class Unit_1HandsOn extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Create a circle that will be the head
        Circle head = new Circle();
        head.setCenterX(400);
        head.setCenterY(200);
        head.setRadius(50);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        
        //Create a line that will be the body
        Line body = new Line(400, 250, 400, 450);
        
        //Create lines that will be left and right arms and the left and right legs
        Line lArm = new Line(400, 300, 300, 375);
        Line rArm = new Line(400, 300, 500, 375);
        Line lLeg = new Line(400, 450, 300, 525);
        Line rLeg = new Line(400, 450, 500, 525);
        
        //Create the rope
        Line rope = new Line(400, 150, 400, 100);
        
        //Create the hanging stand
        Line horLine = new Line(400, 100, 200, 100);
        Line verLine = new Line(200, 100, 200, 650);
        Arc base = new Arc(200, 700, 80, 80, 15, 150);
        base.setFill(Color.WHITE);
        base.setType(ArcType.OPEN);
        base.setStroke(Color.BLACK);
        
        //Create the pane and add the hang man
        Pane pane = new Pane();
        pane.getChildren().add(head);
        pane.getChildren().add(body);
        pane.getChildren().add(lArm);
        pane.getChildren().add(rArm);
        pane.getChildren().add(lLeg);
        pane.getChildren().add(rLeg);
        pane.getChildren().add(rope);
        pane.getChildren().add(horLine);
        pane.getChildren().add(verLine);
        pane.getChildren().add(base);
        Scene scene = new Scene(pane, 800, 800);
        
        primaryStage.setTitle("Unit 1 Hang Man");
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
