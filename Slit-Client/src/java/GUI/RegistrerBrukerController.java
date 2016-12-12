package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataModel.StudentDataModel;
import Framework.UserManager;
import Utils.Debug;
import Utils.Utilities;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Terje
 */
public class RegistrerBrukerController implements Initializable {

    private TextArea Brukernavn;
    private TextArea Fornavn;
    private TextArea Etternavn;
    private TextArea Epost;
    private TextArea Telefon;
    private TextArea Passord;
    private TextArea GjentaPassord;
    UserManager users = new UserManager();
    
    @FXML
    private Label errorText;
    @FXML
    private TextField eMail;
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private TextField userName;
    @FXML
    private TextField phone;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordRepeat;
    @FXML
    private Button reg;
    @FXML
    private Button Avbryt;
    @FXML
    private TextField studentID;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    /**
     * This is probably garbage!
     * Does something with the userID and tries to save create new user
     * @param event 
<<<<<<< HEAD
     */
    
    /**
     * Checks that user input is correct and sends input to UserManager. 
     * This stores user information in database.
     * @param event 
     */
    @FXML
        private void Registrer(ActionEvent event) {
            if (this.userName.getText().isEmpty() || this.firstName.getText().isEmpty() || this.lastName.getText().isEmpty() || this.phone.getText().isEmpty() || this.eMail.getText().isEmpty() || this.password.getText().isEmpty()) {
            this.errorText.setText("Feil: Fyll inn alle felter i skjemaet");
            }
            else if (!this.password.getText().equals(this.passwordRepeat.getText())) {
                this.errorText.setText("feil: gjenta passord stemmer ikke.");
            }
            else {
                this.errorText.setText("Nytt forsøk");
                users.insertUser(studentID.getText(), firstName.getText(), lastName.getText(), eMail.getText(), phone.getText(), userName.getText(), password.getText()); 
                this.errorText.setText("Studenten er lagt til.");
            }  
    }
        
    private String correctId(int i) {
        String s;

        if (i < 10) {
            s = "00";
        } else if (i < 100 && i > 10){
            s = "0";
        } else {
            s = "";
        }       
        return s + i;
    }


    @FXML
    private void Avbryt(ActionEvent event) throws Exception {
        Utilities.changeScene(event, this.getClass(), "Login", "Loginn");
    }

}
