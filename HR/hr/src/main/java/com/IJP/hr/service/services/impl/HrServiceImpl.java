package com.IJP.hr.service.services.impl;

import com.IJP.hr.service.entity.HrEntity;
import com.IJP.hr.service.exceptions.HrApiException;
import com.IJP.hr.service.exceptions.ResourceNotFoundException;
import com.IJP.hr.service.repository.HrRepository;
import com.IJP.hr.service.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class HrServiceImpl implements HrService {

    @Autowired
    private HrRepository hrRepository;

    @Override
    public HrEntity getHrByEmail(String email) {
        return hrRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("HR","email",email));
    }

    @Override
    public HrEntity postHr(HrEntity hrEntity) {
        HrEntity res = hrRepository.save(hrEntity);
        if(res==null) {
            throw new HrApiException("HR not created", HttpStatus.BAD_REQUEST);
        }
        return res;
    }
}
