package com.airline.AirlineFlight.models;

import java.util.ArrayList;
import java.util.Arrays;

public class Form {

    final public ArrayList<String> threads = new ArrayList<>(
            Arrays.asList("football", "basketball", "gym", "swimming"));
    final private ArrayList<String> bannedWords = new ArrayList<>(Arrays.asList("fuck", "suck", "god"));

    private ArrayList<String> footballTitles = new ArrayList<>();
    private ArrayList<String> basketballTitles = new ArrayList<>();
    private ArrayList<String> gymTitles = new ArrayList<>();
    private ArrayList<String> swimmingTitles = new ArrayList<>();

    public Form() {
    }

    public ArrayList<String> getThreads() {
        return threads;
    }

    public ArrayList<String> getBannedWords() {
        return bannedWords;
    }

    public ArrayList<String> getFootballTitles() {
        return footballTitles;
    }

    public void addFootballTitle(String footballTitle) {
        this.footballTitles.add(footballTitle);
    }

    public ArrayList<String> getBasketballTitles() {
        return basketballTitles;
    }

    public void addBasketballTitle(String basketballTitle) {
        this.basketballTitles.add(basketballTitle);
    }

    public ArrayList<String> getGymTitles() {
        return gymTitles;
    }

    public void addGymTitle(String gymTitle) {
        this.gymTitles.add(gymTitle);
    }

    public ArrayList<String> getSwimmingTitles() {
        return swimmingTitles;
    }

    public void addSwimmingTitle(String swimmingTitle) {
        this.swimmingTitles.add(swimmingTitle);
    }

}
