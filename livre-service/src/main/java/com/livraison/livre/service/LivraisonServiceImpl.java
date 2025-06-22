package com.livraison.livre.service;

import com.livraison.livre.entity.Livraison;
import com.livraison.livre.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonServiceImpl implements LivraisonService {

    private final LivraisonRepository livraisonRepository;

    public LivraisonServiceImpl(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    @Override
    public Livraison saveLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }

    @Override
    public Optional<Livraison> getLivraisonById(Long id) {
        return livraisonRepository.findById(id);
    }

    @Override
    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }

    @Override
    public List<Livraison> getLivraisonsByCommandeId(Long commandeId) {
        return livraisonRepository.findByCommandeId(commandeId);
    }
}
