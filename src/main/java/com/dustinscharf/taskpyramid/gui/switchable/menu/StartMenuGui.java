package com.dustinscharf.taskpyramid.gui.switchable.menu;

import com.dustinscharf.taskpyramid.gui.switchable.Switchable;
import com.dustinscharf.taskpyramid.gui.switchable.game.GameGui;
import com.dustinscharf.taskpyramid.gui.util.Alerter;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StartMenuGui implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxml/StartMenu.fxml";
    private static final String CSS_FILE_PATH = "/css/StartMenu.css";

    private Stage stage;

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
        this.stage = stage;
        Scene scene = FXGLLoader.toControlledScene(FXGL_FILE_PATH, this);
        scene.getStylesheets().add(CSS_FILE_PATH);
        this.stage.setScene(scene);
        this.init();
        this.stage.show();
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
        new GameGui().show(this.stage);
    }

    private void createGameButtonClicked() {
        Alerter.sendInfoAlert("Only pre created games supported yet.");
    }

    private void exitButtonClicked() {
        this.stage.close();
    }

}
