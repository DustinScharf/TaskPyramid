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
    private Button task1Button;

    @FXML
    private Button task2Button;

    @FXML
    private Button task3Button;

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
        this.task1Button.setOnAction(actionEvent -> this.task1ButtonClicked());
        this.task2Button.setOnAction(actionEvent -> this.task2ButtonClicked());
        this.task3Button.setOnAction(actionEvent -> this.task3ButtonClicked());
        this.backButton.setOnAction(actionEvent -> this.backButtonClicked());
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    private void task1ButtonClicked() {
        // TODO
    }

    private void task2ButtonClicked() {
        // TODO
    }

    private void task3ButtonClicked() {
        // TODO
    }

    private void backButtonClicked() {
        new StartMenu().show(this.stage);
    }
}
