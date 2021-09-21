package com.dustinscharf.taskpyramid.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class FXGLLoader {
    public static Scene toControlledScene(Menu controllerMenu, String fxglFilePath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FXGLLoader.class.getResource(fxglFilePath));

        fxmlLoader.setController(controllerMenu);

        return new Scene(fxmlLoader.load());
    }
}
