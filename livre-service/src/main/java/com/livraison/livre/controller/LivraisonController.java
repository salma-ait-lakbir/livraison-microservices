package com.livraison.livre.controller;

import com.livraison.livre.entity.Livraison;
import com.livraison.livre.service.LivraisonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livraisons")
public class LivraisonController {

    private final LivraisonService livraisonService;

    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }

    @PostMapping
    public ResponseEntity<Livraison> createLivraison(@RequestBody Livraison livraison) {
        return ResponseEntity.ok(livraisonService.saveLivraison(livraison));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livraison> getLivraison(@PathVariable Long id) {
        return livraisonService.getLivraisonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Livraison>> getAllLivraisons() {
        return ResponseEntity.ok(livraisonService.getAllLivraisons());
    }

    @GetMapping("/commande/{commandeId}")
    public ResponseEntity<List<Livraison>> getLivraisonsByCommandeId(@PathVariable Long commandeId) {
        return ResponseEntity.ok(livraisonService.getLivraisonsByCommandeId(commandeId));
    }
}
