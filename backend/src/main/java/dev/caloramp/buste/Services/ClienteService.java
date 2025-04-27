package dev.caloramp.buste.Services;

import java.util.List;

import dev.caloramp.buste.Models.Cliente;

public interface ClienteService {
    public Cliente cercaClientePerId(Long id);
    public List<Cliente> cercaClientePerCognome(String cognome);
    public Cliente creaCliente(Cliente cliente);
    public Cliente modificaCliente(Long id, Cliente clienteModificato);
    public Cliente eliminaCliente(Long id);


    public List<Cliente> mostraClienti();
}
