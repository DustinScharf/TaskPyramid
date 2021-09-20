package com.dustinscharf.taskpyramid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox rootHBox = new HBox();
        Scene startScene = new Scene(rootHBox);
        stage.setScene(startScene);
        stage.show();
    }
}
