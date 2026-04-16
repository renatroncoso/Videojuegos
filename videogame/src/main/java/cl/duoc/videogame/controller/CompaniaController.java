package cl.duoc.videogame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.videogame.dto.CompaniaDTO;
import cl.duoc.videogame.service.CompaniaService;

@RestController
@RequestMapping("api/v1/compania")
public class CompaniaController {
    private final CompaniaService companiaService;
    
    public CompaniaController(CompaniaService companiaService) {
        this.companiaService = companiaService;
    }
    @PostMapping
    public ResponseEntity<CompaniaDTO> create(@RequestBody CompaniaDTO companiaDTO) {
        return ResponseEntity.ok(companiaService.create(companiaDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompaniaDTO>> findAll() {
        return ResponseEntity.ok(companiaService.findAll());
    }
}
