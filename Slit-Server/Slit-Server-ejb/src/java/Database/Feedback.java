/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Terje
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f"),
    @NamedQuery(name = "Feedback.findByFeedbackID", query = "SELECT f FROM Feedback f WHERE f.feedbackID = :feedbackID"),
    @NamedQuery(name = "Feedback.findByTeacherComment", query = "SELECT f FROM Feedback f WHERE f.teacherComment = :teacherComment"),
    @NamedQuery(name = "Feedback.findByApprovelStatus", query = "SELECT f FROM Feedback f WHERE f.approvelStatus = :approvelStatus")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "feedbackID", nullable = false, length = 10)
    private String feedbackID;
    @Column(name = "teacherComment", length = 300)
    private String teacherComment;
    @Column(name = "approvelStatus")
    private Boolean approvelStatus;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne
    private Teacher teacherID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "feedback")
    private List<Deliverable> deliverableList;

    public Feedback() {
    }

    public Feedback(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(String feedbackID) {
        this.feedbackID = feedbackID;
    }

    public String getTeacherComment() {
        return teacherComment;
    }

    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }

    public Boolean getApprovelStatus() {
        return approvelStatus;
    }

    public void setApprovelStatus(Boolean approvelStatus) {
        this.approvelStatus = approvelStatus;
    }

    public Teacher getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(Teacher teacherID) {
        this.teacherID = teacherID;
    }

    @XmlTransient
    public List<Deliverable> getDeliverableList() {
        return deliverableList;
    }

    public void setDeliverableList(List<Deliverable> deliverableList) {
        this.deliverableList = deliverableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackID != null ? feedbackID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackID == null && other.feedbackID != null) || (this.feedbackID != null && !this.feedbackID.equals(other.feedbackID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Feedback[ feedbackID=" + feedbackID + " ]";
    }
    
}
