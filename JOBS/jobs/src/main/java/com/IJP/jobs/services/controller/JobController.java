package com.IJP.jobs.services.controller;

import com.IJP.jobs.services.entity.JobEntity;
import com.IJP.jobs.services.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Jobs")
public class JobController {



    @Autowired
    private JobService Jobservice;


    //TODO Make list of jobs by HrID
    @GetMapping("/{hr_id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable String job_id, @RequestParam String emp_id)
    {
        JobEntity job = Jobservice.appliedjob(job_id,emp_id);
        return ResponseEntity.ok(job);
    }

    @PostMapping("/create/{hrId}")
    public ResponseEntity<JobEntity> postJobById(@RequestBody JobEntity jobEntity,@PathVariable String hrId){
        System.out.println("inside controller");

     JobEntity job= Jobservice.postJob(jobEntity,hrId);
     return ResponseEntity.ok(job);

    }

}
