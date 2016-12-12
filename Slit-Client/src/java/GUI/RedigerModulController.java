/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.ModuleDataModel;
import Framework.ModuleManager;
import Utils.Debug;
import Utils.Utilities;
import java.io.IOException;
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
public class RedigerModulController implements Initializable {

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
    private Button save;
    @FXML
    private Button AvbrytBtn;
    @FXML
    private Label errorText;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Text SLITLable;
    
    ModuleManager modules = new ModuleManager();
    ModuleDataModel currentModule;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * This method checks if the module ID is added, before it adds a new 
     * module to the database. It uses the text fiels form the GUI to create it 
     * @param event 
     */
    @FXML
    private void saveModulEvent(ActionEvent event) {
        if(currentModule.getModuleID() != null){
        modules.updateModule(this.ModuleIDText.getText(), this.ModuleNameText.getText(), this.RequiermentsText.getText(), this.TeacherIDText.getText(), this.DescriptionText.getText(), this.GoalsText.getText(), this.datePicker.getValue().toString());

        this.errorText.setText("Modul lagret");
        
        }
        else{
        Debug.PrintError("Noe gikk galt");
        }  
        
    }
    /**
     * The buttons underneath updates the current module to a spesific nubmber. 
     * @param event 
     */
    @FXML
    private void getModule1(ActionEvent event) {
        UpdateModule("001");
    }

    @FXML
    private void getModule2(ActionEvent event) {
        UpdateModule("002");
    }

    @FXML
    private void getModule3(ActionEvent event) {
        UpdateModule("003");
    }

    @FXML
    private void getModule4(ActionEvent event) {
        UpdateModule("004");
    }

    @FXML
    private void getModule5(ActionEvent event) {
        UpdateModule("005");
    }
    /**
     *This method 
     * @param moduleID 
     */
    void setCurrentModule(String moduleID) {
    currentModule = modules.getModel(moduleID);
    }
    
    /**
     * This method displays the info about the current module
     */
    void setCurrentModuleInfo() {
    if (currentModule.getModuleName() != null) {
        ModuleIDText.setText(currentModule.getModuleID());
        ModuleNameText.setText(currentModule.getModuleName());
        RequiermentsText.setText(currentModule.getRequierments());
        TeacherIDText.setText(currentModule.getTeacherID());
        DescriptionText.setText(currentModule.getDescription());
        GoalsText.setText(currentModule.getGoals());

    }   else {
        Debug.PrintError("Cannot access the Module! Is the requested ID correct?");
        errorText.setText("No Module :(");
        }
    }
    /**
     * 
     * @param id 
     */
    void UpdateModule(String id){
    try {
        setCurrentModule(id);
        setCurrentModuleInfo();
    } 
    catch (IllegalArgumentException e) {
       e.printStackTrace();
   }   
}

    @FXML
    private void deleteModule(ActionEvent event) {
        if(currentModule.getModuleID() != null){
            modules.removeModule(currentModule.getModuleID());
            this.errorText.setText("Modulen er slettet");
        }
        else {
            this.errorText.setText("Noe gikk galt under slettingen av modulen");
        } 
        
    }

    @FXML
    private void LogOut(ActionEvent event) throws Exception {
        Utilities.changeScene(event, this.getClass(), "Login", "Login");
    }

    @FXML
    private void Avbryt(ActionEvent event) throws Exception {
        Utilities.changeScene(event, this.getClass(), "ListTeacherSide", "StudentListe");
    }
}


