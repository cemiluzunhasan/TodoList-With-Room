package com.example.bilgetech.architecturecomponents.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.bilgetech.architecturecomponents.models.TodoItem;
import com.example.bilgetech.architecturecomponents.repositories.TodoItemRepository;

import java.util.List;

public class TodoItemViewModel extends AndroidViewModel {

    private TodoItemRepository mTodoItemRepository;
    private LiveData<List<TodoItem>> mTodoItemList;

    public TodoItemViewModel(@NonNull Application application) {
        super(application);

        mTodoItemRepository = new TodoItemRepository(application);
        mTodoItemList = mTodoItemRepository.getAllTodoItems();

    }

    public void insert(TodoItem todoItem) {
        this.mTodoItemRepository.insertTodoItem(todoItem);
    }

    public LiveData<List<TodoItem>> getAllTodos() {
        return this.mTodoItemList;
    }

}
