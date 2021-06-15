package com.example.tarea_recyclerview_con_cardviewitems;

public class ListElement {
    private String issues_id;
    private String volume;
    private String number;
    private String year;
    private String date_published;
    private String title;
    private String doi;
    private String cover;

    public ListElement(String issues_id, String volume, String number, String year, String date_published, String title, String doi, String cover) {
        this.issues_id = issues_id;
        this.volume = volume;
        this.number = number;
        this.year = year;
        this.date_published = date_published;
        this.title = title;
        this.doi = doi;
        this.cover = cover;
    }

    public String getIssues_id() {
        return issues_id;
    }

    public void setIssues_id(String issues_id) {
        this.issues_id = issues_id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
