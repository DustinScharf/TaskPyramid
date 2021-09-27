package com.dustinscharf.taskpyramid.menu;

import javafx.stage.Stage;

public interface Menu {
    /**
     * Shows this menu on stage
     * <p>
     * This methode should initialize all necessary components
     *
     * @param stage the stage to show this menu on
     * @return true if the menu was shown successfully, false otherwise
     */
    public boolean show(Stage stage);
}
