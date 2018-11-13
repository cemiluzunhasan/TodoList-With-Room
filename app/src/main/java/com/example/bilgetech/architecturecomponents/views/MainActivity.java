package com.example.bilgetech.architecturecomponents.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.bilgetech.architecturecomponents.R;
import com.example.bilgetech.architecturecomponents.adapters.TodoItemAdapter;
import com.example.bilgetech.architecturecomponents.models.TodoItem;
import com.example.bilgetech.architecturecomponents.viewmodels.TodoItemViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    TodoItemAdapter todoItemAdapter;
    TodoItemViewModel todoItemViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todoItemViewModel = ViewModelProviders.of(this).get(TodoItemViewModel.class);

        todoItemViewModel.getAllTodos().observe(this, todoItems -> {
            todoItemAdapter.setData(todoItems);
        });

        setupRecyclerView();

        fab = findViewById(R.id.fab);
        fab.setOnClickListener( v -> {
            Intent intent = new Intent(this, AddTodoActivity.class);
            startActivity(intent);
        });

    }

    @OnClick(R.id.fab)
    public void onFabClick() {
        Intent intent = new Intent(this, AddTodoActivity.class);
        startActivity(intent);
    }

    private void setupRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        todoItemAdapter = new TodoItemAdapter(this);
        recyclerView.setAdapter(todoItemAdapter);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
}
