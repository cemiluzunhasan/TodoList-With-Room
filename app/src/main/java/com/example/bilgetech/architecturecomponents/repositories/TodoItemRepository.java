package com.example.bilgetech.architecturecomponents.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.example.bilgetech.architecturecomponents.database.TodoItemDao;
import com.example.bilgetech.architecturecomponents.database.TodoItemDatabase;
import com.example.bilgetech.architecturecomponents.database.operations.InsertAsyncTask;
import com.example.bilgetech.architecturecomponents.models.TodoItem;

import java.util.List;

public class TodoItemRepository {
    private TodoItemDatabase mDatabase;
    private TodoItemDao mTodoItemDao;
    private LiveData<List<TodoItem>> todoItemList;

    public TodoItemRepository(Application application) {
        this.mDatabase = TodoItemDatabase.getDatabase(application);
        this.mTodoItemDao = mDatabase.todoItemDao();
        this.todoItemList = mTodoItemDao.getAllTodoItems();
    }

    public LiveData<List<TodoItem>> getAllTodoItems() {
        return this.todoItemList;
    }

    public void insertTodoItem(TodoItem todo) {
        new InsertAsyncTask(this.mTodoItemDao).execute(todo);
    }

    public void deleteAllTodos() {
        this.mTodoItemDao.deleteAllTodoItems();
    }
}
