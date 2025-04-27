package dev.caloramp.buste.DTOs;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BustaRequest {
    private Long id;
    private Long idCliente;
    private Date data;
    private Float odSfLontano = 0.0f;
    private Float odCilLontano = 0.0f;
    private Integer odAxLontano = 0;
    private Float osSfLontano = 0.0f;
    private Float osCilLontano = 0.0f;
    private Integer osAxLontano = 0;
    private Float odSfMedio = 0.0f;
    private Float odCilMedio = 0.0f;
    private Integer odAxMedio = 0;
    private Float osSfMedio = 0.0f;
    private Float osCilMedio = 0.0f;
    private Integer osAxMedio = 0;
    private Float odSfVicino = 0.0f;
    private Float odCilVicino = 0.0f;
    private Integer odAxVicino = 0;
    private Float osSfVicino = 0.0f;
    private Float osCilVicino = 0.0f;
    private Integer osAxVicino = 0;
    private boolean tabo = false;
    private Float distanzaInterpupillare = 0.0f;
    private String marcaMontatura;
    private String modelloMontatura;
    private Integer calibroMontatura = 0;
    private Integer ponte = 0;
    private String marcaLente = "";
    private String modelloLente = "";
    private String materialeLente = "";
    private Float indiceLente = 0.0f;
    private Integer diametroLente = 0;
    private String trattamentoLente = "";
    private String colorazioneLente = "";
    private Boolean isAntiriflesso = false;

    private Float prezzoMontatura = 0.0f;
    private Float prezzoLenti = 0.0f;
    private Float prezzoTotale = this.prezzoMontatura + this.prezzoLenti;

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