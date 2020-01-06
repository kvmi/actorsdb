package com.lewandowski.actorsdatabaseproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "position")
    private int position;
    @OneToMany(mappedBy = "ranking",
            cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Actor> actors;

    public Ranking() {
    }

    public Ranking(int position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "id=" + id +
                ", position=" + position +
                ", actors=" + actors +
                '}';
    }
}
