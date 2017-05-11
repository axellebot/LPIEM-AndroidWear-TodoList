package com.lp.iem.weartodolist.mobile.presentation.view;

import com.lp.iem.weartodolist.mobile.data.entity.TodoEntity;

/**
 * Created by axell on 04/05/2017.
 */

public interface MainView {
    void setTodo(TodoEntity todoEntity);
    void changeTodo(TodoEntity todoEntity);
    void removeTodo(TodoEntity todoEntity);
}
