package com.lp.iem.weartodolist.mobile;

import android.support.multidex.MultiDexApplication;

/**
 * Created by axell on 04/05/2017.
 */

public class TLApplication extends MultiDexApplication {
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