package com.livraison.auth.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder // 🔧 Cette ligne est nécessaire pour générer la méthode builder()
@Getter
@Setter
@NoArgsConstructor // Requis par JPA
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        USER, ADMIN
    }
}

