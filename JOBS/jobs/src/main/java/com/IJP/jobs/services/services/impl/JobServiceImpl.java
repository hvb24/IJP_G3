package com.IJP.jobs.services.services.impl;

import com.IJP.jobs.services.entity.ApplicationEntity;
import com.IJP.jobs.services.entity.JobEntity;
import com.IJP.jobs.services.repository.ApplicationRepository;
import com.IJP.jobs.services.repository.JobRepository;
import com.IJP.jobs.services.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository Jobrepository;
    @Autowired
    private ApplicationRepository applicationRepository;



    @Override
    public JobEntity postJob(JobEntity jobEntity, String hrId) {

        jobEntity.setHrId(hrId); // Ensure HR ID is set
        return Jobrepository.save(jobEntity);
    }


    @Override
    public List<JobEntity> getAllJobs(){
        return Jobrepository.findAll();
    }

    @Override
    public JobEntity getJobById(String job_id) {
        return Jobrepository.findById(job_id)
                .orElse(null); // Return null if not found
    }

    public List<ApplicationEntity> getApplicationsByEmpId(String empId) {
        return applicationRepository.findByEmpId(empId);
    }

    public boolean applyToJob(String empId, String jobId) {
        JobEntity job = Jobrepository.findById(jobId).orElse(null);
        System.out.println("inside apply job service impl"+job);

        if(job==null){
            return false;
        }

        ApplicationEntity application = new ApplicationEntity();
        application.setEmpId(empId);
        application.setJobId(job.getJob_id());
        applicationRepository.save(application);

        return true;
    }

    public List<ApplicationEntity> getApplicationsByJobId(String jobId) {
        return applicationRepository.findByJobId(jobId);
    }




}
