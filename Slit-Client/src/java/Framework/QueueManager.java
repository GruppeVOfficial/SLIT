/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;


import DataModel.StudentDataModel;
import Server.QueueSessionBeanRemote;
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
            return (QueueSessionBeanRemote) c.lookup("java:comp/env/QueueSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void addQueueToBase(StudentDataModel Student)
    {
        this.lookupQueueSessionBeanRemote().addQueueToBase(Student);
    }
    
}
