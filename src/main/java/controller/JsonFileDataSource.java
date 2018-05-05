package controller;

import org.json.JSONObject;

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

/**
 * Created by zsolt on 5/28/17.
 */
public class JsonFileDataSource implements IJsonDataSource {
    private final String filename;

    public JsonFileDataSource(String filename) {
        //file exist or not
        this.filename = filename;
    }


    public JSONObject getJson() {
        //read in and give back a json object.
        return null;
    }
}
