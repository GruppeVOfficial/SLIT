/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.StudentDataModel;
import java.net.URL;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Terje
 */
public class QueueController implements Initializable {

    @FXML
    private Button UpdateQueue;
    @FXML
    private Button addToQueue;
    @FXML
    private Button ExitQueue;
    @FXML
    private ListView<String> StudentKøListe;
    
    private StudentDataModel Student;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    //tror denne ble riktig
    private void addToQueue(ActionEvent event)
    {
        ObservableList<String> items = FXCollections.observableArrayList (Student.firstName);
        
        StudentKøListe.setItems(items);
    }
    

}
