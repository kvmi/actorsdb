package com.lewandowski.actorsdatabaseproject.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "movies_played")
    private int moviesPlayed;
    @Column(name = "oscar_acquired")
    private short oscarAcquired;
    @Column(name = "birth_year")
    private int birthYear;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_ranking")
    private Ranking ranking;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_movieCategory")
    private MovieCategory movieCategory;

    public Actor() {
    }

    public Actor(String firstName, String lastName, int moviesPlayed, short oscarAcquired, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.moviesPlayed = moviesPlayed;
        this.oscarAcquired = oscarAcquired;
        this.birthYear = birthYear;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getMoviesPlayed() {
        return moviesPlayed;
    }

    public void setMoviesPlayed(int moviesPlayed) {
        this.moviesPlayed = moviesPlayed;
    }

    public short getOscarAcquired() {
        return oscarAcquired;
    }

    public void setOscarAcquired(short oscarAcquired) {
        this.oscarAcquired = oscarAcquired;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", moviesPlayed=" + moviesPlayed +
                ", oscarAcquired=" + oscarAcquired +
                ", birthYear=" + birthYear +
                ", ranking=" + ranking +
                ", movieCategory=" + movieCategory +
                '}';
    }
}
