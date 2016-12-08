/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.StudentDataModel;
import Framework.UserManager;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;


/**
 * FXML Controller class
 *
 * @author Terje
 */
public class ListTeacherSideController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ChoiceBox<?> Sorter;
    @FXML
    private Button loggUt;
    @FXML
    private Button redigerModuler;
    @FXML
    private TableColumn<?, ?> nameList;
    @FXML
    private TableColumn<?, ?> module1List;
    @FXML
    private TableColumn<?, ?> module2List;
    @FXML
    private TableColumn<?, ?> module3List;
    @FXML
    private TableColumn<?, ?> module4List;
    @FXML
    private TableColumn<?, ?> module5List;
    @FXML
    private Button StudentListeBtn;
    @FXML
    private Button queueBtn;
    UserManager user = new UserManager();

    StudentDataModel student;
    @FXML
    private Label btnTestLabel;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void showStudentList(ActionEvent event) {
        if (btnTestLabel.getText() == null) {
        if(student.getUserid() >= 0){
        student.getUserid();
        } else {
            System.err.print("Cannot access the Module! Is the requested ID correct?");
            btnTestLabel.setText("No Module :(");
            
        }
        
       
    }

        
}

}
    
    

