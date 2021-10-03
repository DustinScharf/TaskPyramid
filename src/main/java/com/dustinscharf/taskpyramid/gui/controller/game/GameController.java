package com.dustinscharf.taskpyramid.gui.controller.game;

import com.dustinscharf.taskpyramid.game.SampleGameCreator;
import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController extends BaseController {
    // TODO

    @FXML
    public void exitButtonClicked() {
        super.sceneManager.switchToPreviousScene();
    }
}
