package cl.duoc.videogame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.videogame.dto.VideogameDTO;
import cl.duoc.videogame.service.VideogameService;

@RestController
@RequestMapping("api/v1/videogame")
public class VideogameController {
    private final VideogameService videogameService;

    public VideogameController(VideogameService videogameService) {
        this.videogameService = videogameService;
    }
    
    @GetMapping
    public ResponseEntity<List<VideogameDTO>> findAll() {
        return ResponseEntity.ok(videogameService.findAll());
    }

    @PostMapping
    public ResponseEntity<VideogameDTO> create(@RequestBody VideogameDTO videogameDTO) {
        return ResponseEntity.ok(videogameService.create(videogameDTO));
    }
}
