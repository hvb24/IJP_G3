package com.IJP.candidate.service.services;

import com.IJP.candidate.service.entity.Candidate;
import org.springframework.stereotype.Service;

@Service
public interface CandidateServices{

    Candidate getCandidateId(String id);
    String getCandidateEmail(String email);
    Candidate postCandidate(Candidate candidate);

}
