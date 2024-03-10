package com.solomon.movieAPI.Service;

import com.solomon.movieAPI.Model.Movies;
import com.solomon.movieAPI.Repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movies> allMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movies> singleMovie(String id){
        return movieRepository.findMovieByImdbId(id);
    }
}