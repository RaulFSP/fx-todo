package com.portfolio.fxtodo;

import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    private static StageManager manager;

    @Override
    public void start(Stage stage) {
        manager = new StageManager(stage);
        manager.showMainStage();
    }

    public static StageManager getManager() {
        return manager;
    }
}
