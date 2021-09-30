package com.dustinscharf.taskpyramid.gui.switchable.game;

import com.dustinscharf.taskpyramid.gui.Switchable;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.stage.Stage;

public class TestMiniGame implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxgl/TestMiniGame.fxml";

    @Override
    public boolean show(Stage stage) {
        stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        this.init();
        stage.show();
        return true;
    }

    private void init() {
        // TODO
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    // TODO
}
