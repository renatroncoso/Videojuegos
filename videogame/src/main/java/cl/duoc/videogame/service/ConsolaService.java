package cl.duoc.videogame.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.videogame.dto.ConsolaDTO;
import cl.duoc.videogame.model.Compania;
import cl.duoc.videogame.model.Consola;
import cl.duoc.videogame.repository.CompaniaRepository;
import cl.duoc.videogame.repository.ConsolaRepository;

@Service
public class ConsolaService {
    private final ConsolaRepository consolaRepository;
    private final CompaniaRepository companiaRepository;

    public ConsolaService(ConsolaRepository consolaRepository, CompaniaRepository companiaRepository) {
        this.consolaRepository = consolaRepository;
        this.companiaRepository = companiaRepository;
    }

    /**
     * Listar todas las consolas registradas.
     */
    public List<ConsolaDTO> findAll() {
        return consolaRepository.findAll()
                .stream()
                .map(c -> new ConsolaDTO(c.getId(), c.getNombreConsola(), c.getAnioSalida(), null))
                .collect(Collectors.toList());
    }
    
    /**
     * Crear una nueva consola en la base de datos.
     */
    public ConsolaDTO create(ConsolaDTO consolaDTO) {
        Consola consola = new Consola();
        consola.setNombreConsola(consolaDTO.getName());
        consola.setAnioSalida(consolaDTO.getRealeseYear());

        // Buscar la compañía por ID y asignarla
        if (consolaDTO.getCompania() != null && consolaDTO.getCompania().getId() != null) {
            Compania companie = companiaRepository.findById(consolaDTO.getCompania().getId())
                    .orElseThrow(() -> new RuntimeException("Companie not found"));
            consola.setCompania(companie);
        } else {
            throw new RuntimeException("Companie ID is required");
        }

        consola = consolaRepository.save(consola);
        consolaDTO.setId(consola.getId());
        return consolaDTO;
    }
}
