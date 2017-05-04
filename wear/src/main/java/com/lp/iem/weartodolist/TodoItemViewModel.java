package com.lp.iem.weartodolist;

/**
 * Created by romai on 04/05/2017.
 */

public class TodoItemViewModel {
    private String title;

    public TodoItemViewModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
