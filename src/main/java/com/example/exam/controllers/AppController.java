package com.example.exam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.services.IAppService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Exam")
public class AppController {
    @Autowired
    private IAppService appService;
}
