/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import GUI.Main;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author mathiashartveit1
 */
public class Utilities {
    
    private static Utilities instance;

    public Utilities() {
        instance = this;
    }

    public static Utilities getInstance() {
        return instance;
    }
    
    /***
     * Converts a string date of YYYY-MM-DD to
     * DD-MM-YYYY
     * @param date - The date to be converted
     * @return The converted date as a String
     */
    public static String convertDate(String date) {
        // YYYY-MM-DD
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8, 10);
        
        date = day + "-" + month + "-" + year;
        
        return date;
    }
    
    /***
     * Used to change from one scene to another
     * @param event Pass on the event from the button pressed
     * @param c Pass on the class that the event fired from ("this.getClass()")
     * @param loadName The name of the .fxml file to be loaded.
     * @param title The title of the new window
     * @throws IOException 
     */
    public static void changeScene(ActionEvent event, Class c, String loadName, String title) throws IOException {
        Parent parent = FXMLLoader.load(c.getResource(loadName + ".fxml"));
        Scene testScene = new Scene(parent);
        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(testScene);
        stage.setTitle(title);
        stage.show();
        
    }

    
}
