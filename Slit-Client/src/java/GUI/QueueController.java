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
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import Framework.UserManager;

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
    UserManager user = new UserManager();
    
    
    protected List<StudentDataModel> StudentNavn = new ArrayList<>();
    protected ListProperty<StudentDataModel> listProperty = new SimpleListProperty<>();
    
    private void StudentKøListe()
    {
        //ObservableList<String> items = FXCollections.observableArrayList (Student.firstName);
        //ObservableList<String> items = FXCollections.observableArrayList();
        
        //StudentKøListe.setItems(items);
    }
    
    ObservableList<String> items = FXCollections.observableArrayList();
    
    @FXML
    private void actionQueue(ActionEvent event) {
        //StudentNavn.add("Jens");
        listProperty.set(FXCollections.observableArrayList(StudentNavn));
        try {
            Student = user.getStudent("001");
            {
                items.add(Student.firstName);
            }
            StudentKøListe.setItems(items);
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
    }
    

    @FXML
    private void Quexit(ActionEvent event) 
    {
        items.remove(Student.firstName);
        //StudentNavn.remove("Jens");
        //listProperty.set(FXCollections.observableArrayList(StudentNavn));
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //StudentKøListe.itemsProperty().bind(listProperty);
    }       

}
