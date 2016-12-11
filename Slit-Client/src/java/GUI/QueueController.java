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
import Server.QueueSessionBeanRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Cursor;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

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
    
    
    
    
    //protected List<StudentDataModel> StudentNavn = new ArrayList<>();
    //protected ListProperty<StudentDataModel> listProperty = new SimpleListProperty<>();
    
    
    ObservableList<String> items = FXCollections.observableArrayList();
    
    @FXML
    private void actionQueue(ActionEvent event) {

        //listProperty.set(FXCollections.observableArrayList(StudentNavn));
        try {
            Student = user.getStudent("003");
            //autentiseringsmetode som hadde lagt til "this.loggedinStudent". 
            {
                items.add(Student.firstName);
            }
            StudentKøListe.setItems(items);
            //istedefor student ville vi lagt inn "thisLoggedInStudent"
            queueM.addQueueToBase(Student);
            
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
    }
    
    void getStudentList() {
        
        ArrayList<QueueDataModel> students = new ArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();

        try {
            students = queueM.getAllStudents();
            for (int i = 0; i < students.size(); i++) {
                data.add(students.get(i).getUserid());
            }
            StudentKøListe.setItems(data);
       } catch (IllegalArgumentException e) {
           e.printStackTrace();
       }
    }
    
    
@FXML
    private void ActionUpdate(ActionEvent event) 
    {
        getStudentList();

    }
    
    @FXML
    private void Quexit(ActionEvent event) 
    {
        items.remove(Student.firstName);
        //listProperty.set(FXCollections.observableArrayList(StudentNavn));
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }       
        
    }    

   
