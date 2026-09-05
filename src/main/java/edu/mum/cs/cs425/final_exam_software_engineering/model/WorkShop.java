package edu.mum.cs.cs425.final_exam_software_engineering.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "work_shops")
public class WorkShop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workShop_id")
    private Long workShopId;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    @OneToMany
    @Column(name = "registrations")
    private List<Registration> registrations;

    @Column(name = "date")
    private LocalDate date;

    @NotNull
    @Column(name = "venue")
    private String venue;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "registration_deadline")
    private LocalDate registration_deadline;

    public WorkShop() {
    }

    public WorkShop(String title, String description, LocalDate date, String venue, int capacity, LocalDate registration_deadline) {
        this.title = title;
        this.registrations = List.of();
        this.description = description;
        this.date = date;
        this.venue = venue;
        this.capacity = capacity;
        this.registration_deadline = registration_deadline;
    }

    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
        this.capacity--;
    }

    public Long getWorkShopId() { return workShopId; }
    public void setWorkShopId(Long workShopId) { this.workShopId = workShopId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public void decrementCapacity() {
        this.capacity--;
    }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public LocalDate getRegistration_deadline() { return registration_deadline; }
    public void setRegistration_deadline(LocalDate registration_deadline) { this.registration_deadline = registration_deadline; }

}
