package com.example.model;

public class ReviewList implements Comparable<ReviewList> {
    private int rating;
    private String date,reviews,name;

    public ReviewList(int rating, String date, String reviews, String name) {
        this.rating = rating;
        this.date = date;
        this.reviews = reviews;
        this.name = name;
    }

    @Override
    public int compareTo(ReviewList other) {
        return this.name.compareTo(other.name);
    }


    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
