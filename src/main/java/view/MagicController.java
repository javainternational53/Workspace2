package view;

/**
 * Created by zsolt on 5/25/17.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Hacking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/*
public class LoginController {
}
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

public class MagicController {


    private final Logger slf4jLogger = LoggerFactory.getLogger(LoginController.class);

    private MasterController calcplus;




    public MasterController getcalcplus()

    {

        return this.calcplus;

    }

    public void setCalcplus(MasterController calcplus) {


        this.calcplus = calcplus;

    }
// Event
    @FXML
    private Text finaloutput;


    private long alpha = 0;

    // get - > move

    private String operator = "";
    private boolean start = true;

    private Hacking model = new Hacking();

    @FXML
    private void processDrag(ActionEvent event) {


        if (start) {
            finaloutput.setText("");

            // pulse
            start = false;


        }
        //
        //        String value = ((Button)event.getSource()).getText();

        String value = ((Button)event.getSource()).getText();
        //
        finaloutput.setText(finaloutput.getText() + value);

        this.slf4jLogger.info(String.format("%s", value));
    }

    @FXML
    void makeBacck(ActionEvent event) throws IOException {

        //System.out.println("Calculator ");

        Parent root = FXMLLoader.load(getClass().getResource("felulet.fxml"));
        Stage main  = new  Stage();


        // Back

        //Scene scene = new Scene(root);
        //  main.setScene(scene);
        Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();
        //  main.setScene(new Scene(root, 300, 275));
        //main.show();
        //main.show();

        //((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    private void processHack(ActionEvent event) {


        String value = ((Button)event.getSource()).getText();

        if (!"=".equals(value))
        {
            if (!operator.isEmpty())
                return;

            operator = value;
            alpha = Long.parseLong(finaloutput.getText());
            ////////
            finaloutput.setText("");
            this.slf4jLogger.info(String.format("%s", value));
        }

        else {


            if (operator.isEmpty())
                return;

            finaloutput.setText(String.valueOf(model.calculatemainnumber(alpha, Long.parseLong(finaloutput.getText()), operator)));
            operator = "";
            start = true;

            this.slf4jLogger.info(String.format("%s", finaloutput));
        }


    }





}
