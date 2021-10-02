package com.dustinscharf.taskpyramid.gui;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class SceneManager {
    private final Stage stage;

    private final Map<String, Scene> scenes;

    private final List<Scene> sceneHistoryList;
    private final ListIterator<Scene> sceneHistoryListIterator;

    public SceneManager(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage stage can not be null");
        }

        this.scenes = new HashMap<>();
        this.stage = stage;
        this.sceneHistoryList = new LinkedList<>();
        this.sceneHistoryListIterator = this.sceneHistoryList.listIterator();
    }

    public void switchScene(String fxmlFilePath) {
        Scene scene = this.scenes.computeIfAbsent(fxmlFilePath, fxmlFilePathTemp -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePathTemp));
            try {
                Pane pane = loader.load();
                BaseController controller = loader.getController();
                controller.setSceneManager(this);
                return new Scene(pane);
            } catch (IOException ioException) {
                throw new RuntimeException(ioException);
            }
        });
        this.sceneHistoryList.add(scene);
        this.sceneHistoryListIterator.next();
        this.stage.setScene(scene);
    }

    private void switchToNextScene() {
        if (!this.sceneHistoryListIterator.hasNext()) {
            throw new NullPointerException("No next scene in scene history");
        }

        this.stage.setScene(this.sceneHistoryListIterator.next());
    }

    private void switchToNextPrevious() {
        if (!this.sceneHistoryListIterator.hasPrevious()) {
            throw new NullPointerException("No previous scene in scene history");
        }

        this.stage.setScene(this.sceneHistoryListIterator.previous());
    }
}
