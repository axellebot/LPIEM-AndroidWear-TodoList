package com.lp.iem.weartodolist.mobile.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.BuildConfig;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.TLApplication;
import com.lp.iem.weartodolist.mobile.presentation.view.fragment.MainFragment;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final int RC_SIGN_IN = 123;

    @BindView(R.id.activity_main_navigation_drawer)
    NavigationView navigation_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation_drawer.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            addFragment(R.id.activity_main_framgent_container, MainFragment.newInstance());
        }
        verifyAuthentification();
    }

    private void verifyAuthentification() {
        if (TLApplication.app().getFirebaseAuth().getCurrentUser() != null) {
            //TODO : Added user connected information
        } else {
            Intent login = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                    .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                            new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                    .build();
            this.startActivityForResult(
                    login,
                    RC_SIGN_IN);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == ResultCodes.OK) {
                //TODO: NEXT STEP AFTER LOGIN
                return;
            } else {
                // Sign in failed
                if (response == null) {
                    //TODO: in case of user cancel
                    return;
                }
                switch (response.getErrorCode()) {
                    case ErrorCodes.NO_NETWORK:
                        Toast.makeText(this,"Network error",Toast.LENGTH_SHORT);
                        break;
                    case ErrorCodes.UNKNOWN_ERROR:
                        //TODO: in case of unknow error
                        break;
                }
            }
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_drawer_log_out:
                if (TLApplication.app().getFirebaseAuth().getCurrentUser() != null) {
                    TLApplication.app().getFirebaseAuth().signOut();
                }
                break;
        }
        return false;
    }
}
