package Database;

import Database.Deliverable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-10T16:23:09")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> studentID;
    public static volatile SingularAttribute<Student, String> firstName;
    public static volatile SingularAttribute<Student, String> userPassword;
    public static volatile ListAttribute<Student, Deliverable> deliverableList;
    public static volatile SingularAttribute<Student, String> phonenumber;
    public static volatile SingularAttribute<Student, String> userName;
    public static volatile SingularAttribute<Student, String> lastname;
    public static volatile SingularAttribute<Student, String> eMail;

}