package com.akzo.procrastinationapp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TaskData{
    @Id
    private String title;
    @Property
    private String description;
    @Property
    private String deadline;
    @Property
    private int points;

    @Keep
    public TaskData(String title, String description, Date deadline, int points) {
        this.title = title;
        this.description = description;
        this.deadline = deadline.toString();
        this.points = points;
    }

    @Keep
    public TaskData(String title, String description, int points) {
        this.title = title;
        this.description = description;
        this.deadline = null;
        this.points = points;
    }

    @Generated(hash = 427500158)
    public TaskData() {
    }

    @Generated(hash = 1317956218)
    public TaskData(String title, String description, String deadline, int points) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
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
        this.deadline = deadline.toString();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}