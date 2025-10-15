module Projeto {
    requires javafx.controls;
    requires javafx.fxml;
    opens Controller to javafx.fxml;
    exports Application;
}