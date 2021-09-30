package com.dustinscharf.taskpyramid.gui.util;

import javafx.scene.control.Alert;

public class Alerter {
    public static void sendInfoAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}
