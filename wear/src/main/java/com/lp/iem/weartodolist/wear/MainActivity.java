package com.lp.iem.weartodolist.wear;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableRecyclerView;

import com.lp.iem.weartodolist.TodoItemViewModel;
import com.lp.iem.weartodolist.ui.adapter.TodoListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.activity_main_wear_recyclerview) WearableRecyclerView recyclerView;

    private TodoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                ButterKnife.bind(MainActivity.this);
                initRecyclerView();
            }
        });
    }

    private void initRecyclerView() {
        List<TodoItemViewModel> todoItemViewModels = new ArrayList<>();
        todoItemViewModels.add(new TodoItemViewModel("Element 1"));
        todoItemViewModels.add(new TodoItemViewModel("Element 2"));
        todoItemViewModels.add(new TodoItemViewModel("Element 3"));
        todoItemViewModels.add(new TodoItemViewModel("Element 4"));
        todoItemViewModels.add(new TodoItemViewModel("Element 5"));
        todoItemViewModels.add(new TodoItemViewModel("Element 6"));
        adapter = new TodoListAdapter(todoItemViewModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
