package com.livraison.commande.service;

import com.livraison.commande.entity.Commande;
import com.livraison.commande.repository.CommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    public Commande saveCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public Optional<Commande> getCommandeById(Long id) {
        return commandeRepository.findById(id);
    }

    public List<Commande> getCommandesByUserId(Long userId) {
        return commandeRepository.findByUserId(userId);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }
}