package com.ingrid.showdofilmao.model;

public class Movie {

    private String title;
    private String gender;
    private int year;
    private String posterURL;

    public Movie(String title, String gender, int year, String posterURL) {
        this.title = title;
        this.gender = gender;
        this.year = year;
        this.posterURL = posterURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }
}
