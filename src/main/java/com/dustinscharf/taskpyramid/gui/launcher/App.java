package com.dustinscharf.taskpyramid.gui.launcher;

import com.dustinscharf.taskpyramid.gui.switchable.menu.StartMenuGui;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TaskPyramid");

        new StartMenuGui().show(stage);
    }
}
