package com.IJP.jobs.services.repository;

import com.IJP.jobs.services.entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {
    List<ApplicationEntity> findByEmpId(String empId);
    List<ApplicationEntity> findByJobId(String jobId);
}
