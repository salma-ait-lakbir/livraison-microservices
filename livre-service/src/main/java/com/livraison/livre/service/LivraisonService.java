package com.livraison.livre.service;

import com.livraison.livre.entity.Livraison;

import java.util.List;
import java.util.Optional;

public interface LivraisonService {
    Livraison saveLivraison(Livraison livraison);
    Optional<Livraison> getLivraisonById(Long id);
    List<Livraison> getAllLivraisons();
    List<Livraison> getLivraisonsByCommandeId(Long commandeId);
}
