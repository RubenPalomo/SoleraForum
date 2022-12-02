package com.airline.AirlineFlight.controllers;

import java.util.ArrayList;

import org.bson.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.AirlineFlight.models.HttpResponse;
import com.airline.AirlineFlight.repositories.FormRepository;

@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormRepository formRepository;

    @GetMapping()
    public ArrayList<String> getThreads() {
        System.out.println("controller");
        return formRepository.getThreads();
    }

    @PostMapping()
    public HttpResponse saveTitle(@RequestBody JSONObject body) {
        System.out.println(body);
        String thread = body.getString("thread");
        String title = body.getString("title");

        System.out.println(thread);
        System.out.println(title);
        return formRepository.addTitle(thread, title);
    }

    @PostMapping("/")
    public HttpResponse checkBody(@RequestBody String body) {
        return formRepository.checkBody(body);
    }
}
