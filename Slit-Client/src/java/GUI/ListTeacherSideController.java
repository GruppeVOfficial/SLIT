/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.StudentDataModel;
import Framework.UserManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


/**
 * FXML Controller class
 *
 * @author Terje
 */
public class ListTeacherSideController implements Initializable {

    @FXML
    private ChoiceBox<?> Sorter;
    @FXML
    private Button loggUt;
    @FXML
    private Button redigerModuler;
    @FXML
    private Button StudentListeBtn;
    @FXML
    private Button queueBtn;
    UserManager user = new UserManager();

    StudentDataModel student;
    @FXML
    private Label btnTestLabel;
    @FXML
    private ListView<?> listView;
    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> nameList;
    @FXML
    private TableColumn<?, ?> modul1List;
    @FXML
    private TableColumn<?, ?> modul2List;
    @FXML
    private TableColumn<?, ?> modul3List;
    @FXML
    private TableColumn<?, ?> modul4List;
    @FXML
    private TableColumn<?, ?> modul5List;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void showStudentList(ActionEvent event) {
        setCurrentStudent("001");
        if(student.getUserid() >= 0){
        } 
        else {
            System.err.print("Cannot access the Module! Is the requested ID correct?");
            btnTestLabel.setText("No Module :(");
            
        }

    }
    private void getAllStudent(){
        if(student.getUserid() != 0){   
        
        }
    
    }
    
    private void findStundents(){
        setCurrentStudent("001");
    if (student.getUserid("1") >= 0){
        
    }
    }
        void setCurrentStudent(String id) {
        student = user.getStudent(id);
    }

        
}
    


    
    

