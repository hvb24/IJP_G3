package com.IJP.hr.service.controller;

import com.IJP.hr.service.entity.HrEntity;
import com.IJP.hr.service.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @GetMapping("/{email}")
    public HrEntity getHrByEmail(@PathVariable String email) {
        return hrService.getHrByEmail(email);
    }

    @PostMapping
    public HrEntity postHr(@RequestBody HrEntity hrEntity) {
        return hrService.postHr(hrEntity);
    }

}
