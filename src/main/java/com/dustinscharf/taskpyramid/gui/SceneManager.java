package com.dustinscharf.taskpyramid.gui;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import com.dustinscharf.taskpyramid.util.NavigationList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private final Stage stage;

    private final Map<String, Scene> scenes;

    private final SceneHistory sceneHistory;

    public class SceneHistory {
        private final NavigationList<Scene> sceneHistoryNavigationList;

        private SceneHistory() {
            this.sceneHistoryNavigationList = new NavigationList<>();
        }

        private void append(Scene scene) {
            this.sceneHistoryNavigationList.appendAfterCurrent(scene);
            this.sceneHistoryNavigationList.getIterator().pointToLast();
        }

//        private boolean hasNextScene() {
//            return this.sceneHistoryNavigationList.getIterator().hasNext();
//        }
//
//        private Scene getNextScene() {
//            this.sceneHistoryNavigationList.get
//        }
//
//        public boolean hasPreviousScene() {
//            return this.sceneHistoryNavigationList.getIterator().hasPrevious();
//        }
//
//        public Scene getPreviousScene() {
//            if (!this.hasPreviousScene()) {
//                throw new NullPointerException("No previous scene in scene history");
//            }
//
//            return this.sceneHistoryListIterator.previous();
//        }
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

    public void switchToNextScene() {
        if (!this.sceneHistory.sceneHistoryNavigationList.getIterator().hasNext()) {
            throw new NullPointerException("No next scene in scene history");
        }

        this.stage.setScene(this.sceneHistory.sceneHistoryNavigationList.getIterator().goNext());
    }

    public void switchToPreviousScene() {
        if (!this.sceneHistory.sceneHistoryNavigationList.getIterator().hasPrevious()) {
            throw new NullPointerException("No previous scene in scene history");
        }

        this.stage.setScene(this.sceneHistory.sceneHistoryNavigationList.getIterator().goPrevious());
    }
}
