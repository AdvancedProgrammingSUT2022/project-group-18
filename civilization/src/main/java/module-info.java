module civilization {
        requires javafx.controls;
        requires javafx.fxml;
        requires com.google.gson;

        opens controller to javafx.fxml;
        opens enums to javafx.fxml;
        opens model to javafx.fxml;
        opens view to javafx.fxml;
        opens civilization to javafx.fxml;
        exports civilization;
        opens model.improvements to javafx.fxml;
        opens model.unit to javafx.fxml;
        opens model.techs to javafx.fxml;
        opens model.Resource to javafx.fxml;
}