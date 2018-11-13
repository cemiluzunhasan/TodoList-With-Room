package com.example.bilgetech.architecturecomponents.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.bilgetech.architecturecomponents.R;
import com.example.bilgetech.architecturecomponents.models.TodoItem;
import com.example.bilgetech.architecturecomponents.viewmodels.TodoItemViewModel;

import butterknife.BindView;
import butterknife.OnClick;

public class AddTodoActivity extends AppCompatActivity {


    EditText editText;

    Button btn;
    private TodoItemViewModel todoItemViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        todoItemViewModel = ViewModelProviders.of(this).get(TodoItemViewModel.class);
        btn = findViewById(R.id.button_add);
        editText = findViewById(R.id.edittext_todoitem);

        btn.setOnClickListener( v-> {
            TodoItem todoItem = new TodoItem(editText.getText().toString());
            todoItemViewModel.insert(todoItem);
            finish();
        });
    }
}
