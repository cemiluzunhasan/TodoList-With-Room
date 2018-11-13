package com.example.bilgetech.architecturecomponents.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "todo_item")
public class TodoItem {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String description;

    @Ignore
    public TodoItem(String description) {
        this.description = description;
    }

    public TodoItem(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
