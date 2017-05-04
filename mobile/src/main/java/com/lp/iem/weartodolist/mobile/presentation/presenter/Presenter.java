package com.lp.iem.weartodolist.mobile.presentation.presenter;

/**
 * Created by axell on 04/05/2017.
 */

/**
 * Interface representing a Presenter in a model view presenter (MVP) pattern.
 */
public interface Presenter {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    void resume();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    void pause();

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    void destroy();
}