package view;

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

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import controller.Json;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    private final Logger slf4jLogger = LoggerFactory.getLogger(LoginController.class);



    @FXML
    private JFXTextField user;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton close;

    @FXML
    void makeLogin(ActionEvent event) throws IOException {

       String username = user.getText();
       String pass = password.getText();


//!!! users.json
 // Join Macro

       Json Authenticator = new Json("in.json");

      if ( Authenticator.authenticate(username, pass))


        //  if ( Json.readJsonq().equals();

        {
            this.slf4jLogger.info(String.format("%s has logged in.", username));


            Parent root = FXMLLoader.load(getClass().getResource("felulet.fxml"));
        Stage main  = new  Stage();


      //  primaryStage.setTitle("Hello World");

        main.setScene(new Scene(root, 500, 775));
        main.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();


        }else {
          this.slf4jLogger.warn(String.format("Failed login for user %s.", username));



          //System.out.println("Wrong Password ");
          this.slf4jLogger.warn(String.format("Fatal Error : Wrong Password"));
      }
    }




    @FXML
    private void closeButton(){


        this.slf4jLogger.warn(String.format("arrivederci"));
        // get a handle to the stage
        Stage stage = (Stage) close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }





    @Override
    public   void initialize(URL url,ResourceBundle rb) {

    }
}
