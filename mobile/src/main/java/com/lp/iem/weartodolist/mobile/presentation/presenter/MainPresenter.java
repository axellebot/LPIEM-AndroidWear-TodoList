package com.lp.iem.weartodolist.mobile.presentation.presenter;

import com.lp.iem.weartodolist.mobile.data.dao.FirebaseTodoDao;
import com.lp.iem.weartodolist.mobile.data.dao.TodoDao;
import com.lp.iem.weartodolist.mobile.data.entity.TodoEntity;
import com.lp.iem.weartodolist.mobile.presentation.view.MainView;


/**
 * Created by axell on 04/05/2017.
 */

public class MainPresenter implements Presenter, TodoDao.Listener {
    private MainView mainView;


    public static final String CHILD_TODO_ITEMS = "todoItems";
    public static final String CHILD_USERS = "users";

    public MainPresenter() {
    }

    public void onCreateView(MainView mainView) {
        this.mainView = mainView;
        FirebaseTodoDao.getInstance().subscribe(this);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setTodo(TodoEntity todo) {
        mainView.setTodo(todo);
    }

    @Override
    public void changeTodo(TodoEntity todo) {
        mainView.changeTodo(todo);
    }

    @Override
    public void removeTodo(TodoEntity todo) {
        mainView.removeTodo(todo);
    }
}
