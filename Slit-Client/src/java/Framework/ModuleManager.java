/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Framework;

import DataModel.ModuleDataModel;
import Server.ModuleSessionBeanRemote;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Terje
 */
public class ModuleManager {

    private ModuleSessionBeanRemote lookupModuleSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            //return (ModuleSessionBeanRemote) c.lookup("java:comp/env/ModuleSessionBean");
            return (ModuleSessionBeanRemote) c.lookup("java:global/Slit-Server-ejb/ModuleSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
      
    }

/**
 * 
 * @param id
 * @param moduleName
 * @param requierments
 * @param teacherID
 * @param description
 * @param goals
 * @param deadline 
 */
    public void updateModule(String id, String moduleName, String requierments, String teacherID, String description, String goals, String deadline){
        this.lookupModuleSessionBeanRemote().updateModule(id, moduleName, requierments, teacherID, description, goals, deadline);
    }
    
    public void addModule(String moduleID, String modulename, String requierments, String teacherID, String description, String goals, String deadline){
    
        this.lookupModuleSessionBeanRemote().addModule(moduleID, modulename, requierments, teacherID, description, goals, deadline);
    }
    
    public ModuleDataModel getModel(String id){
        return this.lookupModuleSessionBeanRemote().getModel(id);
    }
}
