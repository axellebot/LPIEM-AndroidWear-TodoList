package com.lp.iem.weartodolist.mobile.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.model.TodoModel;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link TodoModel}.
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<TodoModel> todoCollection;
    private OnItemClickListener onItemClickListener;

    TodoListAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todoCollection = Collections.emptyList();
    }

    @Override
    public int getItemCount() {
        return (this.todoCollection != null) ? this.todoCollection.size() : 0;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_item_todo, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, final int position) {
        final TodoModel todoModel = this.todoCollection.get(position);
        if (holder instanceof TodoViewHolder) {
            TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
            todoViewHolder.tvLabel.setText(todoModel.getLabel());
            todoViewHolder.tvDescription.setText(todoModel.getDescription());
            todoViewHolder.checkBox.setActivated(todoModel.isDone());
            todoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TodoListAdapter.this.onItemClickListener != null) {
                        TodoListAdapter.this.onItemClickListener.onTodoItemClicked(todoModel);
                    }
                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setTodoCollection(Collection<TodoModel> TodoCollection) {
        this.validateTodosCollection(TodoCollection);
        this.todoCollection = (List<TodoModel>) TodoCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateTodosCollection(Collection<TodoModel> TodoCollection) {
        if (TodoCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public interface OnItemClickListener {
        void onTodoItemClicked(TodoModel TodoModel);
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.list_item_todo_label)
        TextView tvLabel;

        @BindView(R.id.list_item_todo_description)
        TextView tvDescription;

        @BindView(R.id.list_item_todo_checkbox)
        CheckBox checkBox;

        TodoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
