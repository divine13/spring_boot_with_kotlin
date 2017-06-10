package com.example.demo.repository;

import com.example.demo.model.Poll;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by divine on 2017/06/04.
 */
public interface PollRepo extends PagingAndSortingRepository<Poll, Long> {
}
