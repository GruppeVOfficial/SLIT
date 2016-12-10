/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.StudentDataModel;
import Database.Queue;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author erik
 */
@Stateless
public class QueueSessionBean implements QueueSessionBeanRemote {

    @PersistenceContext(unitName = "Slit-Server-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void addQueueToBase(StudentDataModel Student) {
        Queue queue = new Queue();
        queue.setStudentID(Student.getUserid());
        em.persist(queue);
    }
    

}
