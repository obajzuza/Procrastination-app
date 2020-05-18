package com.akzo.procrastinationapp;

import java.util.Date;

public class TaskData{
    private String title;
    private String description;
    private Date deadline;
    private int points;

    public TaskData(String title, String description, Date deadline, int points) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.points = points;
    }

    public TaskData(String title, String description, int points) {
        this.title = title;
        this.description = description;
        this.deadline = null;
        this.points = points;
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

    public String getDeadline() {
        if (deadline == null) {
            return "";
        }
        return deadline.toString();
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}