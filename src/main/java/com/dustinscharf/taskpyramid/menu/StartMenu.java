package com.dustinscharf.taskpyramid.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartMenu implements Menu {
    private static final String FXGL_FILE_PATH = "/fxgl/StartMenu.fxml";

    @FXML
    private Button playButton;

    @FXML
    private Button createGameButton;

    @Override
    public boolean show(Stage stage) {
        stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        stage.show();
        return true;
    }

    // TODO create gui as fxgl file

    // TODO create button listeners
}
