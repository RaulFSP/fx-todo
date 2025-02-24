package com.portfolio.fxtodo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StageManager {
    private static final Logger LOGGER = Logger.getLogger(StageManager.class.getName());
    private Stage mainStage;

    public StageManager(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void showMainStage() {
        try {

            Scene scene = new Scene(new FXMLLoader(getClass().getResource("views/main.fxml")).load());
            mainStage.setScene(scene);
            mainStage.setTitle("TODO");
            mainStage.setMinHeight(480);
            mainStage.setMinWidth(640);
            mainStage.show();

        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public Stage getMainStage() {
        return mainStage;
    }
}
