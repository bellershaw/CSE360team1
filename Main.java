import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.*;

public class Main extends Application{
     Button button; // type button 

    Button nurseButton = new Button("Nurse"); //create nurse button
    Button doctorButton = new Button("Doctor");  // create doctor button
    Button patientButton = new Button("Patient") ; // create patient button

    StackPane layout = new StackPane();
    layout.getChildren().add(nurseButton);
    layout.getChildren().add(doctorButton);
    layout.getChildren().add(patientButton);

    Scene scene = new Scene(layout, 600, 600); // scene size
    primaryStage.setScene(scene);
    primaryStage.show(); // show it to user
}


public static void main(String[] args) {
    launch(args); // method inside application class that sets up javafx application
}