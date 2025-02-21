module com.portfolio.fxtodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    opens com.portfolio.fxtodo.controllers to javafx.fxml;
    opens com.portfolio.fxtodo to javafx.fxml;
    exports com.portfolio.fxtodo;
}