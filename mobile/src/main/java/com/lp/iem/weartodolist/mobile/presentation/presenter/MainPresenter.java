package com.lp.iem.weartodolist.mobile.presentation.presenter;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.lp.iem.weartodolist.mobile.TLApplication;
import com.lp.iem.weartodolist.mobile.entity.TodoEntity;
import com.lp.iem.weartodolist.mobile.presentation.view.MainView;

import java.util.List;


/**
 * Created by axell on 04/05/2017.
 */

public class MainPresenter implements Presenter {
    private MainView mainView;


    public static final String CHILD_TODO_ITEMS = "todoItems";
    public static final String CHILD_USERS = "users";
    public static final String CHILD_DESCRIPTION = "description";
    public static final String CHILD_DONE = "done";
    public static final String CHILD_LABEL = "label";

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }
    public void setupView(){
        first();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private void first() {
        if(TLApplication.app().getFirebaseAuth().getCurrentUser() == null){
            return;
        }
        Query todoListUid = TLApplication.app().getFirebaseDatabase()
                .getReference(CHILD_USERS)
                .child(TLApplication.app().getFirebaseAuth().getCurrentUser().getUid())
                .child(CHILD_TODO_ITEMS);

        todoListUid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> listUids = (List<String>) dataSnapshot.getValue();
                System.out.println(listUids);
                second(listUids);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void second(List<String> listUids) {
        for (final String uid : listUids) {
            final Query todoListUid = TLApplication.app().getFirebaseDatabase()
                    .getReference(CHILD_TODO_ITEMS)
                    .child(uid);
            todoListUid.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    TodoEntity todoEntity = (TodoEntity) dataSnapshot.getValue(TodoEntity.class);
                    todoEntity.setUid(uid);
                    display(todoEntity);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }

    private void display(TodoEntity todoEntity) {
        mainView.displayItem(todoEntity);
    }
}
