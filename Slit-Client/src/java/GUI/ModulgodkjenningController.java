/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Utils.Utilities;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Eirik
 */
public class ModulgodkjenningController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoggUt(ActionEvent event) throws IOException {
        Utilities.changeScene(event, this.getClass(), "Login", "Loginn");
    }

    @FXML
    private void StudentListe(ActionEvent event) throws IOException {
        Utilities.changeScene(event, this.getClass(), "ListTeacherSide", "Studentliste");
    }
    
}
