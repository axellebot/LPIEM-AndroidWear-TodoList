package com.lp.iem.weartodolist.mobile.entity;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by axell on 10/05/2017.
 */

@IgnoreExtraProperties
public class TodoEntity extends Entity {

    private String uid;
    private String label;
    private String description;
    private boolean done;

    public Map<String, Boolean> mapping = new HashMap<>();

    public TodoEntity() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public TodoEntity(String uid, String label, String description, boolean done) {
        this.uid = uid;
        this.label = label;
        this.description = description;
        this.done = done;
    }


    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("label", label);
        result.put("description", description);
        result.put("done", done);

        return result;
    }


    public String getUid() {
        return uid;
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

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Map<String, Boolean> getMapping() {
        return mapping;
    }

    public void setMapping(Map<String, Boolean> mapping) {
        this.mapping = mapping;
    }
}
