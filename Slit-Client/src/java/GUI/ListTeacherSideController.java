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
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
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


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
   
    @FXML
    private void showStudentList(ActionEvent event) {
        FXCollections.observableList(user.getAllStudents());
        
    }

}


      
    


    
    

