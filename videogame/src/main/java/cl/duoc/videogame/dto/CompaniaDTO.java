package cl.duoc.videogame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompaniaDTO {
    private Long id;
    private String nombreCompania;
    private String country;
}
