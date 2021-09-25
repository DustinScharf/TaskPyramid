package com.dustinscharf.taskpyramid.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class FXGLLoader {
    public static Scene toControlledScene(String fxglFilePath, Menu controllerMenu) {
        FXMLLoader fxmlLoader = new FXMLLoader(FXGLLoader.class.getResource(fxglFilePath));

        fxmlLoader.setController(controllerMenu);

        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Could not find fxgl file " + fxglFilePath);
            System.exit(1);
        }
        return scene;
    }
}
