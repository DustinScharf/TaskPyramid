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

    // TODO old init:
//    private void init() {
//        this.game = SampleGameCreator.createSampleGame();
//
//        int taskAmount = this.game.getTasks().getAmount();
//        for (int taskNumber = 0; taskNumber < taskAmount; ++taskNumber) {
//            Button button = new Button("Task " + (taskNumber + 1));
//            // TODO add task button listeners
//            this.taskButtonsHBox.getChildren().add(button);
//        }
//    }
}
