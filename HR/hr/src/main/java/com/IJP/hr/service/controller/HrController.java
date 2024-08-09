package com.IJP.hr.service.controller;

import com.IJP.hr.service.entity.HrEntity;
import com.IJP.hr.service.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hr")
public class HrController {

    @Autowired
    private HrService hrService;

    @GetMapping("/{email}")
    public ResponseEntity<HrEntity> getHrByEmail(@PathVariable String email) {
        HrEntity res = hrService.getHrByEmail(email);
        if(res == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HrEntity> postHr(@RequestBody HrEntity hrEntity) {
        HrEntity res = hrService.postHr(hrEntity);
        if(res == null) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

}
