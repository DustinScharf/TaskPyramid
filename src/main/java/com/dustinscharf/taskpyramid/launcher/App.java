package com.dustinscharf.taskpyramid.launcher;

import com.dustinscharf.taskpyramid.menu.StartMenu;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TaskPyramid");

        new StartMenu().show(stage);
    }
}
