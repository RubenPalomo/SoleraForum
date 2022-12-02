package com.form.Form.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.form.Form.models.HttpResponse;
import com.form.Form.repositories.FormRepository;

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
    public HttpResponse saveTitle(@RequestBody Map<String, String> body) {
        if (body.get("post") != null) {

            return formRepository.checkBody(body.get("post"));

        } else if (body.get("thread") != null || body.get("title") != null) {

            return formRepository.addTitle(body.get("thread"), body.get("title"));

        }
        return new HttpResponse("", "Invalid request body", false);
    }
}
