package com.lp.iem.weartodolist.mobile.presentation.view.activity;

import android.os.Bundle;

import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.presentation.view.fragment.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            addFragment(R.id.activity_main_framgent_container, MainFragment.newInstance());
        }
    }


}
