/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModuleDataModel;
import java.util.Date;
import javax.ejb.Remote;

/**
 *
 * @author Terje
 */
@Remote
public interface ModuleSessionBeanRemote {
    
    void addModule(String moduleID, String modulename, String requierments, String teacherID, String description, String goals, String deadline);
    
    ModuleDataModel getModel(String id);
    
    void saveModuleDataModel(ModuleDataModel moduleDataModel);
    
    void updateModule(String id, String moduleName, String requierments, String teacherID, String description, String goals, String deadline);
}

