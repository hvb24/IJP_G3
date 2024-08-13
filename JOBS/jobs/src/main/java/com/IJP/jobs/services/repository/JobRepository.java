package com.IJP.jobs.services.repository;

import com.IJP.jobs.services.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity,String>{

}
