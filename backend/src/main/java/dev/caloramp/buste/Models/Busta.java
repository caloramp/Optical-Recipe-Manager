package dev.caloramp.buste.Models;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "buste")
public class Busta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    //Data
    private Date data;

    //Lontano
    private float odSfLontano;
    private float odCilLontano;
    private int odAxLontano;

    private float osSfLontano;
    private float osCilLontano;
    private int osAxLontano;

    //Medio
    private float odSfMedio;
    private float odCilMedio;
    private int odAxMedio;

    private float osSfMedio;
    private float osCilMedio;
    private int osAxMedio;

    //Vicino
    private float odSfVicino;
    private float odCilVicino;
    private int odAxVicino;

    private float osSfVicino;
    private float osCilVicino;
    private int osAxVicino;

    private boolean tabo;

    private float distanzaInterpupillare;

    //Montatura
    private String marcaMontatura;
    private String modelloMontatura;
    private int calibroMontatura;
    private int ponte;

    //Lenti
    private String marcaLente;
    private String modelloLente;
    private String materialeLente;
    private float indiceLente;
    private int diametroLente;
    private String trattamentoLente;
    private String colorazioneLente;
    private boolean isAntiriflesso;
    
    //Prezzi
    private float prezzoMontatura;
    private float prezzoLenti;
    private float prezzoTotale;

    public boolean isAntiriflesso() {
        return isAntiriflesso;
    }
    public void setAntiriflesso(boolean isAntiriflesso) {
        this.isAntiriflesso = isAntiriflesso;
    }

    public boolean isTabo() {
        return tabo;
    }
    public void setTabo(boolean tabo) {
        this.tabo = tabo;
    }
}
