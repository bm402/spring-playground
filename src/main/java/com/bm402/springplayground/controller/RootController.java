package com.bm402.springplayground.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping(value = "/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to the playground.");
    }
}
