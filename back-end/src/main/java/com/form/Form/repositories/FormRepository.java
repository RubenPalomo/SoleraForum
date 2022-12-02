package com.form.Form.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.form.Form.models.HttpResponse;

@Component
public interface FormRepository {

    ArrayList<String> getThreads();

    HttpResponse addTitle(String thread, String title);

    HttpResponse checkBody(String body);
}
