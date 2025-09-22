package entities;

import java.time.LocalDate;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(int id, String lastName, String firstName, String middleName,
                   LocalDate birthDate, String address, String phone,
                   String faculty, int course, String group) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }

    @Override
    public String toString() {
        return id + ". " + lastName + " " + firstName + " " + middleName +
                " | " + birthDate + " | " + faculty + " | " + course + " курс | група " + group;
    }

    public String getFaculty() { return faculty; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getGroup() { return group; }
}
