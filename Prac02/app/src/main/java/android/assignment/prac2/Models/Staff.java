package android.assignment.prac2.Models;

import java.util.Date;


public class Staff {
    private String staffId;
    private String fullName;
    private String birthDay;
    private Integer salary;

    public Staff(String birthDay, String fullName, Integer salary, String staffId) {
        this.birthDay = birthDay;
        this.fullName = fullName;
        this.salary = salary;
        this.staffId = staffId;
    }

    public Staff() {
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
