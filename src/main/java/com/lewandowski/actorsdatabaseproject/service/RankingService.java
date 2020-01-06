package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.model.Ranking;

import java.util.List;

public interface RankingService {
    void addAll(List<Ranking> rankings);

    void add(Ranking ranking);

    void delete(Integer id);

    void update(Ranking ranking, Integer id);

    Ranking findById(Integer id);

    List<Ranking> findAll();

    Integer selectActorsWithSelectedRankingAndFirstName(String firstName, Ranking ranking);
}
