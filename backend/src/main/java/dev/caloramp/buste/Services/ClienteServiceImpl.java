package dev.caloramp.buste.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.caloramp.buste.Models.Cliente;
import dev.caloramp.buste.Repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
    
        private final ClienteRepository clienteRepository;

        public ClienteServiceImpl(ClienteRepository clienteRepository) {
            this.clienteRepository = clienteRepository;
        }
        
        @Override
        public List<Cliente> cercaClientePerCognome(String cognome) {
            return clienteRepository.findByCognome(cognome);
        }

        @Override
        public Cliente cercaClientePerId(Long id) {
            return clienteRepository.findById(id).orElse(null);
        }
        
    
        @Override
        public Cliente creaCliente(Cliente cliente) {
            clienteRepository.save(cliente);
            return cliente;
        }
    
        @Override
        public Cliente modificaCliente(Long id, Cliente clienteModificato) {
            Cliente clienteEsistente = clienteRepository.findById(id).orElse(null);
            // Aggiorna gli attributi del cliente
            if (clienteModificato.getCognome() != null) {
                clienteEsistente.setCognome(clienteModificato.getCognome());
            }
            if (clienteModificato.getNome() != null) {
                clienteEsistente.setNome(clienteModificato.getNome());
            }
            if (clienteModificato.getNTelefono() != null) {
                clienteEsistente.setNTelefono(clienteModificato.getNTelefono());
            }

            if (clienteModificato.getIndirizzo() != null) {
                clienteEsistente.setIndirizzo(clienteModificato.getIndirizzo());
            }
            if (clienteModificato.getCitta() != null) {
                clienteEsistente.setCitta(clienteModificato.getCitta());
            }
            if (clienteModificato.getCf_pIva() != null) {
                clienteEsistente.setCf_pIva(clienteModificato.getCf_pIva());
            }

            // Salva il cliente aggiornato
            return clienteRepository.save(clienteEsistente);


        }
    
        @Override
        public Cliente eliminaCliente(Long id) {
            Cliente cliente = clienteRepository.findById(id).orElse(null);
            clienteRepository.deleteById(id);
            return cliente;
        }
    
        @Override
        public List<Cliente> mostraClienti() {
            return clienteRepository.findAll();
        }
}
