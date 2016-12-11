/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;


import DataModel.QueueDataModel;
import DataModel.StudentDataModel;
import Server.QueueSessionBeanRemote;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author erik
 */
public class QueueManager {

    private QueueSessionBeanRemote lookupQueueSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (QueueSessionBeanRemote) c.lookup("java:global/Slit-Server-ejb/QueueSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void addQueueToBase(StudentDataModel Student)
    {
        this.lookupQueueSessionBeanRemote().addQueueToBase(Student);
    }
    
    //prøv å gjør om til String
    public QueueDataModel getModel(String id)
    {
        return this.lookupQueueSessionBeanRemote().getModel(id);
    }
    
    public String ja(String id)
    {
        lookupQueueSessionBeanRemote().ja(id);
        return id;
    }
    
    public ArrayList finneAlle()
    {
        return this.lookupQueueSessionBeanRemote().finneAlle();
    }
    
    public ArrayList<QueueDataModel> getAllStudents() {
        ArrayList<QueueDataModel> allStudents = new ArrayList();
        int i = 1;
        
       while (true){
           if (this.getModel(correctId(i)) == null) {
                allStudents.add(this.getModel(correctId(i)));
                i++; 
                System.out.println(i);
           } else {
               break;
           }
            
        }

        return allStudents;
    }
    
    /**
     * TODO: THIS IS FUCKING GARBAGE! CONSIDER CONVERTING STUDENT ID TO INT IN DB
     * 
     * Converts an integer i into string with the format "00i"
     * for accessing the database id correctly. Goes up to 3 integers ("999")
     * 
     * @param i Integer to be converted to correct string
     * @return String with correct format for DB
     */
    String correctId(int i) {
        String s;
        
        if (i < 10) {
            s = "00";
        } else if (i < 100 && i > 10){
            s = "0";
        } else {
            s = "";
        }       
        return s + i;
    }
    
}
