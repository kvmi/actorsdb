package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.model.MovieCategory;

import java.util.List;

public interface MovieCategoryService {
    void addAll(List<MovieCategory> movieCategories);

    void add(MovieCategory movieCategory);

    void delete(Integer id);

    void update(MovieCategory movieCategory, Integer id);

    MovieCategory findByName(String name);

    MovieCategory findById(Integer id)
            ;
    List<MovieCategory> findAll();

}
