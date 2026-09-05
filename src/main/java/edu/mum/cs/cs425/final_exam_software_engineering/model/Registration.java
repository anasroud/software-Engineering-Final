package edu.mum.cs.cs425.final_exam_software_engineering.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;

    @NotNull
    @Column(name = "student_name")
    private String student_name;

    @JoinColumn
    @Column(name = "workshop")
    private Long workshop;

    @NotNull
    @Column(name = "student_email")
    private String student_email;

    @Column(name = "registration_date")
    private LocalDate registration_date;

    public Registration() {
    }

    public Registration(String student_name, String student_email, LocalDate registration_date) {
        this.student_name = student_name;
        this.student_email = student_email;
        this.registration_date = registration_date;
    }

    public Long getRegistrationId() { return registrationId; }
    public void setRegistrationId(Long registrationId) { this.registrationId = registrationId; }

    public Long getWorkshop() { return workshop; }
    public void setWorkshop(Long workshop) { this.workshop = workshop; }

    public String getStudent_name() { return student_name; }
    public void setStudent_name(String student_name) { this.student_name = student_name; }

    public String getStudent_email() { return student_email; }
    public void setStudent_email(String student_email) { this.student_email = student_email; }

    public LocalDate getRegistration_date() { return registration_date; }
    public void setRegistration_date(LocalDate registration_date) { this.registration_date = registration_date; }

}
