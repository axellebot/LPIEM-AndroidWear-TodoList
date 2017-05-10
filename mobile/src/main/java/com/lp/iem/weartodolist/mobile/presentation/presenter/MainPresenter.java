package com.lp.iem.weartodolist.mobile.presentation.presenter;

import com.lp.iem.weartodolist.mobile.presentation.view.MainView;


/**
 * Created by axell on 04/05/2017.
 */

public class MainPresenter implements Presenter {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
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
}
