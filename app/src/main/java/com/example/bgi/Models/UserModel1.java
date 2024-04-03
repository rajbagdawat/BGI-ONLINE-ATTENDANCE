package com.example.bgi.Models;

public class UserModel1 {

    String studentId,profilepic, name, enroll, email, mobileno, year, branch, sem_section, pass, conpass ,checkbox,stuname;

    public UserModel1() {
    }

    public String getStudentId(String key) {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public UserModel1(String StudentID, String Full_Name, String Enroll, String Email, String Mobile_No, String Year, String Branch, String Sem_Section, String Password, String Con_Password) {
        this.studentId = StudentID;
        this.name = Full_Name;
        this.enroll = Enroll;
        this.email = Email;
        this.mobileno = Mobile_No;
        this.year = Year;
        this.branch = Branch;
        this.sem_section = Sem_Section;
        this.pass = Password;
        this.conpass = Con_Password;
    }

    public String getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(String checkbox) {
        this.checkbox = checkbox;
    }

    public UserModel1(String profile, String Full_Name, String Enroll, String checkbox) {
        this.profilepic = profile;
        this.name = Full_Name;
        this.enroll = Enroll;
        this.checkbox = checkbox;

    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public UserModel1(String stuname){
        this.stuname = stuname;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSem_section() {
        return sem_section;
    }

    public void setSem_section(String sem_section) {
        this.sem_section = sem_section;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConpass() {
        return conpass;
    }

    public void setConpass(String conpass) {
        this.conpass = conpass;
    }
}