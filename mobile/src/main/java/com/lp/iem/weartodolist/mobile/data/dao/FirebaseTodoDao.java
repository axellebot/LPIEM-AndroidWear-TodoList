package com.lp.iem.weartodolist.mobile.data.dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lp.iem.weartodolist.mobile.data.entity.TodoEntity;


/**
 * Created by axell on 11/05/2017.
 */

public class FirebaseTodoDao implements TodoDao, ChildEventListener {

    private static FirebaseTodoDao firebaseTodoDao;

    public static TodoDao getInstance() {
        if (firebaseTodoDao == null) {
            firebaseTodoDao = new FirebaseTodoDao();
        }
        return firebaseTodoDao;
    }

    private DatabaseReference firebaseDatabaseReference;
    private String userId;
    private Listener listener;

    public FirebaseTodoDao() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        firebaseDatabaseReference = database.getReference();
        userId = auth.getCurrentUser().getUid();
    }

    private final String CHILD_TODO_USERS = "users";
    private final String CHILD_TODO_ITEMS = "todoItems";

    @Override
    public void subscribe(Listener listener) {
        this.listener = listener;
        firebaseDatabaseReference
                .child(CHILD_TODO_USERS)
                .child(userId)
                .child(CHILD_TODO_ITEMS)
                .addChildEventListener(this);
    }

    @Override
    public void unSubscribe() {
        firebaseDatabaseReference
                .child(CHILD_TODO_USERS)
                .child(userId)
                .child(CHILD_TODO_ITEMS)
                .removeEventListener(this);
        this.listener = null;
    }

    @Override
    public void clean() {

    }

    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        TodoEntity todoEntity = dataSnapshot.getValue(TodoEntity.class);
        todoEntity.setUid(dataSnapshot.getKey());

        this.listener.setTodo(todoEntity);
    }

    @Override
    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
        TodoEntity todoEntity = dataSnapshot.getValue(TodoEntity.class);
        todoEntity.setUid(dataSnapshot.getKey());

        this.listener.changeTodo(todoEntity);
    }

    @Override
    public void onChildRemoved(DataSnapshot dataSnapshot) {
        TodoEntity todoEntity = dataSnapshot.getValue(TodoEntity.class);
        todoEntity.setUid(dataSnapshot.getKey());

        this.listener.removeTodo(todoEntity);
    }

    @Override
    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
        // do nothing for now
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        // do nothing for now
    }
}
