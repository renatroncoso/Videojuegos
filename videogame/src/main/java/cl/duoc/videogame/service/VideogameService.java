package cl.duoc.videogame.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.videogame.dto.VideogameDTO;
import cl.duoc.videogame.model.Videogame;
import cl.duoc.videogame.repository.VideogameRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VideogameService {
    @Autowired
    private VideogameRepository videogameRepository;

    public VideogameService(VideogameRepository videogameRepository){
        this.videogameRepository=videogameRepository;
    }
    public List<VideogameDTO> GetAllVideogameDTOs(){
        return videogameRepository.findAll()
            .stream()
            .map(c -> new VideogameDTO(c.getId(),c.getNombreVideogame(),c.getGenre(), c.getAnioSalida(), c.getDeveloper(),c.getConsolas()))
            .collect(Collectors.toList())
    }
}
