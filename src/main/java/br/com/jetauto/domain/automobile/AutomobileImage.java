package br.com.jetauto.domain.automobile;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "automobile_images")
public class AutomobileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "automobile_id", nullable = false)
    private Automobile automobile;

    @Column(nullable = false)
    private final LocalDateTime uploadedAt = LocalDateTime.now();

    public AutomobileImage(){}

    public AutomobileImage(UUID id, String filePath, Automobile automobile) {
        this.id = id;
        this.filePath = filePath;
        this.automobile = automobile;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Automobile getAutomobile() {
        return automobile;
    }

    public void setAutomobile(Automobile automobile) {
        this.automobile = automobile;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }
}