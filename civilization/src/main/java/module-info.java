module civilization {
        requires javafx.controls;
        requires javafx.fxml;
        requires com.google.gson;

        opens controller to javafx.fxml, com.google.gson;
        opens enums to javafx.fxml , com.google.gson;
        opens model to javafx.fxml, com.google.gson;
        opens view to javafx.fxml , com.google.gson;
        opens civilization to javafx.fxml;
        opens controller.unitactoins to javafx.fxml , com.google.gson;
        opens model.improvements to javafx.fxml;
        opens model.unit to javafx.fxml;
        opens model.techs to javafx.fxml;
        opens model.Resource to javafx.fxml;

        exports civilization;
        exports controller;
        exports enums;
        exports model;
        exports view;
        exports model.trrain;
        exports model.improvements;
        exports model.unit;
        exports model.techs;
        exports model.Resource;
        exports controller.unitactoins;
}