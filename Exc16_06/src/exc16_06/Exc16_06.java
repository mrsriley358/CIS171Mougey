package exc16_06;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author Austyn
 */
public class Exc16_06 extends Application {
    
    protected TextField tfTextField = new TextField();
    protected TextField tfColumnSize = new TextField();
    
    @Override
    public void start(Stage primaryStage) {
        
        //Create text fields for the text field and colomn size
        tfTextField.setText("JavaFX");
        tfTextField.setAlignment(Pos.BOTTOM_CENTER);
        tfColumnSize.setAlignment(Pos.BOTTOM_RIGHT);
        tfColumnSize.setPrefColumnCount(3);
	tfTextField.setPrefColumnCount(12);
        tfColumnSize.setText("12");
        
        //Create the Radio Buttons that will be used to realign the text field
	RadioButton rbLeft = new RadioButton("Left");
        RadioButton rbCenter = new RadioButton("Center");
	RadioButton rbRight = new RadioButton("Right");
	rbCenter.setSelected(true);

	//Create the toggle group for the radio buttons
	ToggleGroup group = new ToggleGroup();
	rbLeft.setToggleGroup(group);
	rbCenter.setToggleGroup(group);
	rbRight.setToggleGroup(group);
	
	//Create the HBox for the radio buttons
	HBox paneForRadioButtons = new HBox(5);
	paneForRadioButtons.getChildren().addAll(rbLeft, rbCenter, rbRight);
	paneForRadioButtons.setAlignment(Pos.BOTTOM_LEFT);

	//Create the HBox for the column size text field
        HBox paneForColumnSize = new HBox(5);
	paneForColumnSize.getChildren().addAll(new Label("Colum Size"), tfColumnSize);
        
        //Create the HBox for the text field text box
	HBox paneForTextField = new HBox(5);
	paneForTextField.setAlignment(Pos.CENTER);
	paneForTextField.getChildren().addAll(new Label("Text Field"), tfTextField);

        //Create an HBox to be seperate from the text field hbox that contains the radio buttons and the column size text field
	HBox hbox = new HBox(10);
	hbox.getChildren().addAll(paneForRadioButtons, paneForColumnSize);

	//Create a VBox to put the text field on top of the radio buttons and column size text field
	VBox pane = new VBox(10);
	pane.setPadding(new Insets(5, 5, 5, 5));
	pane.getChildren().addAll(paneForTextField, hbox);

	//Create the set on action events for the radio buttons and the action event to get and set the column size
	rbLeft.setOnAction(e -> {
            if (rbLeft.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_LEFT);
            }
        });

        rbCenter.setOnAction(e -> {
            if (rbCenter.isSelected()) {
		tfTextField.setAlignment(Pos.BOTTOM_CENTER);
            }
	});

	rbRight.setOnAction(e -> {
            if (rbRight.isSelected()) {
                tfTextField.setAlignment(Pos.BOTTOM_RIGHT);
            }
	});
        
        tfColumnSize.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                tfTextField.setPrefColumnCount(Integer.parseInt(tfColumnSize.getText()));
            }
        });

        Scene scene = new Scene(pane);
	primaryStage.setTitle("Exercise_16_06");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
