package com.lp.iem.weartodolist.mobile.presentation.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lp.iem.weartodolist.mobile.R;
import com.lp.iem.weartodolist.mobile.data.entity.TodoEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adaptar that manages a collection of {@link TodoEntity}.
 */
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<TodoEntity> todoCollection;
    private OnItemClickListener onItemClickListener;

    public TodoListAdapter(Context context) {
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
        final TodoEntity todoEntity = this.todoCollection.get(position);
        if (holder instanceof TodoViewHolder) {
            TodoViewHolder todoViewHolder = (TodoViewHolder) holder;
            todoViewHolder.tvLabel.setText(todoEntity.getLabel());
            todoViewHolder.tvDescription.setText(todoEntity.getDescription());
            todoViewHolder.checkBox.setActivated(todoEntity.isDone());
            todoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (TodoListAdapter.this.onItemClickListener != null) {
                        TodoListAdapter.this.onItemClickListener.onTodoItemClicked(todoEntity);
                    }
                }
            });
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setTodoCollection(Collection<TodoEntity> TodoCollection) {
        this.validateTodosCollection(TodoCollection);
        this.todoCollection = (List<TodoEntity>) TodoCollection;
        this.notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private void validateTodosCollection(Collection<TodoEntity> TodoCollection) {
        if (TodoCollection == null) {
            throw new IllegalArgumentException("The list cannot be null");
        }
    }

    public interface OnItemClickListener {
        void onTodoItemClicked(TodoEntity TodoEntity);
    }

    public void addItem(TodoEntity todoEntity){
        todoCollection.add(todoEntity);
        notifyDataSetChanged();
    }
    public void deleteItem(TodoEntity todoEntity){
        todoCollection.remove(todoEntity);
        notifyDataSetChanged();
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
