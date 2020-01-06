package com.lewandowski.actorsdatabaseproject.repository;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RankingRepo extends Repository<Actor, Long> {

    void save(Ranking ranking);
    List<Ranking> findAll();
    Ranking findById(Integer id);
    Ranking deleteById(Integer id);
    @Query(value="SELECT * FROM RANKING R JOIN Actor A ON R.id=A.id_ranking WHERE A.firstName = ?2 AND R.pozycja > ?1",nativeQuery = true )
    Integer selectActorsWithSelectedRankingAndFirstName(String firstName, Integer position);
}
