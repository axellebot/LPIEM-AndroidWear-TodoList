package com.lp.iem.weartodolist.ui.adapter;

import android.support.wearable.view.WearableListView;
import android.support.wearable.view.WearableRecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lp.iem.weartodolist.TodoItemViewModel;
import com.lp.iem.weartodolist.wear.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by romai on 04/05/2017.
 */

public class TodoListAdapter extends WearableRecyclerView.Adapter<TodoListAdapter.TodoListViewHolder> {

    private List<TodoItemViewModel> todoItemViewModels;

    public TodoListAdapter(List<TodoItemViewModel> todoItemViewModels) {
        this.todoItemViewModels = todoItemViewModels;
    }

    @Override
    public TodoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_todo_list_row, parent, false);
        final TodoListViewHolder todoListViewHolder = new TodoListViewHolder(view);
        todoListViewHolder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todoListViewHolder.checkbox.setChecked(!todoListViewHolder.checkbox.isChecked());
            }
        });
        return todoListViewHolder;
    }

    @Override
    public void onBindViewHolder(TodoListViewHolder holder, int position) {
        holder.title.setText(todoItemViewModels.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return todoItemViewModels.size();
    }

    public class TodoListViewHolder extends WearableListView.ViewHolder{

        @BindView(R.id.view_todo_list_row_container) LinearLayout container;
        @BindView(R.id.view_todo_list_row_title) TextView title;
        @BindView(R.id.view_todo_list_row_checkbox) CheckBox checkbox;

        public TodoListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
