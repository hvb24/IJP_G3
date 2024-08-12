package com.IJP.jobs.services.controller;

import com.IJP.jobs.services.entity.JobEntity;
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
    public ResponseEntity<JobEntity> getJobById(@PathVariable String job_id, @RequestParam String emp_id)
    {
        JobEntity job = Jobservice.appliedjob(job_id,emp_id);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/create/{hrId}")
    public ResponseEntity<JobEntity> postJobById(@RequestBody JobEntity jobEntity,@PathVariable String hrId){

        return null;
    }

}
