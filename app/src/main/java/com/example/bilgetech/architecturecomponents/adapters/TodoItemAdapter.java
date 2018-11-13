package com.example.bilgetech.architecturecomponents.adapters;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bilgetech.architecturecomponents.R;
import com.example.bilgetech.architecturecomponents.models.TodoItem;

import java.util.Collections;
import java.util.List;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemAdapter.TodoItemViewHolder> {
    private LayoutInflater layoutInflater;
    private List<TodoItem> todoItemList = Collections.emptyList();
    private Context context;

    public TodoItemAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(this.context);
    }

    @NonNull
    @Override
    public TodoItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = layoutInflater.inflate(R.layout.word_item_layout, viewGroup, false);
        return new TodoItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoItemViewHolder todoItemViewHolder, int i) {
        todoItemViewHolder.textView.setText(todoItemList.get(i).getDescription());
    }
    public void setData(List<TodoItem> todoItemList) {
        this.todoItemList = todoItemList;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return this.todoItemList.size();
    }

    static class TodoItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public TodoItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
        }


    }
}
