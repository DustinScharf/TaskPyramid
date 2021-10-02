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
    private ListIterator<Scene> sceneHistoryListIterator;

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
        this.sceneHistoryListIterator = this.sceneHistoryList.listIterator(this.sceneHistoryList.size() - 1);
        this.stage.setScene(scene);
    }

    public boolean hastNextScene() {
        return this.sceneHistoryListIterator.hasNext();
    }

    public void switchToNextScene() {
        if (!this.hastNextScene()) {
            throw new NullPointerException("No next scene in scene history");
        }

        this.stage.setScene(this.sceneHistoryListIterator.next());
    }

    public boolean hasPreviousScene() {
        return this.sceneHistoryListIterator.hasPrevious();
    }

    public void switchToPreviousScene() {
        if (!this.hasPreviousScene()) {
            throw new NullPointerException("No previous scene in scene history");
        }

        this.stage.setScene(this.sceneHistoryListIterator.previous());
    }
}
