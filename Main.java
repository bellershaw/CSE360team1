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


public class Main extends Application{//application definition

    @Override
    public void start (Stage primaryStage){//main stage in project, is the log in page
        primaryStage.setTitle("Login Page");//set title at top of page
        Button expatientButton = new Button("I am an exiting patient");  //create doctor button
        Button newpatientButton = new Button("I am a new patient") ; //create patient button
        Button nursedocButton = new Button("I am a doctor or nurse"); //create nurse button

        //create buttons for log in page
        expatientButton.setPrefSize(200,100);
        newpatientButton.setPrefSize(200,100);
        nursedocButton.setPrefSize(200,100);

        //create VBox for log in page and add buttons 
        VBox login_vbox = new VBox();
        login_vbox.setAlignment(Pos.CENTER);
        login_vbox.getChildren().addAll(expatientButton,newpatientButton,nursedocButton);//add all the buttons to the left_box VBox

        //create scene for start page
        Scene start_page = new Scene(login_vbox, 600, 600); //create scene containing the log in vbox
        primaryStage.setScene(start_page);//initialize log in page scene
        primaryStage.show(); // show the stage

        expatientButton.setOnAction((e) -> {//change scene when existing patient button is clicked
            GridPane main_patient_grid = new GridPane();
            main_patient_grid.prefWidthProperty().bind(primaryStage.widthProperty().multiply(100));//bind the width of the gridbox to the primary stage
            //main_patient_grid.setGridLinesVisible(true);//debugging, used to view grid lines

            Label patient_title = new Label("Patient Portal");//title for the patient portal page
            patient_title.setFont(new Font("Cambria", 40));//change font and size
            main_patient_grid.add(patient_title, 0,0);//main grid for the patient portal page

            VBox left_box = new VBox(3);
            Button patient_info_button = new Button("Patient Information");//create patient information button
            Button send_messages_button = new Button("Send Message") ; // create patient button
            Button log_out_button = new Button("Log Out"); //create nurse button

            patient_info_button.setPrefSize(200,100);  //create doctor button
            send_messages_button.setPrefSize(200,100);  //create doctor button
            log_out_button.setPrefSize(200,100);  //create doctor button

            left_box.getChildren().addAll(patient_info_button,send_messages_button,log_out_button);//add all the buttons to the left_box VBox
            left_box.setSpacing(20); //add spacing to the vbox for formatting
            main_patient_grid.add(left_box, 0,2);//add left box to the main grid

            GridPane center_grid = new GridPane();//create a new gridpane for the center panel
            Label center_title = new Label("Log In");//add label to center panel
            center_title.setFont(new Font("Cambria", 32));//change title font
            center_grid.add(center_title, 0,0);//add center title to the center grid

            //create labels for the username and password field for the center grid
            Label username_label = new Label("Username");
            Label password_label = new Label("Password");

            //create textfields for user to enter their username and password
            TextField username_field = new TextField();
            TextField password_field = new TextField();

            Button log_in_button = new Button("Log In");//button to submit username and password

            //add labels and text boxes to the center grid
            center_grid.add(username_label, 0,2);
            center_grid.add(username_field, 1,2);
            center_grid.add(password_label, 0,3);
            center_grid.add(password_field, 1,3);
            center_grid.add(log_in_button, 2,4);
            main_patient_grid.add(center_grid, 2,2, 2,2);//add the center grid to the main grid

            GridPane right_grid = new GridPane();//create new gridpane for the right panel
            //create labels for information shown on the right panel
            Label right_title = new Label("Patient Information");//title for the right panel
            right_title.setFont(new Font("Cambria", 32));//change right panel title font
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

            //add labels to the right panel grid
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

            //create textfields for right panel information
            TextField name_field = new TextField("Patient Name");
            TextField dob_field = new TextField("MM/DD/YYYY");
            TextField sex_field = new TextField("M/F");
            TextField address_field = new TextField("Enter");
            TextField phone_field = new TextField("000-000-0000");
            TextField pref_pharm_field = new TextField("Enter");
            TextField em_con_name_field = new TextField("Enter");
            TextField em_con_num_field = new TextField("Enter");
            TextField em_con_rel_field = new TextField("Enter");

            //add textfields to the right panel grid
            right_grid.add(name_field, 1,1);
            right_grid.add(dob_field, 1,2);
            right_grid.add(sex_field, 1,3);
            right_grid.add(address_field, 1,4);
            right_grid.add(phone_field, 1,5);
            right_grid.add(pref_pharm_field, 1,6);
            right_grid.add(em_con_name_field, 1,8);
            right_grid.add(em_con_num_field, 1,9);
            right_grid.add(em_con_rel_field, 1,10);

            //buttons to submit changes to some of the patient information
            Button edit_button_1 = new Button("edit");
            Button edit_button_2 = new Button("edit");
            Button edit_button_3 = new Button("edit");
            Button edit_button_4 = new Button("edit");
            Button edit_button_5 = new Button("edit");
            Button edit_button_6 = new Button("edit");
            Button pat_sub_button = new Button("Submit");//button to submit the new data

            //add edit and submit buttons to the right panel
            right_grid.add(edit_button_1, 2,4);
            right_grid.add(edit_button_2, 2,5);
            right_grid.add(edit_button_3, 2,6);
            right_grid.add(edit_button_4, 2,8);
            right_grid.add(edit_button_5, 2,9);
            right_grid.add(edit_button_6, 2,10);
            right_grid.add(pat_sub_button, 3,11);

            main_patient_grid.add(right_grid, 4,2, 2,1);//add right grid to the main grid

            main_patient_grid.setHgap(10);//set the horizontal gap between panels
            main_patient_grid.setVgap(10);//set the vertical gap between panels

            Scene patient_page = new Scene(main_patient_grid, 1200, 900);//create patient portal scene containing the main patient grid
            
            primaryStage.setScene(patient_page);//make the scene the patient page
            primaryStage.setTitle("Patient Page");//title for the patient page
            e.consume();//consume the action so it can be reset
        });

    }

public static void main(String[] args) {launch(args);}; // method inside application class that sets up javafx application
}