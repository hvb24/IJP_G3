package com.IJP.jobs.services.services;

import com.IJP.jobs.services.entity.JobEntity;

import java.util.List;
import java.util.Optional;

public interface jobservice{
    JobEntity appliedjob(String job_id, String emp_id);

    List<JobEntity> getAllJobs();
    JobEntity getJobById(String job_id);
}
