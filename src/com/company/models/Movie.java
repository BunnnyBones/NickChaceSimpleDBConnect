package com.company.models;

public class Movie {

    private final int id;
    private final String title;
    private final String releaseYear;
    private final String rating;

    public Movie(int id, String title, String releaseYear, String rating) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }
}
