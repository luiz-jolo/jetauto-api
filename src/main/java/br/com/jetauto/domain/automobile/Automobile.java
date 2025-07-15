package br.com.jetauto.domain.automobile;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "automobiles")
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CarBody carBody;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer kilometerAge;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "automobile", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private Set<AutomobileImage> automobileImages;

    public Automobile() {
    }

    public Automobile(String model, String brand, String description, CarBody carBody, Integer year, Integer kilometerAge) {
        this.model = model;
        this.brand = brand;
        this.description = description;
        this.carBody = carBody;
        this.year = year;
        this.kilometerAge = kilometerAge;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CarBody getCarBody() {
        return carBody;
    }

    public void setCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getKilometerAge() {
        return kilometerAge;
    }

    public void setKilometerAge(Integer kilometerAge) {
        this.kilometerAge = kilometerAge;
    }

    public Set<AutomobileImage> getAutomobileImages() {
        return automobileImages;
    }

    public void setAutomobileImages(Set<AutomobileImage> automobileImages) {
        this.automobileImages = automobileImages;
    }
}
