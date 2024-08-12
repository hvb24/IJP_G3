package com.IJP.candidate.service.exception;

import com.IJP.candidate.service.entity.Candidate;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CandidateApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public CandidateApiException(HttpStatus status,String message){
        this.status=status;
        this.message=message;
    }


}
