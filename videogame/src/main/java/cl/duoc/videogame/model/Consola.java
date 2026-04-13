package cl.duoc.videogame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="consola")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consola {
    private Long idConsola;
}
