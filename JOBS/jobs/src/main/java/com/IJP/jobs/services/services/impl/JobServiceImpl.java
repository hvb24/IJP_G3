package com.IJP.jobs.services.services.impl;

import com.IJP.jobs.services.entity.JobEntity;
import com.IJP.jobs.services.repository.JobRepository;
import com.IJP.jobs.services.services.JobService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRepository Jobrepository;

    @Transactional
    public JobEntity appliedjob(String job_id,String emp_id)
    {
        Optional<JobEntity> optionaljob = Jobrepository.findById(job_id);
        if(optionaljob.isPresent())
        {
            JobEntity job = optionaljob.get();
            job.getEmpIds().add(emp_id);
            return Jobrepository.save(job);
        }

            throw new RuntimeException("Job not found for the JobID:" + job_id);

    }

    @Override
    public JobEntity postJob(JobEntity jobEntity, String hrId) {

        jobEntity.setHrId(hrId); // Ensure HR ID is set
        System.out.println("inside the service impl");
        return Jobrepository.save(jobEntity);
    }



}
