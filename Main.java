import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import java.util.*;

public class Main extends Application{

    @Override
    public void start (Stage primaryStage){
        primaryStage.setTitle("Login Page");
        Button expatientButton = new Button("I am an exiting patient");  // create doctor button
        Button newpatientButton = new Button("I am a new patient") ; // create patient button
        Button nursedocButton = new Button("I am a doctor or nurse"); //create nurse button

        expatientButton.setPrefSize(200,100);
        newpatientButton.setPrefSize(200,100);
        nursedocButton.setPrefSize(200,100);

        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(expatientButton);
        layout.getChildren().add(newpatientButton);
        layout.getChildren().add(nursedocButton);

        Scene scene = new Scene(layout, 600, 600); // scene size
        primaryStage.setScene(scene);
        primaryStage.show(); // show it to user
    }


public static void main(String[] args) {launch(args);}; // method inside application class that sets up javafx application
}