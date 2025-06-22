package com.livraison.livre.service;

import com.livraison.livre.entity.Livraison;
import com.livraison.livre.repository.LivraisonRepository;
import com.livraison.livre.service.LivraisonServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LivraisonServiceTest {
    @Test
    void testSaveLivraison() {
        // Mock
        LivraisonRepository mockRepository = mock(LivraisonRepository.class);
        LivraisonServiceImpl livraisonService = new LivraisonServiceImpl(mockRepository);

        // Objet à sauvegarder
        Livraison livraison = Livraison.builder()
                .commandeId(100L)
                .adresseLivraison("Rabat, Maroc")
                .dateLivraison(LocalDateTime.now())
                .build();

        when(mockRepository.save(any(Livraison.class))).thenReturn(livraison);

        // Action
        Livraison saved = livraisonService.saveLivraison(livraison);

        // Assertions
        assertNotNull(saved);
        assertEquals("Rabat, Maroc", saved.getAdresseLivraison());
        verify(mockRepository, times(1)).save(livraison);
    }

    @Test
    void testGetLivraisonById() {
        LivraisonRepository mockRepository = mock(LivraisonRepository.class);
        LivraisonServiceImpl livraisonService = new LivraisonServiceImpl(mockRepository);

        Livraison livraison = Livraison.builder()
                .id(1L)
                .commandeId(100L)
                .adresseLivraison("Casablanca")
                .dateLivraison(LocalDateTime.now())
                .build();

        when(mockRepository.findById(1L)).thenReturn(Optional.of(livraison));

        Optional<Livraison> found = livraisonService.getLivraisonById(1L);

        assertTrue(found.isPresent());
        assertEquals("Casablanca", found.get().getAdresseLivraison());
    }
}