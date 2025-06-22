package com.livraison.commande.service;

import com.livraison.commande.entity.Commande;
import com.livraison.commande.repository.CommandeRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CommandeServiceTest {

    @Test
    void testGetCommandeById() {
        CommandeRepository commandeRepository = mock(CommandeRepository.class);
        CommandeService commandeService = new CommandeService(commandeRepository);

        Commande commande = new Commande();
        commande.setId(1L);

        when(commandeRepository.findById(1L)).thenReturn(Optional.of(commande));

        Optional<Commande> found = commandeService.getCommandeById(1L);

        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }
}
