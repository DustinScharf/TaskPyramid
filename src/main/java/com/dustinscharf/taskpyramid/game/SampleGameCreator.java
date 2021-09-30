package com.dustinscharf.taskpyramid.game;

import com.dustinscharf.taskpyramid.game.task.Task;
import com.dustinscharf.taskpyramid.game.task.Tasks;

public class SampleGameCreator {
    public static Game createSampleGame() {
        Game game = new Game();

        Tasks tasks = new Tasks();
        tasks.addTask(new Task("Go crazy"));
        tasks.addTask(new Task("Go insane"));
        tasks.addTask(new Task("Go eccentric"));

        game.setTasks(tasks);

        return game;
    }
}
