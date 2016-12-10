/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.StudentDataModel;
import javax.ejb.Remote;

/**
 *
 * @author Terje
 */
@Remote
public interface UserSessionBeanRemote {


    void insertUser(String userid, String firstName, String lastName, String email, String phoneNumber, String username, String password); 
    
    StudentDataModel getStudent(String id);
    
    void saveStudentDataModel(StudentDataModel studentDataModel);
    
}
