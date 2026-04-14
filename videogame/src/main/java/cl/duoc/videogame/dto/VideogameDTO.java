package cl.duoc.videogame.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideogameDTO {
    private Long id;
    private String nombreVideogame;
    private String genre;
    private Integer anioSalida;
    private String developer;
    private List<ConsolaDTO> consolas;
}
