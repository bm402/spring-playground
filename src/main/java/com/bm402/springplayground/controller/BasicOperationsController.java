package com.bm402.springplayground.controller;

import com.bm402.springplayground.model.PowInput;
import com.bm402.springplayground.model.ResultDoubleResponse;
import com.bm402.springplayground.service.BasicOperationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BasicOperationsController {

    private final BasicOperationsService basicOperationsService;

    public BasicOperationsController(BasicOperationsService basicOperationsService) {
        this.basicOperationsService = basicOperationsService;
    }

    @PostMapping(value = "/pow")
    public ResponseEntity<ResultDoubleResponse> pow(@RequestBody PowInput powInput) {
        double result = basicOperationsService.pow(powInput.base(), powInput.exponent());
        return ResponseEntity.ok(new ResultDoubleResponse(result));
    }
}
