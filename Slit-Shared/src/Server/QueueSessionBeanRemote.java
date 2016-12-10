/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import javax.ejb.Remote;
import DataModel.StudentDataModel;


/**
 *
 * @author erik
 */
@Remote
public interface QueueSessionBeanRemote {
    void addQueueToBase (StudentDataModel student);
}

