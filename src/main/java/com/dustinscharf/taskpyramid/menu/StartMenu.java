package com.dustinscharf.taskpyramid.menu;

import javafx.stage.Stage;

public class StartMenu implements Menu {
    private static final String FXGL_FILE_PATH = "/StartMenu.fxml";

    @Override
    public boolean show(Stage stage) {
        stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        stage.show();
        return true;
    }

    // TODO create gui as fxgl file

    // TODO create button listeners
}
