package com.lewandowski.actorsdatabaseproject;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import com.lewandowski.actorsdatabaseproject.model.Ranking;
import com.lewandowski.actorsdatabaseproject.service.ActorService;
import com.lewandowski.actorsdatabaseproject.service.MovieCategoryService;
import com.lewandowski.actorsdatabaseproject.service.RankingService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ComponentScan("com.lewandowski.actorsdatabaseproject.service")
@DataJpaTest
class MovieCategoryRepoTest {

    private ActorService as;
    private MovieCategoryService mcs;
    private RankingService rs;

    @Autowired
    public MovieCategoryRepoTest(ActorService as, MovieCategoryService mcs, RankingService rs) {
        this.as = as;
        this.mcs = mcs;
        this.rs = rs;
    }

    @BeforeEach
    void setUp() {
        Ranking ranking = new Ranking(1);
        Ranking ranking2 = new Ranking(2);
        Ranking ranking3 = new Ranking(3);
        Actor actor = new Actor("Mariusz","Lewandowski",20.0,(short) 3,1988);
        Actor actor2 = new Actor("Dariusz","Zapałka",15.0,(short) 3,1984);
        Actor actor3 = new Actor("Michał","Dręczałka",23.0,(short) 3,1983);
        Actor actor4 = new Actor("Michał","Żebrowski",80.0,(short) 3,1970);
        MovieCategory movieCategory = new MovieCategory("comedy");
        MovieCategory movieCategory2 = new MovieCategory("horror");
        MovieCategory movieCategory3 = new MovieCategory("thriller");
        actor.setRanking(ranking);
        actor2.setRanking(ranking);
        actor3.setRanking(ranking2);
        actor4.setRanking(ranking3);
        actor.setMovieCategory(movieCategory);
        actor.setMovieCategory(movieCategory);
        actor.setMovieCategory(movieCategory2);
        actor.setMovieCategory(movieCategory3);
        as.add(actor);
        as.add(actor2);
        as.add(actor3);
        as.add(actor4);
        mcs.add(movieCategory);
        mcs.add(movieCategory2);
        mcs.add(movieCategory3);
        rs.add(ranking);
        rs.add(ranking2);
        rs.add(ranking3);
    }

    @Test
    void contextLoads() {

    }

    @Test
    void testDeleteMovieCategory(){
        MovieCategory movieCategory1 = new MovieCategory("comedy");
        mcs.add(movieCategory1);
        Assert.assertNotNull(mcs.findById(movieCategory1.getId()));
        mcs.delete(movieCategory1.getId());
        Assert.assertNull(mcs.findById(movieCategory1.getId()));
    }
    @Test
    void testUpdateMovieCategory(){
        MovieCategory movieCategory1 = new MovieCategory("horror");
        mcs.add(movieCategory1);
        MovieCategory movieCategory2 = new MovieCategory("thriller");
        mcs.update(movieCategory2,movieCategory1.getId());
        Assert.assertEquals(mcs.findById(movieCategory1.getId()).getName(),"horror");
    }
    @Test
    void testSaveMovieCategory(){
        MovieCategory movieCategory1 = new MovieCategory("horror");
        mcs.add(movieCategory1);
        Assert.assertNotNull(mcs.findById(movieCategory1.getId()));
    }

}
