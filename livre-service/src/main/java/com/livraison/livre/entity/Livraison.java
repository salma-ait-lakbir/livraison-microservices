package com.livraison.livre.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "livraisons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long commandeId;
    private String adresseLivraison;
    private LocalDateTime dateLivraison;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}