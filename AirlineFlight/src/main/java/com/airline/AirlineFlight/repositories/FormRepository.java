package com.airline.AirlineFlight.repositories;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.airline.AirlineFlight.models.HttpResponse;

@Component
public interface FormRepository {

    ArrayList<String> getThreads();

    HttpResponse addTitle(String thread, String title);

    HttpResponse checkBody(String body);
}
