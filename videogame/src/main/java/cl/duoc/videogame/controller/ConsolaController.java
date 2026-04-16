package cl.duoc.videogame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.videogame.dto.ConsolaDTO;
import cl.duoc.videogame.service.ConsolaService;

@RestController
@RequestMapping("api/v1/console")
public class ConsolaController {
    private final ConsolaService consolaService;

    public ConsolaController(ConsolaService consolaService) {
        this.consolaService = consolaService;
    }

    @GetMapping
        public ResponseEntity<List<ConsolaDTO>> findAll() {
        return ResponseEntity.ok(consolaService.findAll());
    }

    @PostMapping
    public ResponseEntity<ConsolaDTO> create(@RequestBody ConsolaDTO consolaDTO) {
        return ResponseEntity.ok(consolaService.create(consolaDTO));
    }
}
