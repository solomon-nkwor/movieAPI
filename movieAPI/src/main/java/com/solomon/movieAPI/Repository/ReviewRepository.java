package com.solomon.movieAPI.Repository;

import com.solomon.movieAPI.Model.Reviews;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews, ObjectId> {

    Optional<Reviews> findByMovieName(String title);
}
