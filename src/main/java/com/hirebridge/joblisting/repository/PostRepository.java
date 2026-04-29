package com.hirebridge.joblisting.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hirebridge.joblisting.model.Post;

public interface PostRepository extends MongoRepository<Post,String>
{

    @Query("{ $or: [ { 'profile': { $regex: ?0, $options: 'i' } }, { 'desc': { $regex: ?0, $options: 'i' } } ] }")
    List<Post> searchJobs(String keyword);

}
