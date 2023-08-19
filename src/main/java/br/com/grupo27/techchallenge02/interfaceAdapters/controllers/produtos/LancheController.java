package br.com.grupo27.techchallenge02.interfaceAdapters.controllers.produtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.grupo27.techchallenge02.application.dto.LancheDTO;
import br.com.grupo27.techchallenge02.interfaceAdapters.interfaces.usecase.LancheService;

import java.util.List;

@RestController
@RequestMapping("api/produtos/lanche")
public class LancheController {

    private final LancheService lancheService;

    public LancheController(LancheService lancheService) {
        this.lancheService = lancheService;
    }

    @PostMapping
    public ResponseEntity<LancheDTO> createLanche(@RequestBody LancheDTO lancheDTO) {
        LancheDTO createdLanche = lancheService.createLanche(lancheDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLanche);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancheDTO> updateLanche(@PathVariable Long id, @RequestBody LancheDTO lancheDTO) {
        try {
            LancheDTO updatedLanche = lancheService.updateLanche(id, lancheDTO);
            if (updatedLanche != null) {
                return ResponseEntity.ok(updatedLanche);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancheDTO> getLancheById(@PathVariable Long id) {
        try {
            LancheDTO lanche = lancheService.getLancheById(id);
            if (lanche != null) {
                return ResponseEntity.ok(lanche);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanche(@PathVariable Long id) {
        try {
            boolean deleted = lancheService.deleteLanche(id);
            if (deleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<LancheDTO>> getAllLanches() {
        List<LancheDTO> lanches = lancheService.getAllLanches();
        return ResponseEntity.ok(lanches);
    }
}
