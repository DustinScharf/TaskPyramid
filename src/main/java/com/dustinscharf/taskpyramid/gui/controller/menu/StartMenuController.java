package com.dustinscharf.taskpyramid.gui.controller.menu;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import javafx.fxml.FXML;

public class StartMenuController extends BaseController {
    // TODO

    @FXML
    private void playButtonClicked() {
        super.sceneManager.switchScene("/fxml/game/Game.fxml");
    }
}
