package com.example.demo.controller

import com.example.demo.model.Poll
import com.example.demo.repository.PollRepo
import javax.inject.Inject

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import java.net.URI

/**
 * Created by divine on 2017/06/01.
 */

@RestController
class PollController {

    @Inject //late init used when the variable WILL be initialized therefore will never be NULL
    lateinit internal var pollRepo: PollRepo

    @RequestMapping(value = "/polls", method = arrayOf(RequestMethod.GET))
    fun allPolls() : ResponseEntity<Iterable<Poll>>{
        val allPolls = pollRepo.findAll()
        return ResponseEntity(allPolls, HttpStatus.OK)
    }

    @RequestMapping(value = "/polls", method = arrayOf(RequestMethod.POST))
    fun createPoll(@RequestBody poll: Poll): ResponseEntity<*> {
        val p = pollRepo.save(poll)
        val responseHeaders = HttpHeaders()
        val newPollUri = ServletUriComponentsBuilder
                                                .fromCurrentRequest()
                                                .path("/{id}")
                                                .buildAndExpand(poll.Id)
                                                .toUri()
        responseHeaders.location = newPollUri
        return ResponseEntity<Any>(null, responseHeaders, HttpStatus.CREATED)
    }

    @RequestMapping(value = "/polls/{pollId}", method = arrayOf(RequestMethod.GET))
    fun getPoll(@PathVariable pollId: Long?): ResponseEntity<*> {
        val p = pollRepo.findOne(pollId)
        return ResponseEntity<Any>(p, HttpStatus.OK)
    }

    //update poll
    @RequestMapping(value = "/poll/{pollId}", method = arrayOf(RequestMethod.PUT))
    fun updatePoll(@RequestBody poll: Poll, @PathVariable pollId: Long?): ResponseEntity<*> {
        val p = pollRepo.save(poll)
        return ResponseEntity<Any>(HttpStatus.OK) // mmnmh should i return back the new updated poll no i think its redundant we have get -> /polls/{id}
    }

    //delete poll
    @RequestMapping(value = "polls/{pollId}", method = arrayOf(RequestMethod.DELETE))
    fun deletePoll(@PathVariable pollId: Long): ResponseEntity<Any> {
        pollRepo.delete(pollId)
        return ResponseEntity(HttpStatus.OK) // Type inference here in Play ResponseEntity<Any>
    }
}
