/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Database.Teacher;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Terje
 */
@Stateless
public class TeacherSessionBean implements TeacherSessionBeanRemote{
    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;
    
    
    @Override
       public void insertTeacher(int teacherid, String firstName, String lastName, String email, String phoneNumber, String username, String password){
        Teacher teacher = new Teacher();
        
        teacher.setFirstName(firstName);
        teacher.setLastname(lastName);
        teacher.setPhonenumber(phoneNumber);
        teacher.setTeacherID(Integer.toString(teacherid));
        teacher.setEMail(email);
        teacher.setPhonenumber(phoneNumber);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void businessMethod(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inserTeacher(int teacherid, String firstName, String lastName, String email, String phoneNumber, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
