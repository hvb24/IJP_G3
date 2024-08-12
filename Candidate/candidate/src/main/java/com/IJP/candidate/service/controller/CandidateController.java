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
    public ResponseEntity<Candidate> getCandidate(@PathVariable String id){


            Candidate data= candidateService.getCandidateId(id);
        if (data == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Candidate> postCandidate(@RequestBody Candidate candidate){
        Candidate res = candidateService.postCandidate(candidate);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }


}
