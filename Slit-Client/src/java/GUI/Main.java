/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import DataModel.ModuleDataModel;
import DataModel.StudentDataModel;
import Framework.ModuleManager;
//import Framework.ModuleManager;
import Framework.TeacherManager;
import Framework.UserManager;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

/**
 *
 * @author Terje
 */
public class Main extends Application {

       
    @Override
    public void start(Stage stage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("ModuleCreate.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        
        launch(args);
        UserManager userManager = new UserManager(); 
        TeacherManager teacherManager = new TeacherManager();
        ModuleManager moduleManager = new ModuleManager();
        
        launch(args);
    }
    
    //en endring
}


