//authors: Braeden Ellershaw, Xavier Sauceda, Drew Mudry, Cole Barazota, Evan Stenson
//Description: Prototype code for a healthcare portal
//October 24, 2021
//test changes

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
import java.io.*;


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

            Label patient_title = new Label("Login Portal");//title for the patient portal page
            patient_title.setFont(new Font("Cambria", 40));//change font and size
            main_patient_grid.add(patient_title, 0,0);//main grid for the patient portal page

            VBox left_box = new VBox(3);
            Button patient_info_button = new Button("Patient Information");//create patient information button
            Button send_messages_button = new Button("Send Message") ; // create patient button
            Button log_out_button = new Button("Log Out"); //create nurse button
            Button back_button = new Button("Back"); // create back button

            patient_info_button.setPrefSize(200,100);  //create doctor button
            send_messages_button.setPrefSize(200,100);  //create doctor button
            log_out_button.setPrefSize(200,100);  //create doctor button
            back_button.setPrefSize(200,100); // create back button

            left_box.getChildren().addAll(patient_info_button,send_messages_button,log_out_button, back_button); //add all the buttons to the left_box VBox
            left_box.setSpacing(20); //add spacing to the vbox for formatting
            main_patient_grid.add(left_box, 0,2);//add left box to the main grid

            back_button.setOnAction((d) -> {
                primaryStage.setScene(start_page); //return to start page (path back to home page)
                primaryStage.setTitle("Login Page");//set title at top of page
            });//set title at top of page);

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

            //TODO: Create a new patient button

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
            primaryStage.setTitle("Login Portal");//title for the patient page
            e.consume();//consume the action so it can be reset

            
            //TODO: existing patient login      
            log_in_button.setOnAction((d) -> {
                if (-1 != checkLogin(username_field.getText(), password_field.getText())) {
                        System.out.print("Login worked");       //debug
                        /*name_field = ;
                        dob_field = ;
                        sex_field = ;
                        address_field = ;
                        phone_field = ;
                        pref_pharm_field = ;
                        em_con_name_field = ;
                        em_con_num_field = ;
                        em_con_rel_field = ;*/
                    }
                else{
                    System.out.print("Login didnt work");       //debug
                    //Dont really need a 'login failed' GUI
                }
                /*switch (checkLogin(username_field.getText(), password_field.getText()).charAt(0)) {
                    case 0: //doctor

                        break;
                    case 1: //nurse

                        break;
                    case 2: //patient
                        
                        break;
                }*/
            d.consume();
            });
        });

        newpatientButton.setOnAction((e) -> {//change scene when new patient button is clicked
            GridPane newPatientGrid = new GridPane();

            newPatientGrid.prefWidthProperty().bind(primaryStage.widthProperty().multiply(100));//bind the width of the gridbox to the primary stage

            VBox newPatientPage = new VBox(3);
            Scene newPatientScene = new Scene(newPatientPage, 600, 600);
            primaryStage.setScene(newPatientScene);

            // Setting up buttons (copied from patient page above)
            Button patient_info_button = new Button("Patient Information");//create patient information button
            Button send_messages_button = new Button("Send Message") ; // create patient button
            Button log_out_button = new Button("Log Out"); //create nurse button
            Button back_button = new Button("Back"); // create back button

            patient_info_button.setPrefSize(200,100);  //style doctor button
            send_messages_button.setPrefSize(200,100);  //style doctor button
            log_out_button.setPrefSize(200,100);  //style doctor button
            back_button.setPrefSize(200,100); // style back button

            //TODO: 

            back_button.setOnAction((d) -> {
                primaryStage.setScene(start_page); //return to start page (path back to home page)
                primaryStage.setTitle("Login Page");//set title at top of page
            });//set title at top of page);


            Label new_patient_title = new Label("New Patient Portal");//title for the patient portal page
            new_patient_title.setFont(new Font("Cambria", 40));//change font and size
            newPatientGrid.add(new_patient_title, 0,0);//main grid for the patient portal page

            newPatientPage.getChildren().addAll(patient_info_button, send_messages_button, log_out_button, back_button);
        
        });

    }

public static void main(String[] args) {launch(args);}; // method inside application class that sets up javafx application

    static void print(String toPrint){
        System.out.println(toPrint);
        }

    static int checkLogin(String uname, String pass){
        File login_file = new File("C:/Users/nofam/Desktop/CSE360/CSE360team1/database/loginData.csv");

        try{
            Scanner login_scanner = new Scanner(login_file);
            int i = 0;
            while (login_scanner.hasNextLine()) {
                if (i == 0){
                    String current_line = login_scanner.nextLine();
                    i++;
                }
                else{

                String current_line = login_scanner.nextLine();
                print("current_line" + current_line);
                String file_uname = current_line.substring(0,current_line.indexOf(","));
                String file_pass = current_line.substring((current_line.indexOf(",") + 1),(current_line.indexOf(",",(current_line.indexOf(",") + 1))));
                String file_pos = current_line.substring((current_line.indexOf(",",(current_line.indexOf(",") + 1)) + 1),current_line.lastIndexOf(","));
                int file_id = Integer.parseInt(current_line.substring((current_line.lastIndexOf(",") + 1)));
                /*
                print(uname);
                print(file_uname);
                print(pass);
                print(file_pass);
                */
                if ((file_uname.compareTo(uname) == 0) && (file_pass.compareTo(pass) == 0)){
                    login_scanner.close();
                    print("Login worked");
                    return file_id;//if matching username and password, return id
                }
             }
            }
            login_scanner.close();
            print("Login didnt work");
            return -1;//no matching username or password is found, return -1
            
        }
        catch(FileNotFoundException e){
            print("FNF");
            return -1;
        }
    }
}