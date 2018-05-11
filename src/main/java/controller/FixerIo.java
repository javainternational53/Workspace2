package controller;
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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Scanner;

import org.json.JSONObject;

  
     /**
     * This is the FixerIo class.This is working with the rates and give us fresh currency Rates.
     * FixerIo.
     */

public class FixerIo {


     /**
     * This contains the actual rates.
     * DataSource.
     */

    private JSONObject DataSource;

     /**
     * 
     * JSON.
     */

    private String JSON;

     /**
     * FixerIo.
     * @param BaseCurrency is a samaple Currency.
     * @throws IOException when is there any problem at the threads.
     * Itt IoExceoptiont Dob
     */

    public FixerIo(String BaseCurrency) throws IOException {
    
   
   
   	this(BaseCurrency,"currency.json");
       
    
        String ApiUrl = String.format("http://api.fixer.io/latest?base=%s", BaseCurrency);
        
         String tempJson=this.DownloadData(ApiUrl);
         
         System.out.println(tempJson);
         if( tempJson.length()>10 ) {
       this.JSON=tempJson;
        this.DataSource = new JSONObject(JSON);
        this.DataSource.getJSONObject("rates").put(BaseCurrency,1d);}
    }
     /**
     * Get rates from FixerIo.
     * @param BaseCurrency is the main currency.
     * @param Filename is a Name.
     * @throws FileNotFoundException is an Exception for the Files.
     */
    public FixerIo(String BaseCurrency, String Filename) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        InputStream file = getClass().getClassLoader().getResourceAsStream(Filename);
        try (Scanner sc = new Scanner(file))
        {
            while (sc.hasNextLine())
                sb.append(sc.nextLine());
        }

        this.DataSource = new JSONObject(sb.toString());
        this.DataSource.getJSONObject("rates").put(BaseCurrency,1d);

        //System.out.println(this.DataSource.toString(4));
    }
    
     /**
     * @param p is a PrintStream object for writing out the state of the downloaded JSON data about the currencies.
     */
      public void Save(PrintStream p) {
        p.print(this.JSON);
        p.flush();
    }
     /**
     * We get the actual currencies.
     * @return rates.
     */
      public Collection<String> GetCurrencies() {
        //  System.out.println(this.DataSource.getJSONObject("rates").keySet());
        return this.DataSource.getJSONObject("rates").keySet();

    }
     /**
     *
     * Downloading the corrrect Data with the ApiUrl.
     * @param ApiUrl is a String type parameter.
     * @return Result.
     * @throws IOException when is there any problem at the threads.
     * @throws MalformedURLException when is there any problem at the threads.
     */
    private String DownloadData(String ApiUrl) throws MalformedURLException, IOException {


        StringBuilder Result = new StringBuilder();

        URL u = new URL(ApiUrl);
        try (Scanner sc = new Scanner(u.openStream())) {
            while (sc.hasNextLine())
                Result.append(sc.nextLine());
        }
        
        catch
        (
        Exception e
        ){}

        return Result.toString();
    }

     /**
     * This is converting the currencies.
     * @param Amount is a size of the Currency.
     * @param FromCurrency is type of the Currency.
     * @param ToCurrency is Type of the Currency .
     * @return Amount / From * To.
     */

    public double ConvertCurrency(double Amount, String FromCurrency, String ToCurrency) {


        double From = this.GetCurrencyRate(FromCurrency);
        double To = this.GetCurrencyRate(ToCurrency);

        return Amount / From * To;
    }
     /**
     * 
     * @param Currency is a parameter.
     * @return DataSource
     */
	 public double GetCurrencyRate(String Currency) {


        return this.DataSource.getJSONObject("rates").getDouble(Currency);
    }
}
