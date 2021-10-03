package com.dustinscharf.taskpyramid.gui.controller.menu;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import com.dustinscharf.taskpyramid.gui.util.Alerter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class StartMenuController extends BaseController {
    // TODO

    @FXML
    private void playButtonClicked() {
        super.sceneManager.switchScene("/fxml/game/Game.fxml");
    }

    @FXML
    public void createGameButtonClicked() {
        Alerter.sendInfoAlert("Only pre created games are supported yet.");
    }

    @FXML
    public void exitButtonClicked() {
        super.sceneManager.getStage().close();
    }
}
