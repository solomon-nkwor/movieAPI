package com.solomon.movieAPI.Service;

import com.solomon.movieAPI.Model.Movies;
import com.solomon.movieAPI.Model.Reviews;
import com.solomon.movieAPI.Repository.MovieRepository;
import com.solomon.movieAPI.Repository.ReviewRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;



@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MovieRepository movieRepository;

    public Reviews createReviews(String reviewBody, String imdbId){
        // this inserts a user review into the repository
        Reviews review = reviewRepository.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }



}


