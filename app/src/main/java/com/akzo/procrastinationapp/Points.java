package com.akzo.procrastinationapp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Points {
    @Id
    private String id = "main_points";
    @Property
    private int points;
    @Generated(hash = 1234493346)
    public Points(String id, int points) {
        this.id = id;
        this.points = points;
    }
    @Generated(hash = 1607589943)
    public Points() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getPoints() {
        return this.points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
}
