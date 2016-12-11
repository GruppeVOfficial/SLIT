package Database;

import Database.Deliverable;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:19:01")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T16:21:59")
>>>>>>> a645fc3b3ed10fb22f4a9a5034cb853e2c55af4f
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