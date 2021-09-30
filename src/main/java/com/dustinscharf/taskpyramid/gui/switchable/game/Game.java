package com.dustinscharf.taskpyramid.gui.switchable.game;

import com.dustinscharf.taskpyramid.gui.switchable.Switchable;
import com.dustinscharf.taskpyramid.gui.switchable.menu.StartMenu;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Game implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxgl/Game.fxml";

    private Stage stage;

    @FXML
    private Button backButton;

    @Override
    public boolean show(Stage stage) {
        this.stage = stage;
        this.stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        this.init();
        this.stage.show();
        return true;
    }

    private void init() {
        this.backButton.setOnAction(actionEvent -> this.backButtonClicked());
        // TODO
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    private void backButtonClicked() {
        new StartMenu().show(this.stage);
    }
    // TODO
}
