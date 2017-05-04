package com.lp.iem.weartodolist.mobile.presentation.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.presentation.presenter.MainPresenter;
import com.lp.iem.weartodolist.mobile.presentation.view.MainView;

/**
 * Created by axell on 04/05/2017.
 */

public class MainFragment extends BaseFragment implements MainView {
    private MainPresenter mainPresenter;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);
        initializeInjection();
        return fragmentView;
    }

    private void initializeInjection() {
        mainPresenter = new MainPresenter(this);
    }

}
