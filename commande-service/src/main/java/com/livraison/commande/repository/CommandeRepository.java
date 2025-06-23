package com.livraison.commande.repository;

import com.livraison.commande.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
    List<Commande> findByUserId(Long userId);
}