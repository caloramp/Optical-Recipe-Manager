package dev.caloramp.buste.Controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.caloramp.buste.DTOs.BustaRequest;
import dev.caloramp.buste.Models.Busta;
import dev.caloramp.buste.Models.Cliente;
import dev.caloramp.buste.Services.BustaService;
import dev.caloramp.buste.Services.ClienteService;

@RestController
@RequestMapping("/api")
public class BusteController {
    @Autowired
    private BustaService bustaService;
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/nuovaBusta")
    public ResponseEntity<Object> creaBusta(@RequestBody BustaRequest bustaRequest) {
        //Recupera il cliente dal database
        Cliente cliente = clienteService.cercaClientePerId(bustaRequest.getIdCliente());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("Cliente non valido!");
        }

        // Crea una nuova busta
        Busta busta = new Busta();
        busta.setCliente(cliente);
        busta.setData(bustaRequest.getData());
        busta.setOdSfLontano(bustaRequest.getOdSfLontano() != null ? bustaRequest.getOdSfLontano() : 0.0f);
        busta.setOdCilLontano(bustaRequest.getOdCilLontano() != null ? bustaRequest.getOdCilLontano() : 0.0f);
        busta.setOdAxLontano(bustaRequest.getOdAxLontano());
        busta.setOsSfLontano(bustaRequest.getOsSfLontano() != null ? bustaRequest.getOsSfLontano() : 0.0f);
        busta.setOsCilLontano(bustaRequest.getOsCilLontano() != null ? bustaRequest.getOsCilLontano() : 0.0f);
        busta.setOsAxLontano(bustaRequest.getOsAxLontano());
        busta.setOdSfMedio(bustaRequest.getOdSfMedio() != null ? bustaRequest.getOdSfMedio() : 0.0f);
        busta.setOdCilMedio(bustaRequest.getOdCilMedio() != null ? bustaRequest.getOdCilMedio() : 0.0f);
        busta.setOdAxMedio(bustaRequest.getOdAxMedio());
        busta.setOsSfMedio(bustaRequest.getOsSfMedio() != null ? bustaRequest.getOsSfMedio() : 0.0f);
        busta.setOsCilMedio(bustaRequest.getOsCilMedio() != null ? bustaRequest.getOsCilMedio() : 0.0f);
        busta.setOsAxMedio(bustaRequest.getOsAxMedio());
        busta.setOdSfVicino(bustaRequest.getOdSfVicino() != null ? bustaRequest.getOdSfVicino() : 0.0f);
        busta.setOdCilVicino(bustaRequest.getOdCilVicino() != null ? bustaRequest.getOdCilVicino() : 0.0f);
        busta.setOdAxVicino(bustaRequest.getOdAxVicino());
        busta.setOsSfVicino(bustaRequest.getOsSfVicino() != null ? bustaRequest.getOsSfVicino() : 0.0f);
        busta.setOsCilVicino(bustaRequest.getOsCilVicino() != null ? bustaRequest.getOsCilVicino() : 0.0f);
        busta.setOsAxVicino(bustaRequest.getOsAxVicino());
        busta.setTabo(bustaRequest.isTabo());
        busta.setDistanzaInterpupillare(bustaRequest.getDistanzaInterpupillare());
        busta.setMarcaMontatura(bustaRequest.getMarcaMontatura());
        busta.setModelloMontatura(bustaRequest.getModelloMontatura());
        busta.setCalibroMontatura(bustaRequest.getCalibroMontatura());
        busta.setPonte(bustaRequest.getPonte());
        busta.setMarcaLente(bustaRequest.getMarcaLente());
        busta.setModelloLente(bustaRequest.getModelloLente());
        busta.setMaterialeLente(bustaRequest.getMaterialeLente());
        busta.setIndiceLente(bustaRequest.getIndiceLente());
        busta.setDiametroLente(bustaRequest.getDiametroLente());
        busta.setTrattamentoLente(bustaRequest.getTrattamentoLente());
        busta.setColorazioneLente(bustaRequest.getColorazioneLente());
        busta.setAntiriflesso(bustaRequest.isAntiriflesso());

        busta.setPrezzoMontatura(bustaRequest.getPrezzoMontatura());
        busta.setPrezzoLenti(bustaRequest.getPrezzoLenti());
        busta.setPrezzoTotale(bustaRequest.getPrezzoMontatura() + bustaRequest.getPrezzoLenti());

        // Salva la busta
        bustaService.creaBusta(busta);
        return ResponseEntity.ok(Map.of("message", "Busta creata con successo!"));
    }

    @GetMapping("/buste")
    public ResponseEntity<Object> mostraBuste() {
        return ResponseEntity.ok(bustaService.mostraBuste());
    }

    @PostMapping("/modificaBusta")
    public ResponseEntity<Object> modificaBusta(@RequestBody BustaRequest bustaRequest) {
        // Recupera la busta dal database
        Busta busta = bustaService.cercaBustaPerId(bustaRequest.getId());
        if (busta == null) {
            return ResponseEntity.badRequest().body("Busta non valida!");
        }
        Cliente cliente = clienteService.cercaClientePerId(bustaRequest.getIdCliente());

        busta.setCliente(cliente);
        busta.setOdSfLontano(bustaRequest.getOdSfLontano());
        busta.setOdCilLontano(bustaRequest.getOdCilLontano());
        busta.setOdAxLontano(bustaRequest.getOdAxLontano());
        busta.setOsSfLontano(bustaRequest.getOsSfLontano());
        busta.setOsCilLontano(bustaRequest.getOsCilLontano());
        busta.setOsAxLontano(bustaRequest.getOsAxLontano());
        busta.setOdSfMedio(bustaRequest.getOdSfMedio());
        busta.setOdCilMedio(bustaRequest.getOdCilMedio());
        busta.setOdAxMedio(bustaRequest.getOdAxMedio());
        busta.setOsSfMedio(bustaRequest.getOsSfMedio());
        busta.setOsCilMedio(bustaRequest.getOsCilMedio());
        busta.setOsAxMedio(bustaRequest.getOsAxMedio());
        busta.setOdSfVicino(bustaRequest.getOdSfVicino());
        busta.setOdCilVicino(bustaRequest.getOdCilVicino());
        busta.setOdAxVicino(bustaRequest.getOdAxVicino());
        busta.setOsSfVicino(bustaRequest.getOsSfVicino());
        busta.setOsCilVicino(bustaRequest.getOsCilVicino());
        busta.setOsAxVicino(bustaRequest.getOsAxVicino());
        busta.setTabo(bustaRequest.isTabo());
        busta.setDistanzaInterpupillare(bustaRequest.getDistanzaInterpupillare());
        busta.setMarcaMontatura(bustaRequest.getMarcaMontatura());
        busta.setModelloMontatura(bustaRequest.getModelloMontatura());
        busta.setCalibroMontatura(bustaRequest.getCalibroMontatura());
        busta.setPonte(bustaRequest.getPonte());
        busta.setMarcaLente(bustaRequest.getMarcaLente());
        busta.setModelloLente(bustaRequest.getModelloLente());
        busta.setMaterialeLente(bustaRequest.getMaterialeLente());
        busta.setIndiceLente(bustaRequest.getIndiceLente());
        busta.setDiametroLente(bustaRequest.getDiametroLente());
        busta.setTrattamentoLente(bustaRequest.getTrattamentoLente());
        busta.setColorazioneLente(bustaRequest.getColorazioneLente());
        busta.setAntiriflesso(bustaRequest.isAntiriflesso());

        busta.setPrezzoMontatura(bustaRequest.getPrezzoMontatura());
        busta.setPrezzoLenti(bustaRequest.getPrezzoLenti());
        busta.setPrezzoTotale(bustaRequest.getPrezzoMontatura() + bustaRequest.getPrezzoLenti());

        // Salva la busta
        bustaService.creaBusta(busta);
        return ResponseEntity.ok("Busta aggiornata con successo!");
    }

    @GetMapping("/busta/{id_cliente}")
    public ResponseEntity<Object> mostraBustePerCliente(@PathVariable Long id_cliente) {
        return ResponseEntity.ok(bustaService.cercaBustePerIdCliente(id_cliente));
    }

    @PostMapping("/buste/{id}")
    public ResponseEntity<Object> mostraBustaPerId(@RequestBody Long id) {
        return ResponseEntity.ok(bustaService.cercaBustaPerId(id));
    }
}

