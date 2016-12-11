package Database;

import Database.Deliverable;
import Database.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:56:48")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, Teacher> teacherID;
    public static volatile SingularAttribute<Feedback, String> teacherComment;
    public static volatile ListAttribute<Feedback, Deliverable> deliverableList;
    public static volatile SingularAttribute<Feedback, Boolean> approvelStatus;
    public static volatile SingularAttribute<Feedback, String> feedbackID;

}