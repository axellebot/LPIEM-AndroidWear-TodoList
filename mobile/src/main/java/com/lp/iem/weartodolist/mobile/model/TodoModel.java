package com.lp.iem.weartodolist.mobile.model;

/**
 * Created by axell on 10/05/2017.
 */

public class TodoModel {
    private String label;
    private String description;
    private boolean done;

    public TodoModel(String label, String description, boolean done) {
        this.label = label;
        this.description = description;
        this.done = done;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }
}
