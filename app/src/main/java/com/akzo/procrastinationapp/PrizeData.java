package com.akzo.procrastinationapp;

public class PrizeData {
    private String title;
    private String description;
    private int points;
    private boolean isPersistent;

    public PrizeData(String title, String description, int points, boolean isPersistent) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.isPersistent = isPersistent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isPersistent() {
        return isPersistent;
    }

    public void setPersistent(boolean persistent) {
        isPersistent = persistent;
    }
}
