package com.lewandowski.actorsdatabaseproject.repository;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RankingRepo extends Repository<Ranking, Long> {

    void save(Ranking ranking);
    List<Ranking> findAll();
    Ranking findById(Integer id);
    void deleteById(Integer id);
    @Query(value="SELECT * FROM ranking R JOIN Actor A ON R.id=A.id_ranking WHERE A.firstName = ?1 AND R.id = ?2",nativeQuery = true )
    Integer selectActorsWithSelectedRankingAndFirstName(String firstName, Integer position);
}
