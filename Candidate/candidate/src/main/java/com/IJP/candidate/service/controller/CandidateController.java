package com.IJP.candidate.service.controller;

import com.IJP.candidate.service.entity.Candidate;
import com.IJP.candidate.service.services.CandidateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServices candidateService;

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable String id){
        return candidateService.getCandidateId(id);
    }

    @PostMapping
    public ResponseEntity<Candidate> postCandidate(@RequestBody Candidate candidate){
        Candidate res = candidateService.postCandidate(candidate);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
