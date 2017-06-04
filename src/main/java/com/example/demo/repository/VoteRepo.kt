package com.example.demo.repository

import com.example.demo.model.Vote
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

/**
 * Created by divine on 2017/06/04.
 */
interface VoteRepo : CrudRepository<Vote, Long> {
    // getting all the votes
    @Query(value = "select v.* from Option o, Vote v where o.POLL_ID = ?1 and v.OPTION_ID = o.OPTION_ID",
                                                                                                    nativeQuery = true)
    fun findByPoll(pollId: Long): Iterable<Vote>
}


