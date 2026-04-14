package cl.duoc.videogame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.videogame.model.Videogame;

public interface VideogameRepository extends JpaRepository<Videogame ,Long>{

}
