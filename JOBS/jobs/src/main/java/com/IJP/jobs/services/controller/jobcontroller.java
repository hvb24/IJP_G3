package com.IJP.jobs.services.controller;

import com.IJP.jobs.services.entity.jobentity;
import com.IJP.jobs.services.services.jobservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Jobs")
public class jobcontroller {

    @Autowired
    private jobservice Jobservice;

    @GetMapping("/{job_id}/{emp_id}")
    public ResponseEntity<jobentity> getJobById(@PathVariable String job_id,@RequestParam String emp_id)
    {
        jobentity job = Jobservice.appliedjob(job_id,emp_id);
        return ResponseEntity.ok(job);
    }

}
