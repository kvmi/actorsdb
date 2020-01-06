package com.lewandowski.actorsdatabaseproject.service;

import com.lewandowski.actorsdatabaseproject.controller.MovieCategoryRepo;
import com.lewandowski.actorsdatabaseproject.model.Actor;
import com.lewandowski.actorsdatabaseproject.model.MovieCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCategoryServiceImpl implements MovieCategoryService {
    private MovieCategoryRepo movieCategoryRepo;

    @Autowired
    public MovieCategoryServiceImpl(MovieCategoryRepo movieCategoryRepo) { this.movieCategoryRepo = movieCategoryRepo; }

    @Override
    public void addAll(List<MovieCategory> movieCategories) {
        for (MovieCategory m : movieCategories)
            movieCategoryRepo.save(m);
    }

    @Override
    public void add(MovieCategory movieCategory) { movieCategoryRepo.save(movieCategory); }

    @Override
    public void delete(Integer id) { movieCategoryRepo.deleteById(id); }

    @Override
    public void update(MovieCategory movieCategory, Integer id) {
        MovieCategory movieCategoryUp = movieCategoryRepo.findById(id);
        movieCategoryUp.setName(movieCategory.getName());
        movieCategoryUp.setActors(movieCategory.getActors());
        movieCategoryRepo.save(movieCategoryUp);
    }

    @Override
    public MovieCategory findByName(String name) { return movieCategoryRepo.findAllByName(name).get(0);}

    @Override
    public MovieCategory findById(Integer Id) { return movieCategoryRepo.findById(Id); }

    @Override
    public List<MovieCategory> findAll() { return movieCategoryRepo.findAll(); }

}
