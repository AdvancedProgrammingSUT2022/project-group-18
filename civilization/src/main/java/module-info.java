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
}