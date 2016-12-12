/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataModel.QueueDataModel;
import DataModel.StudentDataModel;
import Framework.QueueManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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
    QueueManager queueM = new QueueManager();
    QueueDataModel currentQueue;
    
    
    
    ObservableList<String> items = FXCollections.observableArrayList();
    
    @FXML
    private void actionQueue(ActionEvent event) {

        try {
            Student = user.getStudent("001");
            //autentiseringsmetode som hadde lagt til "this.loggedinStudent". 
            {
                items.add(items.size(), Student.firstName);
            }
            StudentKøListe.setItems(items);
            //istedefor student ville vi lagt inn "thisLoggedInStudent"
            queueM.addQueueToBase(Student);
            
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
    }
    
    void getStudentList() {
        
        ArrayList<QueueDataModel> queues = new ArrayList();
        items.removeAll(items);
        
        try {
            queues = queueM.finneAlle();
            for (int i = 0; i < queues.size(); i++) {
                items.add(user.getStudent(queues.get(i).getUserid()).firstName);
            }
            StudentKøListe.setItems(items);
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
    }
    
    
@FXML
    private void ActionUpdate(ActionEvent event) 
    {
        //skulle lagt til verdi for dato, og og sortert etter dette
        getStudentList();
    }
    
    @FXML
    private void Quexit(ActionEvent event) 
    {
        // for å vite hvem som skal fjernes må det være en login versjon
        queueM.removeFromQueue("001");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        getStudentList();
    }       
        
    }    

   
