package Database;

import Database.Feedback;
import Database.Module;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:21:59")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstName;
    public static volatile SingularAttribute<Teacher, String> userPassword;
    public static volatile SingularAttribute<Teacher, String> teacherID;
    public static volatile ListAttribute<Teacher, Module> moduleList;
    public static volatile SingularAttribute<Teacher, String> phonenumber;
    public static volatile SingularAttribute<Teacher, String> userName;
    public static volatile ListAttribute<Teacher, Feedback> feedbackList;
    public static volatile SingularAttribute<Teacher, String> lastname;
    public static volatile SingularAttribute<Teacher, String> eMail;

}