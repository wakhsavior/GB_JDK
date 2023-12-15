package Seminar_04_HW;

import java.util.Objects;

public class Employee {
    private static int nextNumber = 0;
    private final int id;
    private String phoneNumber;
    private String name;
    private int experienceMonth;

    {
        id = ++nextNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getExperienceMonth() {
        return experienceMonth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperienceMonth(int experienceMonth) {
        this.experienceMonth = experienceMonth;
    }

    public Employee(String phoneNumber, String name, int experienceMonth) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experienceMonth = experienceMonth;
    }
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experienceMonth=" + experienceMonth +
                '}';
    }
}
