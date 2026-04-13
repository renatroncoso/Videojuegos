package cl.duoc.videogame.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="compania")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compania {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompania;

    @Column(unique = true, nullable = false)
    private String nombreCompania;
}
