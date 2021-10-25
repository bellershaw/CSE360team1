import javafx.scene.text.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;  
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
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

        Scene start_page = new Scene(layout, 600, 600); // scene size
        primaryStage.setScene(start_page);
        primaryStage.show(); // show it to user
        
        expatientButton.setOnAction((e) -> {
            GridPane main_patient_grid = new GridPane();
            main_patient_grid.prefWidthProperty().bind(primaryStage.widthProperty().multiply(100));
            //main_patient_grid.setGridLinesVisible(true);

            Label patient_title = new Label("Patient Portal");
            patient_title.setFont(new Font("Cambria", 40));
            main_patient_grid.add(patient_title, 0,0);

            VBox left_box = new VBox(3);
            Button patient_info_button = new Button("Patient Information");
            Button send_messages_button = new Button("Send Message") ; // create patient button
            Button log_out_button = new Button("Log Out"); //create nurse button

            patient_info_button.setPrefSize(200,100);  // create doctor button
            send_messages_button.setPrefSize(200,100);  // create doctor button
            log_out_button.setPrefSize(200,100);  // create doctor button

            left_box.getChildren().addAll(patient_info_button,send_messages_button,log_out_button);

            left_box.setSpacing(20);
            main_patient_grid.add(left_box, 0,2);

            GridPane center_grid = new GridPane();
            Label center_title = new Label("Log In");
            center_title.setFont(new Font("Cambria", 32));
            center_grid.add(center_title, 0,0);

            Label username_label = new Label("Username");
            Label password_label = new Label("Password");

            TextField username_field = new TextField();
            TextField password_field = new TextField();

            Button log_in_button = new Button("Log In");
            center_grid.add(username_label, 0,2);
            center_grid.add(username_field, 1,2);
            center_grid.add(password_label, 0,3);
            center_grid.add(password_field, 1,3);
            center_grid.add(log_in_button, 2,4);
            main_patient_grid.add(center_grid, 2,2, 2,2);

            GridPane right_grid = new GridPane();
            Label right_title = new Label("Patient Information");
            right_title.setFont(new Font("Cambria", 32));
            Label name_label = new Label("Name");
            Label dob_label = new Label("Date of Birth");
            Label sex_label = new Label("Sex");
            Label address_label = new Label("Address");
            Label pat_num_label = new Label("Phone Number");
            Label pref_pharm_label = new Label("Preferred Pharmacy");
            Label em_con_label = new Label("Emergency Contact Information");
            Label em_name_label = new Label("Name");
            Label em_num_label = new Label("Phone Number");
            Label relationship_label = new Label("Relationship");

            right_grid.add(right_title, 0,0);
            right_grid.add(name_label, 0,1);
            right_grid.add(dob_label, 0,2);
            right_grid.add(sex_label, 0,3);
            right_grid.add(address_label, 0,4);
            right_grid.add(pat_num_label, 0,5);
            right_grid.add(pref_pharm_label, 0,6);
            right_grid.add(em_con_label, 0,7);
            right_grid.add(em_name_label, 0,8);
            right_grid.add(em_num_label, 0,9);
            right_grid.add(relationship_label, 0,10);

            TextField name_field = new TextField("Patient Name");
            TextField dob_field = new TextField("MM/DD/YYYY");
            TextField sex_field = new TextField("M/F");
            TextField address_field = new TextField("Enter");
            TextField phone_field = new TextField("000-000-0000");
            TextField pref_pharm_field = new TextField("Enter");
            TextField em_con_name_field = new TextField("Enter");
            TextField em_con_num_field = new TextField("Enter");
            TextField em_con_rel_field = new TextField("Enter");

            right_grid.add(name_field, 1,1);
            right_grid.add(dob_field, 1,2);
            right_grid.add(sex_field, 1,3);
            right_grid.add(address_field, 1,4);
            right_grid.add(phone_field, 1,5);
            right_grid.add(pref_pharm_field, 1,6);
            right_grid.add(em_con_name_field, 1,8);
            right_grid.add(em_con_num_field, 1,9);
            right_grid.add(em_con_rel_field, 1,10);

            Button edit_button_1 = new Button("edit");
            Button edit_button_2 = new Button("edit");
            Button edit_button_3 = new Button("edit");
            Button edit_button_4 = new Button("edit");
            Button edit_button_5 = new Button("edit");
            Button edit_button_6 = new Button("edit");
            Button pat_sub_button = new Button("Submit");

            right_grid.add(edit_button_1, 2,4);
            right_grid.add(edit_button_2, 2,5);
            right_grid.add(edit_button_3, 2,6);
            right_grid.add(edit_button_4, 2,8);
            right_grid.add(edit_button_5, 2,9);
            right_grid.add(edit_button_6, 2,10);
            right_grid.add(pat_sub_button, 3,11);

            main_patient_grid.add(right_grid, 4,2, 2,1);

            main_patient_grid.setHgap(10);
            main_patient_grid.setVgap(10);

            Scene patient_page = new Scene(main_patient_grid, 1200, 900);
            
            primaryStage.setScene(patient_page);
            primaryStage.setTitle("Patient Page");
            e.consume();
        });




    }

public static void main(String[] args) {launch(args);}; // method inside application class that sets up javafx application
}