package com.IJP.candidate.service.services.impl;

import com.IJP.candidate.service.repository.CandidateRepository;
import com.IJP.candidate.service.services.CandidateServices;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IJP.candidate.service.entity.Candidate;

import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateServices {

    @Autowired
    private CandidateRepository candidateRepo;

    @Override
    public Candidate getCandidateId(String id) {
        // Assuming 'id' is a unique identifier and CandidateRepo returns Candidate
        Optional<Candidate> candidate = candidateRepo.findById(id);
        return candidate.orElse(null); // Returns null if no candidate is found
    }

    @Override
    public String getCandidateEmail(String email){
        Optional<Candidate> candidate = candidateRepo.findByEmail(email);
        if (candidate.isPresent()) {
            return candidate.get().getEmpID();  // Assuming Candidate has a method getId()
        } else {
            return "Candidate not found";
        }
    }

    @Override
    public Candidate postCandidate(Candidate candidate){
        return candidateRepo.save(candidate);
    }



}
