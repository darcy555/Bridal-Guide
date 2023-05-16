package Bridal_Guide.bridal_guide.model;

import jakarta.persistence.*;

@Entity
@Table(name="appointment_table")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fullName;
    private String email;
    private int phoneNumber;
    private int budget;
    private int guest;

    public Appointment() {
    }

    public Appointment(int id, String fullName, String email, int phoneNumber, int budget, int guest) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.budget = budget;
        this.guest = guest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }
}
