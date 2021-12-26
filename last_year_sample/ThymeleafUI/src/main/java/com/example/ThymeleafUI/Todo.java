package com.example.ThymeleafUI;

import java.io.Serializable;

public class Todo implements Serializable{

    public String name;
    public int priority;

    public Todo(){}

    public Todo(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public Todo(String name) {
        this.name = name;
        this.priority = 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}

