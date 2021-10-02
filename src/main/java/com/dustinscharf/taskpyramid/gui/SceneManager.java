package com.dustinscharf.taskpyramid.gui;

import com.dustinscharf.taskpyramid.gui.controller.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private final Stage rootStage;

    private final Map<String, Scene> scenes = new HashMap<>();

    public SceneManager(Stage rootStage) {
        if (rootStage == null) {
            throw new IllegalArgumentException("Stage rootStage can not be null");
        }
        this.rootStage = rootStage;
    }

    // TODO
    public void switchScene(String fxmlFilePath) {
        Scene scene = scenes.computeIfAbsent(fxmlFilePath, fxmlFilePathTemp -> {
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
        rootStage.setScene(scene);
    }
}
