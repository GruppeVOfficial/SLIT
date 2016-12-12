/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.StudentDataModel;
import Framework.UserManager;
import Utils.Debug;
import Utils.Utilities;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;



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
    private ListView<String> listView;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO     
    }    
   
    @FXML
    private void showStudentList(ActionEvent event) {
        getStudentList();
    }
    
    @FXML
    private void showQueue(ActionEvent event) throws Exception {
        queueBtn.getScene().setCursor(Cursor.WAIT);
        Utilities.createPopup(event, this.getClass(), "Queue", "Køliste");
        queueBtn.getScene().setCursor(Cursor.DEFAULT);
    }
    
    @FXML
    private void goToRedigerModuler(ActionEvent event) throws Exception {
        Utilities.changeScene(event, this.getClass(), "RedigerModul", "Rediger Modul");
    }
    
   

    void getStudentList() {
        
        ArrayList<StudentDataModel> students = new ArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        try {
            StudentListeBtn.getScene().setCursor(Cursor.WAIT);
            students = user.getAllStudents();
            for (int i = 0; i < students.size(); i++) {
                data.add(students.get(i).getFirstName());
            }
            listView.setItems(data);
            
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
        
        StudentListeBtn.getScene().setCursor(Cursor.DEFAULT);
    }

    @FXML
    private void LogOut(ActionEvent event) throws Exception {
        Utilities.changeScene(event, this.getClass(), "Login", "Login");
    }

    @FXML
    private void addModule(ActionEvent event) throws Exception {
          Utilities.changeScene(event, this.getClass(), "ModuleCreate", "Lag ny modul");
        
    }
    
}

      
    


    
    

