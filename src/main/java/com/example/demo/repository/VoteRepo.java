package com.example.demo.repository;

import com.example.demo.model.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by divine on 2017/06/04.
 */
public interface VoteRepo extends CrudRepository<Vote, Long> {
}
