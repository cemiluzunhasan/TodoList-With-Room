package com.example.bilgetech.architecturecomponents.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.bilgetech.architecturecomponents.models.TodoItem;

@Database(entities = {TodoItem.class}, version = 1, exportSchema = false)
public abstract class TodoItemDatabase extends RoomDatabase {
    private static TodoItemDatabase mInstance;
    private static final String DATABASE_NAME = "todo_database";

    public static synchronized TodoItemDatabase getDatabase(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context, TodoItemDatabase.class, DATABASE_NAME).build();
        }
        return mInstance;
    }

    public static void deleteDatabase() {
        mInstance = null;
    }

    public abstract TodoItemDao todoItemDao();
}
