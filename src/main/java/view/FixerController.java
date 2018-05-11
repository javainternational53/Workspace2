package view;

import controller.FixerIo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by zsolt on 5/18/17.
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
public class FixerController implements Initializable {
    private Logger logger = LoggerFactory.getLogger(FixerController.class);





        @FXML
        private ComboBox fromCurrency;

        @FXML
        private ComboBox fromCurrency2;

        @FXML
        private TextField in;

        @FXML
        private Label out;

        private FixerIo fixer;



        public FixerController() throws IOException {

           
        }

    @FXML
    void makeBack(ActionEvent event) throws IOException {

        //System.out.println("Calculator ");

        Parent root = FXMLLoader.load(getClass().getResource("felulet.fxml"));
        Stage main  = new  Stage();


        //  primaryStage.setTitle("Hello World");
          Scene scene = new Scene(root);
        main.setScene(scene);
        main.show();

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.fixer = new FixerIo("EUR");
            if (HasNetConnection())
                this.fixer = new FixerIo("EUR");
            else
                this.fixer = new FixerIo("EUR", "currency.json");

            try (PrintStream p = new PrintStream("currency.json")) {
                this.fixer.Save(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }



        ObservableList<String> e = FXCollections.observableArrayList(this.fixer.GetCurrencies());
        this.fromCurrency.setItems(e);
        this.fromCurrency.getSelectionModel().select(0);

        ObservableList<String> ee = FXCollections.observableArrayList(this.fixer.GetCurrencies());
        this.fromCurrency2.setItems(ee);
        this.fromCurrency2.getSelectionModel().select(0);
    }

    public void onKeyReleased(KeyEvent e) {
        this.UpdateResult();
    }

    public void onMouseClicked(ActionEvent e) {
        this.UpdateResult();
    }

    private void UpdateResult() {
        if (this.in.getText().isEmpty()) {
            this.out.setText("");
            return;
        }

        double input = 0;

        try {
            input = Double.parseDouble(this.in.getText());
        }
        catch (NumberFormatException ex) {
            this.out.setText("Do not use characters ! This is not a fucking number");
            return;
        }


        this.logger.info(
                String.format(
                        "Converted %f %s to %s that is %f.",
                        input,
                        this.fromCurrency.getSelectionModel().getSelectedItem().toString(),
                        this.fromCurrency2.getSelectionModel().getSelectedItem().toString(),
                        this.fixer.ConvertCurrency(
                                input,
                                this.fromCurrency.getSelectionModel().getSelectedItem().toString(),
                                this.fromCurrency2.getSelectionModel().getSelectedItem().toString()
                        )
                )
        );

        this.out.setText(
                String.valueOf(
                        this.fixer.ConvertCurrency(
                                input,
                                this.fromCurrency.getSelectionModel().getSelectedItem().toString(),
                                this.fromCurrency2.getSelectionModel().getSelectedItem().toString()
                        )
                )
        );
    }


    private static boolean HasNetConnection() {
        try {
            URL u = new URL("http://google.com");
            u.openStream().close();

            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
