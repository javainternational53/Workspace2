package view;

/**
 * Created by zsolt on 5/8/17.
 */
/*
public class MasterController {
}
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


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MasterController extends javafx.application.Application {


    private Stage primaryStage;
    private VBox vbox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        //Parent root = FXMLLoader.load(getClass().getResource("/stroe.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("hu.zsolt.calc.master/magic.fxml"));
        //getClass().getClassLoader().getResource("Login.fxml")
        //Parent root = FXMLLoader.load(getClass().getResource("/jfxtest2/TMPScreen.fxml"));

        FXMLLoader loader = new FXMLLoader();

        //loader.setLocation(MasterController.class.getResource("ui.fxml"));
        //vbox = (VBox) loader.load();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("workspace.fxml"));

/*

 FXMLLoader loader = new FXMLLoader();
            loader.setLocation(LaunchFXApp.class.getResource("../../main.java.view/character_sheet/_.fxml"));
 rootLayout = (BorderPane) loader.load();

 */
// Stage
        primaryStage.setScene(new Scene( vbox));
        primaryStage.show();

        // give names
        MagicController controller = loader.getController();
        controller.setCalcplus(this);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
// low space