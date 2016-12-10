/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Terje
 */
@Entity
@Table(name = "deliverable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverable.findAll", query = "SELECT d FROM Deliverable d"),
    @NamedQuery(name = "Deliverable.findByStudentID", query = "SELECT d FROM Deliverable d WHERE d.deliverablePK.studentID = :studentID"),
    @NamedQuery(name = "Deliverable.findByModuleID", query = "SELECT d FROM Deliverable d WHERE d.deliverablePK.moduleID = :moduleID"),
    @NamedQuery(name = "Deliverable.findByFeedbackID", query = "SELECT d FROM Deliverable d WHERE d.deliverablePK.feedbackID = :feedbackID")})
public class Deliverable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DeliverablePK deliverablePK;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;
    @JoinColumn(name = "moduleID", referencedColumnName = "moduleID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Module module;
    @JoinColumn(name = "feedbackID", referencedColumnName = "feedbackID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Feedback feedback;

    public Deliverable() {
    }

    public Deliverable(DeliverablePK deliverablePK) {
        this.deliverablePK = deliverablePK;
    }

    public Deliverable(String studentID, String moduleID, String feedbackID) {
        this.deliverablePK = new DeliverablePK(studentID, moduleID, feedbackID);
    }

    public DeliverablePK getDeliverablePK() {
        return deliverablePK;
    }

    public void setDeliverablePK(DeliverablePK deliverablePK) {
        this.deliverablePK = deliverablePK;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverablePK != null ? deliverablePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliverable)) {
            return false;
        }
        Deliverable other = (Deliverable) object;
        if ((this.deliverablePK == null && other.deliverablePK != null) || (this.deliverablePK != null && !this.deliverablePK.equals(other.deliverablePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Deliverable[ deliverablePK=" + deliverablePK + " ]";
    }
    
}
