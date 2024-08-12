package com.IJP.jobs.services.services;

import com.IJP.jobs.services.entity.JobEntity;

public interface jobservice{
    JobEntity appliedjob(String job_id, String emp_id);
}
