package com.IJP.candidate.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name="employees",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                        "empID"
                })
        }

)
public class Candidate {

    @Id
    private String empID;
    private  String firstName;
    private String lastName;
    private String email;
    private String dob;
    private String managerId;
    private String managerEmail;




}
