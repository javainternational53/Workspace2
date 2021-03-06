
//package main.java;
/*
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Scanner;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the {@code Main} class which starts the application.
 * @author Zsolt
 *
 */
 
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("view/sample.fxml"));
        //loader.setLocation(MainApp.class.getResource("view/menu.fxml"));


        //  primaryStage.setTitle("Hello Magic World");

        primaryStage.setScene(new Scene(root, 500, 775));
        primaryStage.show();
    }

     /**
     * Main method.
     * @param args are arguments of main method.
     */
     
    public static void main(String[] args) {
        launch(args);
    }
}
