package com.airline.AirlineFlight.repositories;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.airline.AirlineFlight.models.Form;
import com.airline.AirlineFlight.models.HttpResponse;

@Component
public class FormRepositoryImpl implements FormRepository {

    private Form form = new Form();

    @Override
    public ArrayList<String> getThreads() {
        System.out.println("Repository");
        return form.threads;
    }

    @Override
    public HttpResponse addTitle(String thread, String title) {
        title.toLowerCase();
        thread.toLowerCase();

        switch (thread) {
            case "Football":
                if (!form.getFootballTitles().contains(title)) {
                    form.addFootballTitle(title);
                    return new HttpResponse(title, "Title added succesfully", true);
                } else {
                    return new HttpResponse(title, "Title already exist", false);
                }
            case "Basketball":
                if (!form.getBasketballTitles().contains(title)) {
                    form.addBasketballTitle(title);
                    return new HttpResponse(title, "Title added succesfully", true);
                } else {
                    return new HttpResponse(title, "Title already exist", false);
                }
            case "Gym":
                if (!form.getGymTitles().contains(title)) {
                    form.addGymTitle(title);
                    return new HttpResponse(title, "Title added succesfully", true);
                } else {
                    return new HttpResponse(title, "Title already exist", false);
                }
            case "Swimming":
                if (!form.getSwimmingTitles().contains(title)) {
                    form.addSwimmingTitle(title);
                    return new HttpResponse(title, "Title added succesfully", true);
                } else {
                    return new HttpResponse(title, "Title already exist", false);
                }
            default:
                return new HttpResponse(thread, "Thread does not exist", false);
        }
    }

    @Override
    public HttpResponse checkBody(String body) {
        body.toLowerCase();
        ArrayList<String> splittedBody = new ArrayList<>(Arrays.asList(body.split("\\s+")));

        for (String bannedWord : form.getBannedWords()) {
            if (splittedBody.contains(bannedWord)) {
                return new HttpResponse(bannedWord, "The post contains this banned word: " + bannedWord, false);
            }
        }
        return new HttpResponse("", "Post approved", true);
    }
}