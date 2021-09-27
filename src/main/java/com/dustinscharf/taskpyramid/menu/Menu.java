package com.dustinscharf.taskpyramid.menu;

import javafx.stage.Stage;

public interface Menu {
    /**
     * Shows this menu on stage
     * <p>
     * This methode should (if necessary) call {@link Menu#init()}
     *
     * @param stage the stage to show this menu on
     * @return true if the menu was shown successfully, false otherwise
     */
    public boolean show(Stage stage);

    /**
     * Initializes all necessary components (like button listeners) for this menu
     */
    public void init();
}
