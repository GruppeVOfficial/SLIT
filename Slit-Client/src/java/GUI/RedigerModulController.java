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

    @FXML
    private void saveModulEvent(ActionEvent event) {
        if(currentModule.getModuleID() != null){
        currentModule.setModuleID(ModuleIDText.getText());
        currentModule.setModuleName(ModuleNameText.getText());
        currentModule.setRequierments(RequiermentsText.getText());
        currentModule.setTeacherID(TeacherIDText.getText());
        currentModule.setDescription(DescriptionText.getText());
        currentModule.setDeadline(datePicker.getValue().toString());
        
        this.errorText.setText("Modul lagret");
        
        }
        else{
        Debug.PrintError("Noe gikk galt");

        }  
        
    }

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
    
    void setCurrentModule(String moduleID) {
    currentModule = modules.getModel(moduleID);
    }
    
    
    void setCurrentModuleInfo() {
    if (currentModule.getModuleName() != null) {
        ModuleIDText.setText(currentModule.getModuleID());
        ModuleNameText.setText(currentModule.getModuleName());
        RequiermentsText.setText(currentModule.getRequierments());
        TeacherIDText.setText(currentModule.getTeacherID());
        DescriptionText.setText(currentModule.getDescription());
        GoalsText.setText(currentModule.getGoals());
 



    } else {
        Debug.PrintError("Cannot access the Module! Is the requested ID correct?");
        errorText.setText("No Module :(");
        


    }
    }

    void UpdateModule(String id){
    try {
        setCurrentModule(id);
        setCurrentModuleInfo();
   } catch (IllegalArgumentException e) {
       e.printStackTrace();
   }

    
}
        }


