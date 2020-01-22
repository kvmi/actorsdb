package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.repository.ActorRepo;
import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepo actorRepo;

    @Autowired
    public ActorServiceImpl(ActorRepo actorRepo) { this.actorRepo = actorRepo; }

    @Override
    public void addAll(List<Actor> actors){
        for ( Actor a : actors)
            actorRepo.save(a);
    }
    @Override
    public void add(Actor actor) { actorRepo.save(actor); }
    @Override
    public void update(Actor actor, Integer id){
        Actor actorUpdate = actorRepo.findById(id);
        actorUpdate.setFirstName(actor.getFirstName());
        actorUpdate.setLastName(actor.getLastName());
        actorUpdate.setRanking(actor.getRanking());
        actorUpdate.setMovieCategory(actor.getMovieCategory());
        actorUpdate.setMoviesPlayed(actor.getMoviesPlayed());
        actorUpdate.setOscarAcquired(actor.getOscarAcquired());
        actorUpdate.setBirthYear(actor.getBirthYear());
    }
    @Override
    public void delete(Integer id) { actorRepo.deleteById(id);}
    @Override
    public Actor findById(Integer id) { return actorRepo.findById(id);}
    @Override
    public List<Actor> findAll() { return actorRepo.findAll();}
    @Override
    public List<Actor> findAllByRanking(Ranking ranking) { return actorRepo.findAllByRanking(ranking); }
    @Override
    public List<Actor> findAllByMovieCategory(MovieCategory movieCategory) { return actorRepo.findAllByMovieCategory(movieCategory); }
    @Override
    public List<Actor> findAllActorsWithOscarAcquiredGreaterThan(Short oscarAcquired){
        return actorRepo.findAllActorsWithOscarAcquiredGreaterThan(oscarAcquired);
    }
    @Override
    public List<Actor> findAllActorsWithMoreMoviesPlayedThan(int moviesPlayed){
        return actorRepo.findAllActorsWithMoreMoviesPlayedThan(moviesPlayed);
    }
    @Override
    public List<Actor> findAllByFirstNameAndOscarAcquiredMoreThanAndMoviesPlayedLessThan(String firstName, short oscarAcquired, int moviesPlayed){
        return actorRepo.findAllByFirstNameAndOscarAcquiredGreaterThanAndMoviesPlayedLessThan(firstName, oscarAcquired, moviesPlayed);
    }
    @Override
    public Actor findTopByOrderByOscarAcquiredDesc() { return actorRepo.findTopByOrderByOscarAcquiredDesc(); }


}
