package com.example.bgi.Models;

public class UserModel {

    String teacherId,profilepic , name , id , email , mobileno,pass,conpass;

    public UserModel(){}



    public String getConpass() {
        return conpass;
    }

    public void setConpass(String conpass) {
        this.conpass = conpass;
    }

    public String getTeacherId(String key) {
        return teacherId;
    }

    public void setTeacherId(String studentId) {
        this.teacherId = teacherId;
    }


    public UserModel(String TeacherID, String Full_Name , String Id_No , String Email , String Mobile_No, String Password , String Con_Password ) {
        this.teacherId = TeacherID;
        this.name = Full_Name;
        this.id = Id_No;
        this.email = Email;
        this.mobileno = Mobile_No;
        this.pass = Password;
        this.conpass = Con_Password;
    }
//    public UserModel(String Full_Name ,String Enroll ,String Email ,String Mobile_No,String Password ,String Con_Password ) {
//        this.name = Full_Name;
//        this.id = Email;
//        this.email = Email;
//        this.mobileno = Mobile_No;
//        this.pass = Password;
//        this.conpass = Con_Password;
//    }
    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
