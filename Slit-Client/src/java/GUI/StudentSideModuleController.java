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
import com.sun.prism.paint.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author mathiashartveit1
 */
public class StudentSideModuleController implements Initializable {

    @FXML
    private Button module1btn;
    @FXML
    private Button module2btn;
    @FXML
    private Button module3btn;
    @FXML
    private Button modul4btn;
    @FXML
    private Button module5btn;
    @FXML
    private Button queuebtn;
    @FXML
    private TextArea moduleText;
    @FXML
    private Button loggOutbtn;
    @FXML
    private Label moduleTitle;
    
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
    private void module1btn(ActionEvent event) { 
        module1btn.getScene().setCursor(Cursor.WAIT);
        UpdateModule("1");
        module1btn.getScene().setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    private void module2btn(ActionEvent event) { 
        module1btn.getScene().setCursor(Cursor.WAIT);
        UpdateModule("020");
        module1btn.getScene().setCursor(Cursor.DEFAULT);
    }
    
    
    void setCurrentModule(String moduleID) {
        currentModule = modules.getModel(moduleID);
        
    }
    
    
    void setCurrentModuleInfo() {
        if (currentModule.getModuleName() != null) {
            String change = currentModule.getDescription() 
                + "\n" + "---------" + "\n" +
                currentModule.getGoals()
                + "\n" + "---------" + "\n" +
                currentModule.getRequierments()
                + "\n" + "---------" + "\n" +
                "Deadline: " + Utilities.convertDate(currentModule.getDeadline());
            moduleText.setText(change);
            moduleTitle.setText(currentModule.getModuleName());
        } else {
            Debug.PrintError("Cannot access the Module! Is the requested ID correct?");
            moduleTitle.setText("No Module :(");
           
            moduleText.setText("Cannot fetch module information");
            
        }
        

    }
    
    void UpdateModule(String id) {
        try {
            setCurrentModule(id);
            setCurrentModuleInfo();
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
        
       
        
    }

    
}
