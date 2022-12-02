package com.airline.AirlineFlight.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.airline.AirlineFlight.models.HttpResponse;
import com.airline.AirlineFlight.repositories.FormRepository;

@RestController
@RequestMapping("/form")
@CrossOrigin
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @GetMapping()
    public ArrayList<String> getThreads() {
        System.out.println("controller");
        return formRepository.getThreads();
    }

    @PostMapping()
    public HttpResponse saveTitle(@RequestBody Map<String, String> body) {
        String thread = body.get("thread");
        String title = body.get("title");
        if (thread == null || title == null) {
            return new HttpResponse("", "Invalid request body", false);
        }
        return formRepository.addTitle(thread, title);
    }

    @PostMapping("/")
    public HttpResponse checkBody(@RequestBody Map<String, String> body) {
        String post = body.get("post");
        if (post == null) {
            return new HttpResponse("", "Invalid request body", false);
        }
        return formRepository.checkBody(post);
    }
}
