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
    
    @Override
    public void updateModule(String id){
        Module module = em.find(Module.class, id);
        em.getTransaction().begin();
        module.setModuleID("002");
        em.getTransaction().commit();
    
    }
    
    
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
