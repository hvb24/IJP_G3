package com.IJP.jobs.services.controller;

import com.IJP.jobs.services.entity.ApplicationEntity;
import com.IJP.jobs.services.entity.JobEntity;
import com.IJP.jobs.services.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Jobs")
public class JobController {



    @Autowired
    private JobService Jobservice;


    //TODO Make list of jobs by HrID
//    @GetMapping("/{hr_id}")
//    public ResponseEntity<JobEntity> getJobById(@PathVariable String job_id, @RequestParam String emp_id)
//    {
//        JobEntity job = Jobservice.appliedjob(job_id,emp_id);
//        return ResponseEntity.ok(job);
//    }

    @PostMapping("/create/{hrId}")
    public ResponseEntity<JobEntity> postJobById(@RequestBody JobEntity jobEntity,@PathVariable String hrId){
        System.out.println("inside post JobById");

     JobEntity job= Jobservice.postJob(jobEntity,hrId);
     return ResponseEntity.ok(job);

    }

    @GetMapping
    public List<JobEntity> getAllJobs(){
        return Jobservice.getAllJobs();
    }

    @GetMapping("/get/{job_id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable String job_id){

        System.out.println("inside getJobById"+job_id);
        JobEntity res = Jobservice.getJobById(job_id);
        System.out.println(res);
        if(res != null){
            return ResponseEntity.ok(res);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-empid/{empId}")
    public ResponseEntity<List<ApplicationEntity>> getApplicationsByEmpId(@PathVariable String empId){
        try{
            List<ApplicationEntity> res = Jobservice.getApplicationsByEmpId(empId);
            if(res.isEmpty()){
                return ResponseEntity.notFound().build();
            }else{
                return ResponseEntity.ok(res);
            }
        }catch(Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/post-job-empID")
    public ResponseEntity<String> applyToJob(@RequestParam("empId") String empId, @RequestParam("jobId") String jobId){
       System.out.println("inside applyToJob controller"+empId+jobId);
        boolean res = Jobservice.applyToJob(empId,jobId);
        if(res){
            return new ResponseEntity<>("Application submitted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Application failed", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/get-emp-jobId/{jobId}")
    public ResponseEntity<List<ApplicationEntity>> getApplicationsByJobId(@PathVariable String jobId){
        System.out.println("inside getApplicationsByJobId"+jobId);
        List<ApplicationEntity> res = Jobservice.getApplicationsByJobId(jobId);
        if(res.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(res);
    }

}
