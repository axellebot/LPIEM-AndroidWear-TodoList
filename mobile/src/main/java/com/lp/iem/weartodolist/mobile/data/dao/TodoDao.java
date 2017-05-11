package com.lp.iem.weartodolist.mobile.data.dao;

import com.lp.iem.weartodolist.mobile.data.entity.TodoEntity;

/**
 * Created by axell on 11/05/2017.
 */

public interface TodoDao {

    interface Listener {
        void setTodo(TodoEntity todo);

        void changeTodo(TodoEntity todo);

        void removeTodo(TodoEntity todo);
    }

    void subscribe(Listener listener);

    void unSubscribe();

    void clean();
}
