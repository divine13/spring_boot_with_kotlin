package com.example.demo.controller

import com.example.demo.model.Poll
import com.example.demo.repository.PollRepo
import com.example.demo.exception.ResourceNotFoundException
import org.springframework.data.domain.Pageable

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

/**
 * Created by divine on 2017/06/01.
 */

@RestController
class PollController(private val pollRepo: PollRepo) {

    @RequestMapping(value = "/polls", method = arrayOf(RequestMethod.GET))
    fun getAllPolls(pageable : Pageable) : ResponseEntity<Iterable<Poll>> {
        val allPolls = pollRepo.findAll(pageable)
        return ResponseEntity(allPolls, HttpStatus.OK)
    }

    @RequestMapping(value = "/polls", method = arrayOf(RequestMethod.POST))
    fun createPoll(@Valid @RequestBody poll: Poll): ResponseEntity<*> { // perform validation specified by the domain object
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

        val p = pollRepo.findOne(pollId) ?: throw ResourceNotFoundException("Poll with id: $pollId not found")
        return ResponseEntity<Any>(p, HttpStatus.OK)
    }

    //update poll
    @RequestMapping(value = "/poll/{pollId}", method = arrayOf(RequestMethod.PUT))
    fun updatePoll(@RequestBody poll: Poll, @PathVariable pollId: Long?): ResponseEntity<*> {
        verify(pollId)
        val p = pollRepo.save(poll)
        return ResponseEntity<Any>(HttpStatus.OK) //  should i return back the new updated poll no i think its redundant we have get -> /polls/{id}
    }

    //delete poll
    @RequestMapping(value = "polls/{pollId}", method = arrayOf(RequestMethod.DELETE))
    fun deletePoll(@PathVariable pollId: Long?): ResponseEntity<Any> {
        verify(pollId)
        pollRepo.delete(pollId)
        return ResponseEntity(HttpStatus.OK) // Type inference here in Play ResponseEntity<Any>
    }

    // one liner function
    private fun verify(pollId: Long?) =
            pollId ?: throw ResourceNotFoundException("Poll with id: $pollId not found")

}
