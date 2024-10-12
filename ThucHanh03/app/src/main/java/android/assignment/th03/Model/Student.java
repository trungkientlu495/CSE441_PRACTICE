package android.assignment.th03.Model;


import java.io.Serializable;

public class Student implements Serializable {
    private String id;
    private String gender;
    private String birthDay;
    private String email;
    private String address;
    private String major;
    private Double gpa;
    private String year;
    private int image;
    private String fullName;
    public Student() {
    }

    public Student(String address, String birthDay,
                   String email,
                   String gender, Double gpa,
                   String id, String fullName,
                   String major,
                   String year,int image) {
        this.address = address;
        this.birthDay = birthDay;
        this.email = email;
        this.gender = gender;
        this.gpa = gpa;
        this.id = id;
        this.major = major;
        this.fullName = fullName;
        this.year = year;
        this.image = image;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}
