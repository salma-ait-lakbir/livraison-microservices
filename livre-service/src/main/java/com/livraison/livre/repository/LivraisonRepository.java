package com.livraison.livre.repository;

import com.livraison.livre.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivraisonRepository extends JpaRepository<Livraison, Long> {
    List<Livraison> findByCommandeId(Long commandeId);
}
