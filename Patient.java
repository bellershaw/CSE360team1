public class Patient {
    private int ID;
    private String name;
    private String DOB;
    private char sex;
    private String address;
    private String phoneNumber;
    private String prefPharm;
    private String EMC_name;
    private String EMC_phoneNumber;
    private String EMC_relationship;

    //Constructor
    public Patient() {
        ID = -1;
        name = "";
        DOB = "";
        sex = 'y';
        address = "";
        phoneNumber = "";
        phoneNumber = "";
        prefPharm = "";
    }

    public void setID(int id){
        ID = id;
    }

    public void setName(String new_name){
        name = new_name;
    }

}
