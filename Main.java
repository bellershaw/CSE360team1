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
        Patient current_patient = new Patient();
        primaryStage.setTitle("Login Page");//set title at top of page
        Button expatientButton = new Button("Login");
        Button newpatientButton = new Button("I am a new user"); //create patient button


        //create buttons for log in page
        expatientButton.setPrefSize(200,100);
        newpatientButton.setPrefSize(200,100);

        //create VBox for log in page and add buttons 
        VBox login_vbox = new VBox();
        login_vbox.setAlignment(Pos.CENTER);
        login_vbox.getChildren().addAll(expatientButton,newpatientButton);//add all the buttons to the left_box VBox

        //create scene for start page
        Scene start_page = new Scene(login_vbox, 600, 600); //create scene containing the log in vbox
        primaryStage.setScene(start_page);//initialize log in page scene
        primaryStage.show(); // show the stage

        expatientButton.setOnAction((e) -> {//change scene when existing patient button is clicked
            e.consume();//consume the action so it can be reset
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
                d.consume();
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
            Label name_field = new Label("Patient Name");
            Label dob_field = new Label("MM/DD/YYYY");
            Label sex_field = new Label("M/F");
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
            Button pat_sub_button = new Button("Submit");//button to submit the new data
            pat_sub_button.setOnAction((z) -> {
                current_patient.setAddress(address_field.getText());
                current_patient.setPhoneNumber(phone_field.getText());
                current_patient.setPrefPharm(pref_pharm_field.getText());
                current_patient.setEMC_name(em_con_name_field.getText());
                current_patient.setEMC_phoneNumber(em_con_num_field.getText());
                current_patient.setEMC_relationship(em_con_rel_field.getText());
                toCsv(current_patient);
                z.consume();
            });
            
            //add edit and submit buttons to the right panel
            right_grid.add(pat_sub_button, 3,11);

            main_patient_grid.add(right_grid, 4,2, 2,1);//add right grid to the main grid

            main_patient_grid.setHgap(10);//set the horizontal gap between panels
            main_patient_grid.setVgap(10);//set the vertical gap between panels

            Scene patient_page = new Scene(main_patient_grid, 1200, 900);//create patient portal scene containing the main patient grid
            
            primaryStage.setScene(patient_page);//make the scene the patient page
            primaryStage.setTitle("Login Portal");//title for the patient page

            
            //TODO: existing patient login      
            log_in_button.setOnAction((a) -> {
                int id = checkLogin(username_field.getText(), password_field.getText());
                if (-1 != id) {
                    System.out.print("Login worked");       //debug
                    print(id);
                    char perms = String.valueOf(id).charAt(0);
                    System.out.println(perms);
                    String[] pat_array = new String[10];
                    switch (perms) {
                        case '0':               //doctor
                            
                            //pat_array = getPatInfo(id);
                            //first and last name search box. finds patient and sets the patient id to the id
                            //TODO: textbox to input patient first and last name and a submit button to search up the patient. finds a patient matching the name and returns their ID

                            TextField firstName_field = new TextField();
                            TextField lastName_field = new TextField();
                            Label searchBar = new Label("FirstLastName");
            
                            Button searchPatient = new Button("Search Patient");

                            /*
                            searchPatient.setOnAction((g) -> {
                                id = choosePatInfo(firstName_field.getText(), lastName_field.getText());
                                g.consume();
                            });
                            */
                            

                            break;
                        case '1':               //nurse
                            /*
                            id = choosePatInfo(firstName_field.getText(), lastName_field.getText());
                            */
                            //first and last name search box. finds patient and sets the patient id to the id
                            break;
                        case '2':               //patient
                        pat_array = getPatInfo(id);
                            break;
                    }

                    current_patient.setID(pat_array[0]);
                    current_patient.setName(pat_array[1]);
                    current_patient.setDOB(pat_array[2]);
                    current_patient.setSex(pat_array[3]);
                    current_patient.setAddress(pat_array[4]);
                    current_patient.setPhoneNumber(pat_array[5]);
                    current_patient.setPrefPharm(pat_array[6]);
                    current_patient.setEMC_name(pat_array[7]);
                    current_patient.setEMC_phoneNumber(pat_array[8]);
                    current_patient.setEMC_relationship(pat_array[9]);

                    name_field.setText(pat_array[1]);
                    dob_field.setText(pat_array[2]);
                    sex_field.setText(pat_array[3]);
                    address_field.setText(pat_array[4]);
                    phone_field.setText(pat_array[5]);
                    pref_pharm_field.setText(pat_array[6]);
                    em_con_name_field.setText(pat_array[7]);
                    em_con_num_field.setText(pat_array[8]);
                    em_con_rel_field.setText(pat_array[9]);

                }
                else{
                    System.out.print("Login didnt work");       //debug
                    //Dont really need a 'login failed' GUI
                }
                
            a.consume();
            });
        
        newpatientButton.setOnAction((m) -> {//change scene when new patient button is clicked
            GridPane newPatientGrid = new GridPane();

            newPatientGrid.prefWidthProperty().bind(primaryStage.widthProperty().multiply(100));//bind the width of the gridbox to the primary stage

            VBox newPatientPage = new VBox(3);
            Scene newPatientScene = new Scene(newPatientPage, 600, 600);
            primaryStage.setScene(newPatientScene);

            // Setting up buttons (copied from patient page above)
            Button patient_info_button_2 = new Button("Patient Information");//create patient information button
            Button send_messages_button_2 = new Button("Send Message"); // create patient button
            Button log_out_button_2 = new Button("Log Out"); //create nurse button
            Button back_button_2 = new Button("Back"); // create back button

            patient_info_button_2.setPrefSize(200,100);  //style doctor button
            send_messages_button_2.setPrefSize(200,100);  //style doctor button
            log_out_button_2.setPrefSize(200,100);  //style doctor button
            back_button_2.setPrefSize(200,100); // style back button


            back_button.setOnAction((h) -> {
                primaryStage.setScene(start_page); //return to start page (path back to home page)
                primaryStage.setTitle("Login Page");//set title at top of page
                h.consume();
            });//set title at top of page);


            Label new_patient_title = new Label("New Patient Portal");//title for the patient portal page
            new_patient_title.setFont(new Font("Cambria", 40));//change font and size
            newPatientGrid.add(new_patient_title, 0,0);//main grid for the patient portal page

            newPatientPage.getChildren().addAll(patient_info_button_2, send_messages_button_2, log_out_button_2, back_button_2);
            m.consume();
        });
        
    });

    };

public static void main(String[] args) {launch(args);}; // method inside application class that sets up javafx application

    static void print(Object toPrint){//custom print function so we dont have to type system.out everytime
        System.out.println(toPrint);
        }

    static int checkLogin(String uname, String pass) {
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
    static String[] getPatInfo(int id){
        String[] return_string = new String[10];
        File login_file = new File("C:/Users/nofam/Desktop/CSE360/CSE360team1/database/patientInfo.csv");
        try{
            Scanner login_scanner = new Scanner(login_file);
            String current_line;
            int i = 0;
            while (login_scanner.hasNextLine()) {
                if (i == 0){
                    current_line = login_scanner.nextLine();
                    i++;
                }
                else{
                    current_line = login_scanner.nextLine();
                    int file_id = Integer.parseInt(current_line.substring(0,current_line.indexOf(",")));
                    if(id == file_id){
                        print("id found");
                        for (int j = 0; j< 10; j++ ){
                            //print(current_line);
                            if (j < 9){
                                return_string[j] = current_line.substring(0,current_line.indexOf(","));
                            }
                            else{
                                return_string[j] = current_line.substring(current_line.indexOf(",") + 1);
                            }
                            current_line = current_line.substring(current_line.indexOf(",") + 1);
                            
                        }
                    }
                }
            }
            login_scanner.close();
           //no matching username or password is found, return -1
           return return_string;
            
        }
        catch(FileNotFoundException e){
            print("FNF");
            return return_string;
        }
    }


    static int choosePatInfo(String firstName, String lastName){
        String savedName = firstName + " " + lastName;
        File login_file = new File("C:/Users/nofam/Desktop/CSE360/CSE360team1/database/patientInfo.csv");
        try{
            Scanner login_scanner = new Scanner(login_file);
            String current_line;
            int i = 0;
            while (login_scanner.hasNextLine()) {
                if (i == 0){
                    current_line = login_scanner.nextLine();
                    i++;
                }
                else{
                    current_line = login_scanner.nextLine();
                    int line_id = Integer.parseInt(current_line.substring(0,current_line.indexOf(",")));
                    String line_name = current_line.substring(0,current_line.indexOf(","));            //get string of first and last name of person
                    if(line_name.equals(savedName)){            //if the first and last name of the person on this line of the csv matches the person we're searching for...
                        print("person search found");
                        login_scanner.close();
                        return line_id;                         //
                    }
                }
            }
            login_scanner.close();
           //no matching firstname and lastname is found, return -1
           return -2;
            
        }
        catch(FileNotFoundException e){
            print("FNF");
            return -1;      //exception: -1
        }
    }
        
    static void changeInfo(int info_num, String new_info, Patient this_patient){
        int id = this_patient.getID();
        String[] info_array = getPatInfo(id);
        info_array[info_num] = new_info;

        switch(info_num){
            case(4):
                this_patient.setAddress(new_info);
            case(5):
                this_patient.setPhoneNumber(new_info);
            case(6):
                this_patient.setPrefPharm(new_info);
            case(7):
                this_patient.setEMC_name(new_info);
            case(8):
                this_patient.setEMC_phoneNumber(new_info);
            case(9):
                this_patient.setEMC_relationship(new_info);
        }
        return;
    }

    static void toCsv(Patient changed_pat){
        File pat_file = new File("C:/Users/nofam/Desktop/CSE360/CSE360team1/database/patientInfo.csv");
            String[] patient_array = new String[1000];
            int num_lines = 0;
            try{
                Scanner pat_scanner = new Scanner(pat_file);
                String current_line;
                while (pat_scanner.hasNextLine()) {
                    patient_array[num_lines] = pat_scanner.nextLine();
                    num_lines++;
                }//end while
                pat_scanner.close();
            }//end try
            
            catch(FileNotFoundException e){
                print("FNF");
            }//end catch
            
            //write to file
            try(FileWriter writer = new FileWriter("C:/Users/nofam/Desktop/CSE360/CSE360team1/database/patientInfo.csv")){
                for (int i = 0; i < num_lines; i++){
                    //ID,Name,DOB,Sex,Address,Phone Number,Prefered Pharmacy,EMC_Name,EMC_Phone Number,EMC_Relationship
                    if (String.valueOf(changed_pat.getID()).compareTo(patient_array[i].substring(0,patient_array[i].indexOf(","))) == 0){
                        writer.write(String.valueOf("\n" + changed_pat.getID()) + "," + changed_pat.getName() + "," + changed_pat.getDOB() 
                        + changed_pat.getSex() + "," + changed_pat.getAddress() + "," + changed_pat.getPhoneNumber() + "," + changed_pat.getPrefPharm() + "," +
                        changed_pat.getEMC_name() + "," + changed_pat.getEMC_phoneNumber() + "," + changed_pat.getEMC_relationship());
                    }
                    else{
                        writer.write(patient_array[i]);
                    }
                }
                writer.close();
            }//end try
            catch(FileNotFoundException e){
                print("FNF");
            }//end catch
            catch(IOException ie) {
                print("IO");
            }   
       
    }//end function

}//end main 
