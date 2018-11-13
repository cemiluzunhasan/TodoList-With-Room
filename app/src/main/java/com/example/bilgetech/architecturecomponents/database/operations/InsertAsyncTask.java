package com.example.bilgetech.architecturecomponents.database.operations;

import android.os.AsyncTask;

import com.example.bilgetech.architecturecomponents.database.TodoItemDao;
import com.example.bilgetech.architecturecomponents.models.TodoItem;

public class InsertAsyncTask extends AsyncTask<TodoItem, Void, Void> {
    private TodoItemDao todoItemDao;

    public InsertAsyncTask(TodoItemDao todoItemDao) {
        this.todoItemDao = todoItemDao;
    }

    @Override
    protected Void doInBackground(TodoItem... todoItems) {
        this.todoItemDao.insertTodoItem(todoItems[0]);
        return null;
    }

}
