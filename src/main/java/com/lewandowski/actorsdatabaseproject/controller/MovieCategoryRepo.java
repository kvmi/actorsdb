package com.lewandowski.actorsdatabaseproject.controller;

import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MovieCategoryRepo extends Repository<MovieCategory,Integer> {
    void save(MovieCategory movieCategory);
    List<MovieCategory> findAll();
    MovieCategory findById(Integer id);
    MovieCategory deleteById(Integer id);
    List<MovieCategory> findAllByName(String name);

}
