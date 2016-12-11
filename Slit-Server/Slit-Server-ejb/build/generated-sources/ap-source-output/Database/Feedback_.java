package Database;

import Database.Deliverable;
import Database.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:19:01")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:21:59")
>>>>>>> a645fc3b3ed10fb22f4a9a5034cb853e2c55af4f
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Teacher> teacherID;
    public static volatile SingularAttribute<Feedback, String> teacherComment;
    public static volatile ListAttribute<Feedback, Deliverable> deliverableList;
    public static volatile SingularAttribute<Feedback, Boolean> approvelStatus;
    public static volatile SingularAttribute<Feedback, String> feedbackID;

}