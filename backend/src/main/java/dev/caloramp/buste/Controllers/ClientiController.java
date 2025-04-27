package dev.caloramp.buste.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.caloramp.buste.Models.Cliente;
import dev.caloramp.buste.Services.ClienteService;

@RestController
@RequestMapping("/api")
public class ClientiController {
    @Autowired
    ClienteService clienteService;


    @GetMapping("/clienti")
    public ResponseEntity<Object> mostraClienti() {
        return ResponseEntity.ok(clienteService.mostraClienti());
    }

    @PostMapping("/aggiungiCliente")
    public ResponseEntity<Cliente> aggiungiCliente(@RequestBody Cliente cliente) {
        
        if(cliente.getCognome() == null || cliente.getCognome().isEmpty() || cliente.getNome() == null || cliente.getNome().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Cliente newCliente = new Cliente();
        newCliente.setCognome(cliente.getCognome());
        newCliente.setNome(cliente.getNome());
        newCliente.setNTelefono(cliente.getNTelefono());
        newCliente.setIndirizzo(cliente.getIndirizzo());
        newCliente.setCitta(cliente.getCitta());
        newCliente.setCf_pIva(cliente.getCf_pIva());
        clienteService.creaCliente(cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    
    }

    @GetMapping("/cercaCliente")
    public ResponseEntity<Object> cercaCliente(@RequestParam String cognome) {
        List<Cliente> clienti = clienteService.cercaClientePerCognome(cognome);
        if (clienti.isEmpty()) {
            return new ResponseEntity<>("Nessun cliente trovato con il cognome: " + cognome, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(clienti);
    }

    @GetMapping("/clienti/{id}")
    public ResponseEntity<Object> cercaClientePerId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.cercaClientePerId(id);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/modificaCliente/{id}")
    public ResponseEntity<Object> modificaCliente(@PathVariable Long id, @RequestBody Cliente clienteModificato) {
        try {
            Cliente clienteAggiornato = clienteService.modificaCliente(id, clienteModificato);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
