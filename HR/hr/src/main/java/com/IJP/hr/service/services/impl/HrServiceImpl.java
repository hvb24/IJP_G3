package com.IJP.hr.service.services.impl;

import com.IJP.hr.service.entity.HrEntity;
import com.IJP.hr.service.repository.HrRepository;
import com.IJP.hr.service.services.HrService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrRepository hrRepository;

    @Override
    public HrEntity getHrByEmail(String email) {
        return hrRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("HrEntity not found for email: " + email));
    }

    @Override
    public HrEntity postHr(HrEntity hrEntity) {
        return hrRepository.save(hrEntity);
    }
}
