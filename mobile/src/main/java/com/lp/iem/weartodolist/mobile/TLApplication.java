package com.lp.iem.weartodolist.mobile;

import android.support.multidex.MultiDexApplication;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by axell on 04/05/2017.
 */

public class TLApplication extends MultiDexApplication {
    private static TLApplication application;
    private FirebaseAuth firebaseAuth;

    public static TLApplication app() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }
}