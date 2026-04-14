package cl.duoc.videogame.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="videogames")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Videogame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombreVideogame;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private Integer anioSalida;

    @Column(nullable = false)
    private String developer;

    @Builder.Default
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "videogame_consola",
        joinColumns = @JoinColumn(name="videogame_id"),
        inverseJoinColumns = @JoinColumn(name="consola_id")
    )
    private Set<Consola> consolas= new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Videogame)) return false;

        Videogame other = (Videogame) o;
        return id != null && id.equals(other.getId());
    }


    @Override
    public int hashCode(){
        return 31;
    }
}
