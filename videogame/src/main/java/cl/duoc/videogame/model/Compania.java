package cl.duoc.videogame.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="companias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compania {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompania;

    @Column(unique = true, nullable = false)
    private String nombreCompania;

    @Column(nullable = false)
    private String country;

    @OneToMany(mappedBy = "compania")
    private Set<Consola> consolas= new HashSet<>();
}
