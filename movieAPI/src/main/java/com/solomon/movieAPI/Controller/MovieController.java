package com.solomon.movieAPI.Controller;

import com.solomon.movieAPI.Model.Movies;
import com.solomon.movieAPI.Service.MovieService;
import lombok.Generated;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
@Slf4j
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAllMovies(){
        log.info("Get all movies Started");
        List<Movies> movies = movieService.allMovies();

        log.info("Get all movies completed");
        return ResponseEntity.status(HttpStatus.OK).body(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMoviesById(@PathVariable String id){
        Optional<Movies> foundMovie = movieService.singleMovie(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(foundMovie);
    }
}