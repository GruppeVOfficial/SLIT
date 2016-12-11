package Database;

import Database.DeliverablePK;
import Database.Feedback;
import Database.Module;
import Database.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:19:01")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:21:59")
>>>>>>> a645fc3b3ed10fb22f4a9a5034cb853e2c55af4f
@StaticMetamodel(Deliverable.class)
public class Deliverable_ { 

    public static volatile SingularAttribute<Deliverable, Feedback> feedback;
    public static volatile SingularAttribute<Deliverable, Student> student;
    public static volatile SingularAttribute<Deliverable, Module> module;
    public static volatile SingularAttribute<Deliverable, DeliverablePK> deliverablePK;

}