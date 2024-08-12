package com.IJP.jobs.services.repository;

import com.IJP.jobs.services.entity.jobentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface jobrepository extends JpaRepository<jobentity,String>{

}
