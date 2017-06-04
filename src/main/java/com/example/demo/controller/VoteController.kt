package com.example.demo.controller

import com.example.demo.model.Vote
import com.example.demo.repository.VoteRepo
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.inject.Inject

/**
 * Created by divine on 2017/06/04.
 */

@RestController
class VoteController {

    @Inject
    private lateinit var voteRepo: VoteRepo

    @RequestMapping(value = "/polls/{pollId}/votes", method = arrayOf(RequestMethod.POST))
    fun createVote(@PathVariable pollId: Long, @RequestBody vote: Vote) : ResponseEntity<Any> {
        val v = voteRepo.save(vote)
        val responseHeader = HttpHeaders()
        responseHeader.location = ServletUriComponentsBuilder
                                                        .fromCurrentRequest()
                                                        .path("/{id}")
                                                        .buildAndExpand(vote.id)
                                                        .toUri()
        return ResponseEntity<Any>(null, responseHeader, HttpStatus.CREATED)
    }

}
