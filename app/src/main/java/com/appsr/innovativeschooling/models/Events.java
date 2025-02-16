package com.appsr.innovativeschooling.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "events")
public class Events {
    @PrimaryKey(autoGenerate = true)
    public int event_id;

    public String heading;
    public String description;
    public String event_date;
    public String class_section_all;

    public int getEvent_id () {
        return event_id;
    }

    public void setEvent_id (int event_id) {
        this.event_id = event_id;
    }

    public String getHeading () {
        return heading;
    }

    public void setHeading (String heading) {
        this.heading = heading;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getEvent_date () {
        return event_date;
    }

    public void setEvent_date (String event_date) {
        this.event_date = event_date;
    }

    public String getClass_section_all () {
        return class_section_all;
    }

    public void setClass_section_all (String class_section_all) {
        this.class_section_all = class_section_all;
    }
}

