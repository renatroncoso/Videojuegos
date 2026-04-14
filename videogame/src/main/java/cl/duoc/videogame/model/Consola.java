package cl.duoc.videogame.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="consolas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consola {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombreConsola;

    @Column(nullable = false)
    private Integer anioSalida;

    @ManyToOne
    @JoinColumn(name = "campania_fk",nullable = false)
    private Compania compania;

    @Builder.Default
    @ManyToMany(mappedBy = "consolas")
    private Set<Videogame> videogames = new HashSet<>();

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Consola)) return false;

        Consola other = (Consola) o;
        return id != null && id.equals(other.getId());
    }


    @Override
    public int hashCode(){
        return 31;
    }
}
