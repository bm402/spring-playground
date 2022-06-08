package com.bm402.springplayground.controller;

import com.bm402.springplayground.model.PowInput;
import com.bm402.springplayground.model.ResultDoubleResponse;
import com.bm402.springplayground.model.SqrtInput;
import com.bm402.springplayground.service.MathsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("maths")
@Slf4j
public class MathsController {

    private final MathsService mathsService;

    public MathsController(MathsService mathsService) {
        this.mathsService = mathsService;
    }

    @PostMapping("pow")
    public ResponseEntity<ResultDoubleResponse> pow(@RequestBody PowInput powInput) {
        double result = mathsService.pow(powInput.base(), powInput.exponent());
        log.info("Calculated {}^{} as {}", powInput.base(), powInput.exponent(), result);

        return ResponseEntity.ok(new ResultDoubleResponse(result));
    }

    @PostMapping("sqrt")
    public ResponseEntity<ResultDoubleResponse> sqrt(@RequestBody SqrtInput sqrtInput) {
        double result = mathsService.sqrt(sqrtInput.num());
        log.info("Calculated sqrt({}) as {}", sqrtInput.num(), result);

        return ResponseEntity.ok(new ResultDoubleResponse(result));
    }
}
