package com.portfolio.fxtodo;

import com.portfolio.fxtodo.stages.MainStage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {


        Optional<URL> fxml = Optional.ofNullable(getClass().getResource("/com/portfolio/fxtodo/main.fxml"));
        MainStage mainStage;
        if(fxml.isPresent()){
            Parent root = FXMLLoader.load(fxml.get());
            mainStage = new MainStage(new Scene(root));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
