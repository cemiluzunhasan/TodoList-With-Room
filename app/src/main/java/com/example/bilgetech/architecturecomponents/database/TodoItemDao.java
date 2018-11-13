package com.example.bilgetech.architecturecomponents.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.bilgetech.architecturecomponents.models.TodoItem;

import java.util.List;

@Dao
public interface TodoItemDao {

    @Query("SELECT * FROM todo_item")
    LiveData<List<TodoItem>> getAllTodoItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodoItem(TodoItem todoItem);

    @Delete
    void deleteTodoItem(TodoItem todoItem);

    @Query("DELETE FROM todo_item")
    void deleteAllTodoItems();
}
