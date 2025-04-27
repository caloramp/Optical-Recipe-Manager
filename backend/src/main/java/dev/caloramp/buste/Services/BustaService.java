package dev.caloramp.buste.Services;

import java.util.List;

import dev.caloramp.buste.Models.Busta;

public interface BustaService {
    public Busta creaBusta(Busta busta);
    public List<Busta> mostraBuste();
    public Busta cercaBustaPerId(Long id);
    public List<Busta> cercaBustePerIdCliente(Long idCliente);
}
