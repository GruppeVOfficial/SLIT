/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.StudentDataModel;
import Database.Student;;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Terje
 */
@Stateless
public class UserSessionBean implements UserSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void insertUser(String userid, String firstName, String lastName, String email, String phoneNumber, String username, String password) {
       
        try{
        
            Student student = new Student(); 

            student.setFirstName(firstName);
            student.setLastname(lastName);
            student.setUserName(username);
            student.setStudentID(userid);
            student.setEMail(email);
            student.setPhonenumber(phoneNumber);
            student.setUserPassword(password);

            em.persist(student);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @Override 
    public StudentDataModel getStudent(String id){
        
        StudentDataModel studentDataModel = new StudentDataModel();
        
        try{
            Student student = em.find(Student.class, id);
            if(student != null){
                studentDataModel = this.convertStudentEntityToStudentDataModel(student);
            }
        }
        catch(Exception exception){

          exception.printStackTrace();
        }
        return studentDataModel;
        
        
    }
    
    public StudentDataModel convertStudentEntityToStudentDataModel(Student student){
        
        StudentDataModel studentDataModel = new StudentDataModel();
        
        studentDataModel.setEmail(student.getEMail());
        studentDataModel.setFirstName(student.getFirstName());
        studentDataModel.setLastName(student.getLastname());
        studentDataModel.setPassword(student.getUserPassword());
        studentDataModel.setPhoneNumber(student.getPhonenumber());
        studentDataModel.setUserid(student.getStudentID()); 
        studentDataModel.setUsername(student.getUserName());
         
        return studentDataModel;
    }
    @Override
    public void saveStudentDataModel(StudentDataModel studentDataModel){
        try{
            Student student = this.convertStudentEntityToStudentDataModel(studentDataModel);
            em.persist(student);
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    public Student convertDataModelToEntity(StudentDataModel studentDataModel){
        Student student = new Student();
        
        student.setUserName(studentDataModel.getUsername());
        student.setFirstName(studentDataModel.getFirstName());
        student.setLastname(studentDataModel.getLastName());
        student.setPhonenumber(studentDataModel.getPhoneNumber());
        student.setEMail(studentDataModel.getEmail());
        student.setStudentID(studentDataModel.getUserid());
        student.setUserPassword(studentDataModel.getPassword());
        
        return student;
    }
    
    
    
    
    
    
    
    public void persist(Object object) {
        em.persist(object);
    }

    private Student convertStudentEntityToStudentDataModel(StudentDataModel studentDataModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



  

}
