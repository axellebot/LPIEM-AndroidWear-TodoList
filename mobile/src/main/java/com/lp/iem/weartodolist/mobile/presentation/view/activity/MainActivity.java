package com.lp.iem.weartodolist.mobile.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.BuildConfig;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.TLApplication;
import com.lp.iem.weartodolist.mobile.presentation.view.fragment.MainFragment;

import java.util.Arrays;

public class MainActivity extends BaseActivity {

    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addFragment(R.id.activity_main_framgent_container, MainFragment.newInstance());
        }

        verifyAuthentification();
    }

    private void verifyAuthentification() {
        if (TLApplication.app().getFirebaseAuth().getCurrentUser() != null) {
            //TODO : Added user connected information
        } else {
            this.startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(!BuildConfig.DEBUG)
                            .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                            .build(),
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
                        //TODO: in case of network error
                        break;
                    case ErrorCodes.UNKNOWN_ERROR:
                        //TODO: in case of unknow error
                        break;
                }
            }
        }
    }

}
