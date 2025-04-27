package dev.caloramp.buste.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.caloramp.buste.Models.Busta;

public interface BustaRepository extends JpaRepository<Busta, Long> {
    public List<Busta> findByClienteId(Long idCliente); // Trova tutte le buste per un cliente specifico
}
