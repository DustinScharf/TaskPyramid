package com.dustinscharf.taskpyramid.gui.switchable.game;

import com.dustinscharf.taskpyramid.game.Game;
import com.dustinscharf.taskpyramid.game.SampleGameCreator;
import com.dustinscharf.taskpyramid.game.task.Task;
import com.dustinscharf.taskpyramid.gui.switchable.Switchable;
import com.dustinscharf.taskpyramid.gui.switchable.menu.StartMenuGui;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GameGui implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxgl/Game.fxml";

    private Stage stage;

    @FXML
    private Button task1Button;

    @FXML
    private Button task2Button;

    @FXML
    private Button task3Button;

    @FXML
    private TextArea taskTextArea;

    @FXML
    private Button backButton;

    private Game game;

    @Override
    public boolean show(Stage stage) {
        this.stage = stage;
        this.stage.setScene(FXGLLoader.toControlledScene(FXGL_FILE_PATH, this));
        this.init();
        this.stage.show();
        return true;
    }

    private void init() {
        this.game = SampleGameCreator.createSampleGame();

        this.task1Button.setOnAction(actionEvent -> this.task1ButtonClicked());
        this.task2Button.setOnAction(actionEvent -> this.task2ButtonClicked());
        this.task3Button.setOnAction(actionEvent -> this.task3ButtonClicked());

        this.backButton.setOnAction(actionEvent -> this.backButtonClicked());
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
    private void task1ButtonClicked() {
        Task task1 = this.game.getTasks().getTask(0);
        this.taskTextArea.setText(task1.getTaskText());
    }

    private void task2ButtonClicked() {
        Task task2 = this.game.getTasks().getTask(1);
        this.taskTextArea.setText(task2.getTaskText());
    }

    private void task3ButtonClicked() {
        Task task3 = this.game.getTasks().getTask(2);
        this.taskTextArea.setText(task3.getTaskText());
    }

    private void backButtonClicked() {
        new StartMenuGui().show(this.stage);
    }
}
