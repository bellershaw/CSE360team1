public class Patient {
    private int ID;
    private String name;
    private String DOB;
    private String sex;
    private String address;
    private String phoneNumber;
    private String prefPharm;
    private String EMC_name;
    private String EMC_phoneNumber;
    private String EMC_relationship;

    //Default Constructor
    public Patient() {
        ID = -1;
        name = "";
        DOB = "";
        sex = "";
        address = "";
        phoneNumber = "";
        prefPharm = "";
        EMC_name = "";
        EMC_phoneNumber = "";
        EMC_relationship = "";
    }
    //Overloarded Constructor
        public Patient(int id, String Name, String dob, String Sex, String addy, String phoneNum, String pharm, String EMCname, String EMCnum, String EMCrel) {
        ID = id;
        name = Name;
        DOB = dob;
        sex = Sex;
        address = addy;
        phoneNumber = phoneNum;
        prefPharm = pharm;
        EMC_name = EMCname;
        EMC_phoneNumber = EMCnum;
        EMC_relationship = EMCrel;
    }

    public int getID(){
        return ID;
    }

    public String getName(){
        return name;
    }

    public String getDOB(){
        return DOB;
    }

    public String getSex(){
        return sex;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getPrefPharm(){
        return prefPharm;
    }

    public String getEMC_name(){
        return EMC_name;
    }
    
    public String getEMC_phoneNumber(){
        return EMC_phoneNumber;
    }

    public String getEMC_relationship(){
        return EMC_relationship;
    }

    public void setID(String id) {

        ID = Integer.parseInt(id);
    }

    public void setID(int id) {

        ID = id;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setDOB(String dob) {
        DOB = dob;
    }

    public void setSex(String Sex) {
        sex = Sex;
    }

    public void setAddress(String new_add){
        address = new_add;
    }

    public void setPhoneNumber (String new_phoneNumber){
        phoneNumber = new_phoneNumber;
    }

    public void setPrefPharm (String new_prefPharm){
        prefPharm = new_prefPharm;
    }

    public void setEMC_name (String new_EMC_name){
        EMC_name = new_EMC_name;
    }

    public void setEMC_phoneNumber (String new_EMC_phoneNumber){
        EMC_phoneNumber = new_EMC_phoneNumber;
    }

    public void setEMC_relationship(String new_EMC_relationship){
        EMC_relationship = new_EMC_relationship;
    }
}