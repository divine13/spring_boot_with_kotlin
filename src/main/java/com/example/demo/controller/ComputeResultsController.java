package com.example.demo.controller;

import com.example.demo.dto.OptionCount;
import com.example.demo.dto.VoteResult;
import com.example.demo.model.Vote;
import com.example.demo.repository.VoteRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by divine on 2017/06/04.
 */
@RestController
public class ComputeResultsController {

    @Inject
    private VoteRepo voteRepo;

    @RequestMapping("/compute_results")
    public ResponseEntity<VoteResult> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepo.findByPoll(pollId);
        Map<Long, OptionCount> tempMap = new HashMap<>();
        int totalVotes = 0 ;

        for (Vote v: allVotes) {
            totalVotes++;
            OptionCount optionCount = tempMap.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
            optionCount.setOptionId(v.getOption().getId());
            tempMap.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount()+1);
        }

        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);

    }
}
