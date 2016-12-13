/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.ModuleDataModel;
import Database.Module;
import Database.Teacher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Terje
 */
@Stateless
public class ModuleSessionBean implements ModuleSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    /**
     * Takes a parameter and finds the module, then deletes it from the database 
     * @param Id 
     */
    @Override
    public void removeModule(String Id){
        Module module = em.find(Module.class, Id);
        em.remove(module);
    }
    /**
     * Takes parameters to create a module object and persists it. 
     * @param moduleID
     * @param modulename
     * @param requierments
     * @param teacherID
     * @param description
     * @param goals
     * @param deadline 
     */
    @Override
    public void addModule(String moduleID, String modulename, String requierments, String teacherID, String description, String goals, String deadline){
        try {
            
            Module module = new Module();
            
            module.setModuleID(moduleID);
            module.setModuleName(modulename);
            module.setRequirements(requierments);
            module.setTeacherID(em.find(Teacher.class, teacherID));
            module.setDescription(description);
            module.setGoals(goals);
            module.setDeadline(deadline);
            
            em.persist(module);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Finds a module and edits the info about the module
     * @param id
     * @param moduleName
     * @param requierments
     * @param teacherID
     * @param description
     * @param goals
     * @param deadline 
     */
    @Override
    public void updateModule(String id, String moduleName, String requierments, String teacherID, String description, String goals, String deadline){
        try {
        
        Module module = em.find(Module.class, id);
        
        module.setModuleID(id);
        module.setModuleName(moduleName);
        module.setRequirements(requierments);
        module.setTeacherID(em.find(Teacher.class, teacherID));
        module.setDescription(description);
        module.setGoals(goals);
        module.setDeadline(deadline);
        
        }
        catch(Exception e){
        e.printStackTrace();
        }
    }
    
    /**
     * Takes parameter id and finds a module in the database, then converting it to a datamodel(pojo)
     * @param id
     * @return returns a datamodel of the type module
     */
    @Override
    public ModuleDataModel getModel(String id){
    
        ModuleDataModel modulDataModel = new ModuleDataModel();
        
        try{
            
            Module module = em.find(Module.class, id);
            
            if(module != null){
                modulDataModel = this.convertModuleEntityToModuleDataModel(module);
            }
      
        }
        catch(Exception exception){
             
            exception.printStackTrace();
        }
        return modulDataModel;
    }
    
    /**
     * converts a module entity object to a datamodel (pojo)
     * @param modul
     * @return the datamodel of the type module 
     */
    public ModuleDataModel convertModuleEntityToModuleDataModel(Module modul){
    
        ModuleDataModel moduleDataModel = new ModuleDataModel();
        
        moduleDataModel.setDeadline(modul.getDeadline());
        moduleDataModel.setDescription(modul.getDescription());
        moduleDataModel.setGoals(modul.getGoals());
        moduleDataModel.setModuleID(modul.getModuleID());
        moduleDataModel.setModuleName(modul.getModuleName());
        moduleDataModel.setRequierments(modul.getRequirements());
            
        if(modul.getTeacherID() != null) {
            moduleDataModel.setTeacherID(modul.getTeacherID().getTeacherID());
        }
        
        return moduleDataModel;
    }
    
    /**
     * Converts the datamodel of the type module to a entity object and persists it to the database 
     * @param moduleDataModel 
     */
    @Override
    public void saveModuleDataModel(ModuleDataModel moduleDataModel){
        try{
            Module module = this.convertDataModelToModuleEntity(moduleDataModel);
            
            em.persist(module);
        }
        catch(Exception e){
            e.printStackTrace();
        
        }
    }
    /**
     * This methode returns a module entity object, converted from a data model of the type module 
     * @param moduleDataModel
     * @return 
     */
    public Module convertDataModelToModuleEntity(ModuleDataModel moduleDataModel){
    
        Module module = new Module();
        
        module.setDeadline(moduleDataModel.getDeadline());
        module.setDescription(moduleDataModel.getDescription());
        module.setGoals(moduleDataModel.getGoals());
        module.setModuleID(moduleDataModel.getModuleID());
        module.setModuleName(moduleDataModel.getModuleName());
        module.setRequirements(moduleDataModel.getRequierments());
        
        try{
            Teacher teacher = em.find(Teacher.class, moduleDataModel.getTeacherID());

            if(teacher != null){
                module.setTeacherID(teacher);
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
        
        return module;
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")




}
