package com.example.demo.controller

import com.example.demo.dto.OptionCount
import com.example.demo.dto.VoteResult
import com.example.demo.model.Vote
import com.example.demo.repository.VoteRepo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import javax.inject.Inject
import java.util.HashMap

/**
 * Created by divine on 2017/06/04.
 */
@RestController
class ComputeResultsController(private val voteRepo: VoteRepo) { //NO NEED TO INJECT YOH!

    @RequestMapping("/compute_results")
    fun computeResult(@RequestParam pollId: Long?): ResponseEntity<VoteResult> {
        val voteResult = VoteResult()
        val allVotes = voteRepo.findByPoll(pollId!!)
        val tempMap = HashMap<Long, OptionCount>()
        var totalVotes = 0

        for (v in allVotes) {
            totalVotes++
            var optionCount: OptionCount? = tempMap[v.option.id]
            if (optionCount == null) {
                optionCount = OptionCount()
                optionCount.optionId = v.option.id
                tempMap.put(v.option.id!!, optionCount)
            }
            optionCount.count = optionCount.count + 1
        }

        voteResult.totalVotes = totalVotes
        voteResult.results = tempMap.values
        return ResponseEntity(voteResult, HttpStatus.OK)

    }
}
