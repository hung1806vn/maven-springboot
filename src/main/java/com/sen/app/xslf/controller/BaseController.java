package com.sen.app.xslf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sen.app.xslf.constant.APIResource;

@RestController
@RequestMapping(APIResource.API_PREFIX)
public class BaseController {
	
	@GetMapping(value = "/ping")
    public ResponseEntity<Object> getWeatherHistories() {
    	
        return ResponseEntity.ok("hello there!");
    }
}
