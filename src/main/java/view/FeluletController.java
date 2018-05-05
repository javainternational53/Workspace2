package view;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zsolt
 */

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
public class FeluletController implements Initializable {

    private final Logger slf4jLogger = LoggerFactory.getLogger(LoginController.class);


    @FXML
        private JFXButton calculator;

        @FXML
        private JFXButton currency;

        @FXML
        private Button closeButton;

        @FXML
        void makeCalculator(ActionEvent event) throws IOException {



            this.slf4jLogger.info(String.format("Calculator Workspace"));

                Parent root = FXMLLoader.load(getClass().getResource("workspace.fxml"));
                Stage main  = new  Stage();


                //  primaryStage.setTitle("Hello World");
              //  Scene scene = new Scene(root);

               main.setScene(new Scene(root, 500, 775));
                main.show();

                ((Node)(event.getSource())).getScene().getWindow().hide();

        }

        @FXML
        void makeCurrency(ActionEvent event) throws IOException {

            this.slf4jLogger.info(String.format("Currency"));

            //System.out.println(" Currency ");

                Parent root = FXMLLoader.load(getClass().getResource("bake.fxml"));
               // Stage main  = new  Stage();
/*

  @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("../main.java.view/sample.fxml"));

      //  primaryStage.setTitle("Hello World");

        primaryStage.setScene(new Scene(root, 500, 775));
        primaryStage.show();
    }

 */

                //  primaryStage.setTitle("Hello World");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
               // main.setScene(new Scene(root, 300, 275));
                stage.show();

                ((Node)(event.getSource())).getScene().getWindow().hide();


        }
// Cancel
        @FXML
       private void closeButtonAction(){

            this.slf4jLogger.warn(String.format("arrivederci"));
                // get a handle to the stage
                Stage stage = (Stage) closeButton.getScene().getWindow();
                // do what you have to do
                stage.close();
        }

        /*

        @Override
        public void initialize(URL location, ResourceBundle resources) {

*/
                @Override
                public   void initialize(URL url,ResourceBundle rb) {

                }
        }

