package Database;

import Database.DeliverablePK;
import Database.Feedback;
import Database.Module;
import Database.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T15:37:55")
@StaticMetamodel(Deliverable.class)
public class Deliverable_ { 

    public static volatile SingularAttribute<Deliverable, Feedback> feedback;
    public static volatile SingularAttribute<Deliverable, Student> student;
    public static volatile SingularAttribute<Deliverable, Module> module;
    public static volatile SingularAttribute<Deliverable, DeliverablePK> deliverablePK;

}