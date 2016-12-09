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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Terje
 */
@Entity
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleID", query = "SELECT m FROM Module m WHERE m.moduleID = :moduleID"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Module.findByRequirements", query = "SELECT m FROM Module m WHERE m.requirements = :requirements"),
    @NamedQuery(name = "Module.findByDescription", query = "SELECT m FROM Module m WHERE m.description = :description"),
    @NamedQuery(name = "Module.findByGoals", query = "SELECT m FROM Module m WHERE m.goals = :goals"),
    @NamedQuery(name = "Module.findByDeadline", query = "SELECT m FROM Module m WHERE m.deadline = :deadline")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "moduleID")
    private String moduleID;
    @Size(max = 45)
    @Column(name = "moduleName")
    private String moduleName;
    @Size(max = 500)
    @Column(name = "requirements")
    private String requirements;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Size(max = 500)
    @Column(name = "goals")
    private String goals;
    @Size(max = 16)
    @Column(name = "Deadline")
    private String deadline;
    @JoinColumn(name = "teacherID", referencedColumnName = "teacherID")
    @ManyToOne
    private Teacher teacherID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "module")
    private List<Deliverable> deliverableList;

    public Module() {
    }

    public Module(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
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
        hash += (moduleID != null ? moduleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleID == null && other.moduleID != null) || (this.moduleID != null && !this.moduleID.equals(other.moduleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Module[ moduleID=" + moduleID + " ]";
    }
    
}
