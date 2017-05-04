package com.lp.iem.weartodolist;

import android.app.Application;

/**
 * Created by axell on 04/05/2017.
 */

public class TLApplication extends Application {
    private static TLApplication application;

    public static TLApplication app() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}