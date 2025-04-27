package dev.caloramp.buste.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "clienti")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private String nome;

    private String nTelefono;

    private String indirizzo;

    private String citta;

    private String cf_pIva;

    public Cliente(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
    }

}
