/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "teacher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findByTeacherID", query = "SELECT t FROM Teacher t WHERE t.teacherID = :teacherID"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Teacher.findByLastname", query = "SELECT t FROM Teacher t WHERE t.lastname = :lastname"),
    @NamedQuery(name = "Teacher.findByEMail", query = "SELECT t FROM Teacher t WHERE t.eMail = :eMail"),
    @NamedQuery(name = "Teacher.findByPhonenumber", query = "SELECT t FROM Teacher t WHERE t.phonenumber = :phonenumber"),
    @NamedQuery(name = "Teacher.findByUserName", query = "SELECT t FROM Teacher t WHERE t.userName = :userName"),
    @NamedQuery(name = "Teacher.findByUserPassword", query = "SELECT t FROM Teacher t WHERE t.userPassword = :userPassword")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "teacherID", nullable = false, length = 16)
    private String teacherID;
    @Column(name = "FirstName", length = 45)
    private String firstName;
    @Column(name = "Lastname", length = 45)
    private String lastname;
    @Column(name = "eMail", length = 45)
    private String eMail;
    @Column(name = "phonenumber", length = 10)
    private String phonenumber;
    @Column(name = "userName", length = 16)
    private String userName;
    @Column(name = "userPassword", length = 18)
    private String userPassword;
    @OneToMany(mappedBy = "teacherID")
    private List<Feedback> feedbackList;
    @OneToMany(mappedBy = "teacherID")
    private List<Module> moduleList;

    public Teacher() {
    }

    public Teacher(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @XmlTransient
    public List<Module> getModuleList() {
        return moduleList;
    }

    public void setModuleList(List<Module> moduleList) {
        this.moduleList = moduleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherID != null ? teacherID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherID == null && other.teacherID != null) || (this.teacherID != null && !this.teacherID.equals(other.teacherID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Teacher[ teacherID=" + teacherID + " ]";
    }
    
}
