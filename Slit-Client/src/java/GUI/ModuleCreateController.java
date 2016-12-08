/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Framework.ModuleManager;
import Utils.Debug;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Terje
 */
public class ModuleCreateController implements Initializable {

    @FXML
    private Text SLITLable;
    @FXML
    private TextArea ModuleIDText;
    @FXML
    private TextArea ModuleNameText;
    @FXML
    private TextArea RequiermentsText;
    @FXML
    private TextArea TeacherIDText;
    @FXML
    private TextArea DescriptionText;
    @FXML
    private TextArea GoalsText;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button AvbrytBtn;
    @FXML
    private Button LogOut;
    ModuleManager module = new ModuleManager();

    @FXML
    private Label errorText;
    @FXML
    private Button save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void saveModulEvent(ActionEvent event) {
        
            if (this.ModuleIDText.getText().isEmpty()){
            this.errorText.setText("En feil ha oppstått");
        }
        
        if (this.ModuleIDText.getText() != null){
           module.addModule(this.ModuleIDText.getText(), this.ModuleNameText.getText(), this.RequiermentsText.getText(), this.TeacherIDText.getText() ,this.DescriptionText.getText() , this.GoalsText.getText(), this.datePicker.getValue().toString());
           this.errorText.setText("Modul lagt til"); 
           }
        else{
            Debug.PrintError("Noe gikk galt");

        }   
    }
    
    }
    

