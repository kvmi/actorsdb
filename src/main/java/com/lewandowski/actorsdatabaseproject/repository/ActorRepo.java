package com.lewandowski.actorsdatabaseproject.repository;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;
public interface ActorRepo extends Repository<Actor, Integer> {
    void save(Actor actor);
    List<Actor> findAll();
    Actor findById(Integer id);
    void deleteById(Integer id);
    List<Actor> findAllByRanking(Ranking ranking);
    List<Actor> findAllByMovieCategory(MovieCategory movieCategory);
    @Query(value="SELECT * FROM ACTOR WHERE OSCAR_ACQUIRED > ?1", nativeQuery = true)
    List<Actor> findAllActorsWithOscarAcquiredGreaterThan(Short oscarAcquired);
    @Query(value="SELECT * FROM ACTOR WHERE MOVIES_PLAYED > ?1", nativeQuery = true)
    List<Actor> findAllActorsWithMoreMoviesPlayedThan(Double moviesPlayed);
    List<Actor> findAllByFirstNameAndOscarAcquiredGreaterThanAndMoviesPlayedLessThan(String firstName, short oscarAcquired, int moviesPlayed);
    Actor findTopByOrderByOscarAcquiredDesc();
    @Query(value="SELECT * FROM ACTOR WHERE id_movieCategory = ?1", nativeQuery = true)
    List<Actor> findAllActorsFromMovieCategory(Integer movieCategoryId);
}
