package com.dustinscharf.taskpyramid.game;

import com.dustinscharf.taskpyramid.game.task.Tasks;

public class Game {
    private Tasks tasks;

    public Game() {
        this(new Tasks());
    }

    public Game(Tasks tasks) {
        this.tasks = tasks;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }
}
