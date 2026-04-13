package cl.duoc.videogame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="videogames")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Videogame {
    private Long idVideogame;
}
