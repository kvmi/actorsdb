package com.lewandowski.actorsdatabaseproject;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.service.ActorService;
import com.lewandowski.actorsdatabaseproject.service.MovieCategoryService;
import com.lewandowski.actorsdatabaseproject.service.RankingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ComponentScan("com.lewandowski.actorsdatabaseproject.service")
@DataJpaTest
class ActorRepoTest {

    private ActorService as;
    private MovieCategoryService mcs;
    private RankingService rs;

    @Autowired
    public ActorRepoTest(ActorService as, MovieCategoryService mcs, RankingService rs) {
        this.as = as;
        this.mcs = mcs;
        this.rs = rs;
    }

    @BeforeEach
    void setUp() {
        Actor actor1 = new Actor("Mariusz);
    }
}
