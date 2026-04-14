package cl.duoc.videogame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsolaDTO {
    private Long id;
    private String name;
    private Integer realeseYear;
    private CompaniaDTO compania;
}
