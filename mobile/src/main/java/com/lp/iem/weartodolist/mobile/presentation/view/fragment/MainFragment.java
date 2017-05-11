package com.lp.iem.weartodolist.mobile.presentation.view.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.entity.TodoEntity;
import com.lp.iem.weartodolist.mobile.presentation.presenter.MainPresenter;
import com.lp.iem.weartodolist.mobile.presentation.view.MainView;
import com.lp.iem.weartodolist.mobile.presentation.view.adapter.TodoListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by axell on 04/05/2017.
 */

public class MainFragment extends BaseFragment implements MainView {
    private MainPresenter mainPresenter;

    private TodoListAdapter todoListAdapter;

    @BindView(R.id.fragment_main_recylceview) RecyclerView recyclerView;

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
        ButterKnife.bind(this, fragmentView);
        initializeInjection();
        todoListAdapter = new TodoListAdapter(getActivity());
        recyclerView.setAdapter(todoListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainPresenter.setupView();
        return fragmentView;
    }

    private void initializeInjection() {
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void displayItem(TodoEntity todoEntity) {
        todoListAdapter.addItem(todoEntity);
    }
}
