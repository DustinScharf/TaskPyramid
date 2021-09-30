package com.dustinscharf.taskpyramid.gui.switchable.menu;

import com.dustinscharf.taskpyramid.gui.Switchable;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartMenu implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxgl/StartMenu.fxml";
    private static final String CSS_FILE_PATH = "/css/StartMenu.css";

    @FXML
    private Label taskPyramideHeadlineLabel;

    @FXML
    private Button playButton;

    @FXML
    private Button createGameButton;

    @FXML
    private Button exitButton;

    @Override
    public boolean show(Stage stage) {
        Scene scene = FXGLLoader.toControlledScene(FXGL_FILE_PATH, this);
        scene.getStylesheets().add(CSS_FILE_PATH);
        stage.setScene(scene);
        this.init();
        stage.show();
        return true;
    }

    private void init() {
        this.playButton.setOnAction(actionEvent -> this.playButtonClicked());
        this.createGameButton.setOnAction(actionEvent -> this.createGameButtonClicked());
        this.exitButton.setOnAction(actionEvent -> this.exitButtonClicked());
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    private void playButtonClicked() {
        // TODO
    }

    private void createGameButtonClicked() {
        // TODO
    }

    private void exitButtonClicked() {
        // TODO
    }

}
