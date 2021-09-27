package com.dustinscharf.taskpyramid.menu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartMenu implements Menu {
    private static final String FXGL_FILE_PATH = "/fxgl/StartMenu.fxml";

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
        stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        this.init();
        stage.show();
        return true;
    }

    private void init() {
        this.playButton.setOnAction(actionEvent -> this.playButtonClicked());
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    private void playButtonClicked() {
        System.out.println("playButtonClicked");
    }

}
