package com.dustinscharf.taskpyramid.menu;

import javafx.stage.Stage;

public class StartMenu implements Menu {
    private static final String FXGL_FILE_PATH = ""/*TODO*/;

    @Override
    public boolean show(Stage stage) {
        stage.setScene(FXGLLoader.toControlledScene(this, FXGL_FILE_PATH));
        return true;
    }

    // TODO create gui as fxgl file
}
