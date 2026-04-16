package cl.duoc.videogame.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.duoc.videogame.dto.CompaniaDTO;
import cl.duoc.videogame.model.Compania;
import cl.duoc.videogame.repository.CompaniaRepository;

@Service
public class CompaniaService {
    private final CompaniaRepository companiaRepository;

    public CompaniaService(CompaniaRepository companiaRepository) {
        this.companiaRepository = companiaRepository;
    }

    /**
     * Listar todas las compañías registradas.
     */
    public List<CompaniaDTO> findAll() {
        return companiaRepository.findAll()
                .stream()
                .map(c -> new CompaniaDTO(c.getId(), c.getNombreCompania(), c.getCountry()))
                .collect(Collectors.toList());        
    }
    
    /**
     * Crear una nueva compañía en la base de datos.
     */
    public CompaniaDTO create(CompaniaDTO companiaDTO) {
        Compania compania = new Compania();
        compania.setNombreCompania(companiaDTO.getNombreCompania());
        compania.setCountry(companiaDTO.getCountry());
        compania = companiaRepository.save(compania);
        companiaDTO.setId(compania.getId());
        return companiaDTO;
    }
    
    public CompaniaDTO findById(Long id){
        Compania compania = companiaRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("compania no encontrada"));
        return new CompaniaDTO(compania.getId(),compania.getNombreCompania(),compania.getCountry());
    }
    
    public boolean deleteCompania(Long id){
        if(companiaRepository.existsById(id)){
            companiaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
