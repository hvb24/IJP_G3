package com.IJP.jobs.services.services.impl;

import com.IJP.jobs.services.entity.JobEntity;
import com.IJP.jobs.services.repository.jobrepository;
import com.IJP.jobs.services.services.jobservice;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class jobserviceimpl implements jobservice {

    @Autowired
    private jobrepository Jobrepository;

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


}
