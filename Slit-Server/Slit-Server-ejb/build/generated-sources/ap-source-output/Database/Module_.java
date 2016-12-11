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
@StaticMetamodel(Module.class)
public class Module_ { 

    public static volatile SingularAttribute<Module, String> requirements;
    public static volatile SingularAttribute<Module, Teacher> teacherID;
    public static volatile ListAttribute<Module, Deliverable> deliverableList;
    public static volatile SingularAttribute<Module, String> moduleName;
    public static volatile SingularAttribute<Module, String> description;
    public static volatile SingularAttribute<Module, String> moduleID;
    public static volatile SingularAttribute<Module, String> deadline;
    public static volatile SingularAttribute<Module, String> goals;

}