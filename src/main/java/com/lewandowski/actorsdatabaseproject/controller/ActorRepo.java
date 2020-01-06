package com.lewandowski.actorsdatabaseproject.controller;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ActorRepo extends Repository<Actor, Integer> {
    void save(Actor actor);
    List<Actor> findAll();
    Actor findById(Integer id);
    void deleteById(Integer id);
    List<Actor> findAllByRanking(Ranking ranking);
    List<Actor> findAllByMovieCategory(MovieCategory movieCategory);
    @Query(value="SELECT * FROM ACTOR WHERE OSCAR_ACQUIRED > ?2", nativeQuery = true)
    List<Actor> findAllActorsWithOscarAcquiredGreaterThan(Double oscarAcquired);
    @Query(value="SELECT * FROM ACTOR WHERE MOVIES_PLAYED > ?1", nativeQuery = true)
    List<Actor> findAllActorsWithMoreMoviesPlayedThan(Integer moviesPlayed);
    List<Actor> findAllByFirstNameAndOscarAcquiredMoreThanAndMoviesPlayedLessThan(String firstName, short oscardAcquired, int moviesPlayed);
    Actor findTopByOrderByOscarAcquiredDesc();
    @Query(value="SELECT * FROM ACTOR WHERE id_movieCategory = ?1", nativeQuery = true)
    List<Actor> findAllActorsFromMovieCategory(Integer movieCategoryId);
}
