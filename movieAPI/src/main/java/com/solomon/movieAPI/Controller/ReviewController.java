package com.solomon.movieAPI.Controller;

import com.solomon.movieAPI.Model.Reviews;
import com.solomon.movieAPI.Service.MovieService;
import com.solomon.movieAPI.Service.ReviewService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @PostMapping("/create-review")
    public ResponseEntity<?> createReviews(@RequestBody Map<String, String> payload){
        Reviews review = reviewService.createReviews(payload.get("reviewBody"), payload.get("imdbId"));
        return ResponseEntity.status(HttpStatus.CREATED).body(review);

    }

    @GetMapping("/find-reviews/{id}")
    public ResponseEntity<?> getReviews(@PathVariable String id){
        Optional<List<Reviews>> review = movieService.extractReviewIds(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(review);
    }
}
