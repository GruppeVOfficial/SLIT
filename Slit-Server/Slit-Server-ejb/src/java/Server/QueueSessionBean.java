/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DataModel.QueueDataModel;
import DataModel.StudentDataModel;
import Database.Queue;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
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
    
    @Override
    public String ja(String id)
    {
        Queue qu = em.find(Queue.class, id);
        return id;
    }
    
    @Override
    public ArrayList finneAlle()
    {
        List<Queue> queueFind = em.createNamedQuery("Queue.findAll").getResultList();
        ArrayList<QueueDataModel> queueDataFind = new ArrayList();
        for (Queue queue : queueFind)
        {
            QueueDataModel queueModel = convertQueueEntityToQueueDataModel(queue);
            queueDataFind.add(queueModel);
        }
        return queueDataFind;
    }
    
    @Override
    public QueueDataModel getModel(String id){
    
        QueueDataModel queueDataModel = new QueueDataModel();
        
        try{
            
            Queue queue = em.find(Queue.class, id);
            
            if(queue != null)
            {
                queueDataModel = this.convertQueueEntityToQueueDataModel(queue);
            }
      
        }
        catch(Exception exception){
             
            exception.printStackTrace();
        }
        return queueDataModel;
    }
    
    
    public QueueDataModel convertQueueEntityToQueueDataModel(Queue queue){
    
        QueueDataModel queueDataModel = new QueueDataModel();
        
        queueDataModel.setUserid(queue.getStudentID());
            
        
        return queueDataModel;
    }


}
