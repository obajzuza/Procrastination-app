package com.akzo.procrastinationapp;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class PrizeData {
    @Id
    private String title;
    @Property
    private String description;
    @Property
    private int points;
    @Property
    private boolean isPersistent;

    @Keep
    public PrizeData(String title, String description, int points, boolean isPersistent) {
        this.title = title;
        this.description = description;
        this.points = points;
        this.isPersistent = isPersistent;
    }

    @Generated(hash = 1083045783)
    public PrizeData() {
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

    public boolean getIsPersistent() {
        return this.isPersistent;
    }

    public void setIsPersistent(boolean isPersistent) {
        this.isPersistent = isPersistent;
    }
}
