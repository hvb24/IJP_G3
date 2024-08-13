package com.IJP.jobs.services.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String hrId;

    static private long jobidcount = 0;

    @PrePersist
    public void generatejob_id()
    {
        jobidcount++;
        this.job_id =  "JOB" + String.format("%04d",jobidcount);
    }




}
