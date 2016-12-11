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
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Terje
 */
public class RegisterUserController implements Initializable {

    private TextArea Brukernavn;
    private TextArea Fornavn;
    private TextArea Etternavn;
    private TextArea Epost;
    private TextArea Telefon;
    private TextArea Passord;
    private TextArea GjentaPassord;
    UserManager users = new UserManager();
    
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
     */

    @FXML
    private void saveUserEventTest(ActionEvent event) {
        System.out.println("start");
        users.insertUser("004", this.Fornavn.getText(), this.Etternavn.getText(), this.Epost.getText(), this.Telefon.getText(), this.Brukernavn.getText(), this.Passord.getText());
        this.Fornavn.setText("navn");
        this.errorText.setText("Yaaayy");
        
    }
    
    @FXML
    private void saveUserEvent(ActionEvent event) {
        if (this.GjentaPassord.getText().isEmpty()){
            this.errorText.setText("En feil har oppstått");
        }
        
        if (this.Passord.getText().equals(this.GjentaPassord.getText())) { 
            UserManager usermanager = new UserManager();
            ArrayList<StudentDataModel> studentList = new ArrayList();
            studentList = usermanager.getAllStudents();
            String i = studentList.get(studentList.size()).getUserid();
            //String newStudentid = correctId(i);
            users.insertUser(i, this.Fornavn.getText(), this.Etternavn.getText(), this.Epost.getText(), this.Telefon.getText(), this.Brukernavn.getText(), this.Passord.getText());
            this.errorText.setText("Bruker lagt til");
        }
        else {
            Debug.PrintError("Noe gikk galt");
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
    private void Registrer(ActionEvent event) throws IOException {
        Utilities.changeScene(event, this.getClass(), "Login", "Login");
    }

    @FXML
    private void Avbryt(ActionEvent event) throws IOException {
        Utilities.changeScene(event, this.getClass(), "Login", "Login");
    }
}
