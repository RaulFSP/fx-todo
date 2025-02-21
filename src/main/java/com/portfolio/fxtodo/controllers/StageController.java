package com.portfolio.fxtodo.controllers;

import com.portfolio.fxtodo.stages.MainStage;
import javafx.fxml.FXMLLoader;

public class StageController {

    private MainStage mainStage;
    private FXMLLoader loader = new FXMLLoader();
    public StageController(){
        this.mainStage = new MainStage();
    }
}
