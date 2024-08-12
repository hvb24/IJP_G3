package com.IJP.jobs.services.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="jobs",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "job_id"
                })
        }
)
public class JobEntity {
    @Id
    private String job_id;
    private String description;
    private String location;
    private String reqSkill;
    private int yearOfExperience;
    private String languages;
    private double salaryR;
    private List<String> empIds = new ArrayList<>();
    private String hrId;

    static private long jobidcount = 0;

    @PrePersist
    public void generatejob_id()
    {
        jobidcount++;
        this.job_id =  "JOB" + String.format("%04d",jobidcount);
    }




}
