package com.portfolio.fxtodo.stages;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainStage extends Stage {

    public MainStage(Scene scene){
        setScene(scene);
        setTitle("Todo App");
        setMinHeight(480);
        setMinWidth(640);
        show();
    }


}
