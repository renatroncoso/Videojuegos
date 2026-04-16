package cl.duoc.videogame.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.videogame.dto.VideogameDTO;
import cl.duoc.videogame.model.Consola;
import cl.duoc.videogame.model.Videogame;
import cl.duoc.videogame.repository.ConsolaRepository;
import cl.duoc.videogame.repository.VideogameRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VideogameService {
    private final VideogameRepository videogameRepository;
    private final ConsolaRepository consolaRepository;

    public VideogameService(VideogameRepository videogameRepository, ConsolaRepository consolaRepository) {
        this.videogameRepository = videogameRepository;
        this.consolaRepository = consolaRepository;
    }

        
    /**
     * Listar todos los videojuegos registrados.
     */
    public List<VideogameDTO> findAll() {
        return videogameRepository.findAll()
                .stream()
                .map(v -> new VideogameDTO(v.getId(), v.getNombreVideogame(), v.getGenre(),
                        v.getAnioSalida(), v.getDeveloper(), null))
                .collect(Collectors.toList());
    }
    
    /**
     * Crear un nuevo videojuego en la base de datos.
     */
    public VideogameDTO create(VideogameDTO videogameDTO) {
        Videogame videogame = new Videogame();
        videogame.setNombreVideogame(videogameDTO.getNombreVideogame());
        videogame.setGenre(videogameDTO.getGenre());
        videogame.setAnioSalida(videogameDTO.getAnioSalida());
        videogame.setDeveloper(videogameDTO.getDeveloper());

        if (videogameDTO.getConsolas() != null) {
            Set<Consola> consolas = videogameDTO.getConsolas().stream()
                    .map(c -> consolaRepository.findById(c.getId())
                            .orElseThrow(() -> new RuntimeException("Console not found")))
                    .collect(Collectors.toSet());

            videogame.setConsolas(consolas);
        }

        videogame = videogameRepository.save(videogame);
        videogameDTO.setId(videogame.getId());
        return videogameDTO;
    }
}
