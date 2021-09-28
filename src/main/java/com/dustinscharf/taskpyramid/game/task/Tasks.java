package com.dustinscharf.taskpyramid.game.task;

import java.util.LinkedList;

public class Tasks {
    private LinkedList<Task> tasks;

    public Tasks() {
        this.tasks = new LinkedList<>();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task getTask(int taskNumber) {
        return this.tasks.get(taskNumber);
    }
}
