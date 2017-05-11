package com.lp.iem.weartodolist.mobile;

import android.support.multidex.MultiDexApplication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by axell on 04/05/2017.
 */

public class TLApplication extends MultiDexApplication {
    private static TLApplication application;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    public static TLApplication app() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        setupFirebase();
    }

    private void setupFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public FirebaseDatabase getFirebaseDatabase() {
        return firebaseDatabase;
    }
}