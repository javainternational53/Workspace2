package model;

/**
 * Created by zsolt.
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
/*
public class Hacking {
}
*/
// Simple version Zsoltisoft
// simple Myworkspac

    // Math Symbol Convertal egal .

/**
Műveletek adja meg.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hacking.
 * Here we can find the mathematical operations.
 * @author Zsolt
 */

public class Hacking {

/**
 * Calculate the main number, this is the simple calculator.
 * @param first is the first element.
 * @param last is the last element.
 * @param magic is the factor.
 * @return with first or last.
 */

    public long calculatemainnumber(long first, long last, String magic) {

        /**
	 * Info Logger for this class.
	 */
        
        final Logger slf4jLogger = LoggerFactory.getLogger(Hacking.class);

        switch (magic) {

            // case
            case "+":
                return first + last;
            // case
            case "-":
                return first - last;
            //case
            case "*":
                return first * last;
            //case

            // 98 / 11
            case "/":
                if (last == 0)
                    return 0;

                return first / last;

        }



        // return
        return 0;
    }
}
