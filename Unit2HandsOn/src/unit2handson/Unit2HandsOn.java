package unit2handson;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Austyn
 */
public class Unit2HandsOn extends Application{
    
    //Create the TextFields for the US Dollars and Canadian Dollars
    protected TextField tfUSDollars = new TextField();
    protected TextField tfCanDollars = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        //Set the Canadian Dollars to be uneditable and align the text to the right
        tfUSDollars.setAlignment(Pos.BOTTOM_RIGHT);
        tfCanDollars.setAlignment(Pos.BOTTOM_RIGHT);
        tfCanDollars.setEditable(false);
        //Create the button that will start the conversion
        Button btConvert = new Button("Convert");

        //Create the HBoxs that will hold the TextFields for tfUSDollars and tfCanDollars and label them
        HBox hBoxUSD = new HBox();
        hBoxUSD.getChildren().addAll(new Label("US Dollars\t   "), tfUSDollars);
        HBox hBoxCanD = new HBox();
        hBoxCanD.getChildren().addAll(new Label("Canadian Dollars"), tfCanDollars);
        
        //Create a VBox that will hold the HBoxs with the TextFields so they are put into rows
        VBox contentPane = new VBox(5);
        contentPane.setPadding(new Insets (5, 5, 5, 5));
        contentPane.getChildren().addAll(hBoxUSD, hBoxCanD, btConvert);
        
        //Put the VBox contentPane into a pane to be displayed
        Pane displayPane = new Pane();
        displayPane.getChildren().add(contentPane);
        
        //Create the event handler for the button
        btConvert.setOnAction(e -> {
            setText(tfCanDollars);
        });
        
        Scene scene = new Scene(displayPane);
	primaryStage.setTitle("Exercise_16_06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    private void setText(TextField tfCanDollars) {
        //This does the math for converting US Dollars into Canadian dollars and sends back the output to be displayed
        Double converted = Double.parseDouble(tfUSDollars.getText()) * 1.5;
        String output = converted.toString();
        tfCanDollars.setText(output);
    }
}
