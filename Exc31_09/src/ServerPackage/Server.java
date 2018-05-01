/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerPackage;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Austyn
 */
public class Server extends Application {
    DataOutputStream out = null;
    DataInputStream in = null;
    
    @Override
    public void start(Stage primaryStage) {
        //Panel paneForTextField to hold the label and text field
        BorderPane paneForTextField = new BorderPane();
        paneForTextField.setPadding(new Insets(5, 5, 5, 5));
        paneForTextField.setStyle("-fx-border-color: green");
        paneForTextField.setLeft(new Label("Enter chat: "));
        
        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneForTextField.setCenter(tf);
        
        BorderPane mainPane = new BorderPane();
        //Text area to display output from server
        TextArea ta = new TextArea();
        mainPane.setCenter(new ScrollPane(ta));
        mainPane.setTop(paneForTextField);
        
        Scene scene = new Scene(mainPane, 450, 200);
        primaryStage.setTitle("Server");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        new Thread ( () -> {
            try {
                //Create a server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater( () -> 
                    ta.appendText("Server started at " + new Date() + "\n"));
                //Listen for connection request
                Socket socket = serverSocket.accept();
                //Create data input and output streams
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                
                while (true) {
                    //Get reply from client
                    String reply = in.readUTF();
                    
                    Platform.runLater(() -> {
                       ta.appendText("Client says: " + reply + "\n");
                    });
                }
            } //End of try
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();
        
        tf.setOnAction(e -> {
            try {
                //Gets chat from text field
                String chat = tf.getText();
                ta.appendText("You say: " + chat + "\n");
                //Sends chat to client
                out.writeUTF(chat);
                out.flush();
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        });
        
//        try {
//            //Get reply from client
//            double reply = in.readDouble();
//            //Display to text area
//            ta.appendText("Client: " + reply);
//        } //End of try
//        catch (IOException ex) {
//            System.err.println(ex);
//        }
    } //End of method start
    
    public static void main(String[] args) {
        Application.launch(args);
    }
} //End of class Server
