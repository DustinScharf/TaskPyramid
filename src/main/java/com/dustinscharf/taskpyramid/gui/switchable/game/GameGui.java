package com.dustinscharf.taskpyramid.gui.switchable.game;

import com.dustinscharf.taskpyramid.game.Game;
import com.dustinscharf.taskpyramid.game.SampleGameCreator;
import com.dustinscharf.taskpyramid.gui.switchable.Switchable;
import com.dustinscharf.taskpyramid.gui.switchable.menu.StartMenuGui;
import com.dustinscharf.taskpyramid.gui.util.FXGLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;

public class GameGui implements Switchable {
    private static final String FXGL_FILE_PATH = "/fxml/Game.fxml";
    private static final String CSS_FILE_PATH = "/css/overall-style.css";

    @FXML
    private HBox taskButtonsHBox;

    @FXML
    private TextArea taskTextArea;

    @FXML
    private Button backButton;

    private Stage stage;

    private List<Button> taskButtons;

    private Game game;

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
        this.game = SampleGameCreator.createSampleGame();

        int taskAmount = this.game.getTasks().getAmount();
        for (int taskNumber = 0; taskNumber < taskAmount; ++taskNumber) {
            Button button = new Button("Task " + (taskNumber + 1));
            // TODO add task button listeners
            this.taskButtonsHBox.getChildren().add(button);
        }

        this.backButton.setOnAction(actionEvent -> this.backButtonClicked());
    }

    //////////////////////
    // Button Listeners //
    //////////////////////
//    private void task1ButtonClicked() {
//        Task task1 = this.game.getTasks().getTask(0);
//        this.taskTextArea.setText(task1.getTaskText());
//    }

    private void backButtonClicked() {
        new StartMenuGui().show(this.stage);
    }
}
