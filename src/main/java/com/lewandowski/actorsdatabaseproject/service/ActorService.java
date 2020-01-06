package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import com.lewandowski.actorsdatabaseproject.model.Ranking;

import java.util.List;

public interface ActorService {
    void addAll(List<Actor> actors);

    void add(Actor actor);

    void update (Actor actor, Integer id);

    void delete (Integer id);

    List<Actor> findAll();

    Actor findById(Integer id);

    List<Actor> findAllByRanking(Ranking ranking);

    List<Actor> findAllByMovieCategory(MovieCategory movieCategory);

    List<Actor> findAllActorsWithOscarAcquiredGreaterThan(Double oscarAcquired);

    List<Actor> findAllActorsWithMoreMoviesPlayedThan(Integer moviesPlayed);

    List<Actor> findAllByFirstNameAndOscarAcquiredMoreThanAndMoviesPlayedLessThan(String firstName, short oscarAcquired, int moviesPlayed);

    Actor findTopByOrderByOscarAcquiredDesc();
}
