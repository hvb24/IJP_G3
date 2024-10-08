package com.IJP.candidate.service.repository;

import com.IJP.candidate.service.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,String> {
    Optional<Candidate> findByEmail(String email);
}
