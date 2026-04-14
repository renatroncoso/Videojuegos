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
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombreCompania;

    @Column(nullable = false)
    private String country;


    @Builder.Default
    @OneToMany(mappedBy = "compania")
    private Set<Consola> consolas= new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Compania)) return false;

        Compania other = (Compania) o;
        return id != null && id.equals(other.getId());
    }


    @Override
    public int hashCode(){
        return 31;
    }
}
