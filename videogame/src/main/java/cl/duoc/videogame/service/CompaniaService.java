package cl.duoc.videogame.service;

import java.util.List;
import java.util.stream.Collectors;
import cl.duoc.videogame.dto.CompaniaDTO;
import cl.duoc.videogame.repository.CompaniaRepository;

public class CompaniaService {
    private CompaniaRepository companiaRepository;

    public CompaniaService(CompaniaRepository companiaRepository){
        this.companiaRepository=companiaRepository;
    }
    
    public List<CompaniaDTO> FindAll(){
        return companiaRepository.findAll()
            .stream()
            .map(c -> new CompaniaDTO(c.getId(),c.getNombreCompania(),c.getCountry()))
            .collect(Collectors.toList());
    }
    
}
