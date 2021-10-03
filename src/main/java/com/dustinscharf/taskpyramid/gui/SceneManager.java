package com.dustinscharf.taskpyramid.gui;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class SceneManager {
    private final Stage stage;

    private final Map<String, Scene> scenes;

    private final SceneHistory sceneHistory;

    public class SceneHistory {
        private final List<Scene> sceneHistoryList;
        private ListIterator<Scene> sceneHistoryListIterator;

        private SceneHistory() {
            this.sceneHistoryList = new LinkedList<>();
            this.sceneHistoryListIterator = this.sceneHistoryList.listIterator();
        }

        private void append(Scene scene) {
            this.sceneHistoryList.add(scene);
            this.sceneHistoryListIterator = this.sceneHistoryList.listIterator(this.sceneHistoryList.size() - 1);
        }

        public boolean hasNextScene() {
            return this.sceneHistoryListIterator.hasNext();
        }

        public Scene getNextScene() {
            if (!this.hasNextScene()) {
                throw new NullPointerException("No next scene in scene history");
            }

            return this.sceneHistoryListIterator.next();
        }

        public boolean hasPreviousScene() {
            return this.sceneHistoryListIterator.hasPrevious();
        }

        public Scene getPreviousScene() {
            if (!this.hasPreviousScene()) {
                throw new NullPointerException("No previous scene in scene history");
            }

            return this.sceneHistoryListIterator.previous();
        }
    }

    public SceneManager(Stage stage) {
        if (stage == null) {
            throw new IllegalArgumentException("Stage stage can not be null");
        }

        this.scenes = new HashMap<>();
        this.stage = stage;
        this.sceneHistory = new SceneHistory();
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
        this.sceneHistory.append(scene);
        this.stage.setScene(scene);
    }

    public SceneHistory getSceneHistory() {
        return this.sceneHistory;
    }
}
