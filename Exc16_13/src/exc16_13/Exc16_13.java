/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exc16_13;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Austyn
 */
public class Exc16_13 extends Application {
    
    //Create the TextFields for LoanAmount and NumberOfYears
    protected TextField tfLoanAmount = new TextField();
    protected TextField tfNumberOfYears = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        //Set the default text for LoanAmount and NumberOfYears TextFields
        tfLoanAmount.setText("Enter a Number");
        tfNumberOfYears.setText("Enter a Number");
        tfLoanAmount.setAlignment(Pos.BOTTOM_LEFT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_LEFT);
        //Create the Button to be used
        Button btShowTable = new Button("Show Table");
        
        //Create the HBox to hold all the text fields and button, I used an HBox so they are in different rows
        HBox paneForControls = new HBox();
        paneForControls.setAlignment(Pos.CENTER);
        paneForControls.getChildren().addAll(new Label("Loan Amount"), tfLoanAmount, new Label("Number of Years"), tfNumberOfYears, btShowTable);
        
        //Create the text pane to hold the output
        Text paneForOutput = new Text(20, 20, "");
        
        //Create a ScrollPane for the paneForOutput text pane so that it will scroll
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(paneForOutput);
        
        //Create a BorderPane to hold the paneForControls and the scrollPane that holds the paneForOutput
        BorderPane bp = new BorderPane();
        bp.setPrefSize(750, 300);
        bp.setTop(paneForControls);
        bp.setCenter(scrollPane);
        
        //Set the event handler for the button to display the output
        btShowTable.setOnAction(e -> {
            setText(paneForOutput);
        });
        
        Scene scene = new Scene(bp);
	primaryStage.setTitle("Exercise_16_06");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
    private void setText(Text paneOfText) {
        //This is the method used to do the loan and interest math and also format it correctly in the paneForOutput
        String output = "";
        double monthlyInterestRate;
        double monthlyPayment;
        output += "Interest Rate\tMonthlyPayment\tTotalPayment\n";
        
        for (double i = 5.0; i <= 8; i += 0.125) {
            
            monthlyInterestRate = i / 1200;
            monthlyPayment = Double.parseDouble(tfLoanAmount.getText()) * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, 
                    Double.parseDouble(tfNumberOfYears.getText()) * 12));
            output += String.format("%-24.3f%-34.2f%-8.2f\n", i, monthlyPayment, (monthlyPayment * 12) * Double.parseDouble(tfNumberOfYears.getText()));            
        }
        paneOfText.setText(output);
    }
}
