package com.IJP.hr.service.services;

import com.IJP.hr.service.entity.HrEntity;

public interface HrService {
    HrEntity getHrByEmail(String email);
    HrEntity postHr(HrEntity hrEntity);
}
