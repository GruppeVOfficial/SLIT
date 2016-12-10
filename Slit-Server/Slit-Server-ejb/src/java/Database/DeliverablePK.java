/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Terje
 */
@Embeddable
public class DeliverablePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "studentID", nullable = false, length = 16)
    private String studentID;
    @Basic(optional = false)
    @Column(name = "moduleID", nullable = false, length = 45)
    private String moduleID;
    @Basic(optional = false)
    @Column(name = "feedbackID", nullable = false, length = 10)
    private String feedbackID;

    public DeliverablePK() {
    }

    public DeliverablePK(String studentID, String moduleID, String feedbackID) {
        this.studentID = studentID;
        this.moduleID = moduleID;
        this.feedbackID = feedbackID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        hash += (moduleID != null ? moduleID.hashCode() : 0);
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DeliverablePK)) {
            return false;
        }
        DeliverablePK other = (DeliverablePK) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        if ((this.moduleID == null && other.moduleID != null) || (this.moduleID != null && !this.moduleID.equals(other.moduleID))) {
            return false;
        }
        if ((this.feedbackID == null && other.feedbackID != null) || (this.feedbackID != null && !this.feedbackID.equals(other.feedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.DeliverablePK[ studentID=" + studentID + ", moduleID=" + moduleID + ", feedbackID=" + feedbackID + " ]";
    }
    
}
