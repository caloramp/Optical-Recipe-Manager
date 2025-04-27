package dev.caloramp.buste.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.caloramp.buste.Models.Busta;
import dev.caloramp.buste.Repositories.BustaRepository;

@Service
public class BustaServiceImpl implements BustaService {
    // Iniettiamo il repository per accedere al database
    private final BustaRepository bustaRepository;


    // Costruttore per iniettare il repository
    public BustaServiceImpl(BustaRepository bustaRepository) {
        this.bustaRepository = bustaRepository;
    }

    // Implementazione del metodo per creare una busta
    @Override
    public Busta creaBusta(Busta busta) {
        return bustaRepository.save(busta);
    }

    @Override
    public List<Busta> mostraBuste() {
        return bustaRepository.findAll();
    }

    @Override
    public Busta cercaBustaPerId(Long id) {
        return bustaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Busta> cercaBustePerIdCliente(Long idCliente) {
        List<Busta> buste = bustaRepository.findByClienteId(idCliente);
        
        return buste;
    }
}
