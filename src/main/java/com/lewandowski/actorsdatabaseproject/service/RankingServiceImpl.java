package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.controller.RankingRepo;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {
    private RankingRepo rankingRepo;

    @Autowired public RankingServiceImpl(RankingRepo rankingRepo) { this.rankingRepo = rankingRepo; }

    @Override
    public void addAll(List<Ranking> rankings) {
        for (Ranking r : rankings)
            rankingRepo.save(r);
    }

    @Override
    public void add(Ranking ranking) { rankingRepo.save(ranking); }

    @Override
    public void delete(Integer id) { rankingRepo.deleteById(id); }

    @Override
    public void update(Ranking ranking, Integer id) {
        Ranking rankingUp = rankingRepo.findById(id);
        rankingUp.setPosition(ranking.getPosition());
        rankingUp.setActors(ranking.getActors());
        rankingRepo.save(rankingUp);
    }

    @Override
    public Ranking findById(Integer Id) { return rankingRepo.findById(Id);}

    @Override
    public List<Ranking> findAll() { return rankingRepo.findAll();}

    @Override
    public Integer selectActorsWithSelectedRankingAndFirstName(String firstName, Ranking ranking) {
        return rankingRepo.selectActorsWithSelectedRankingAndFirstName(firstName, ranking.getPosition());
    }
}
