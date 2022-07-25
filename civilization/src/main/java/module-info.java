module civilization {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires com.google.gson;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.media;
    requires java.desktop;
    requires java.logging;

    opens client.controller to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens enums to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.view to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.civilization to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.controller.unitactoins to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model.improvements to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model.unit to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model.techs to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model.Resource to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens model.graphicModel to javafx.fxml, com.google.gson, javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens server to javafx.fxml, com.google.gson, javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;



    exports model.graphicModel;
    exports model.trrain;
    exports model.improvements;
    exports model.unit;
    exports model.techs;
    exports model.Resource;
    exports model;
    exports enums;
    exports client.civilization;
    exports client.controller;
    exports client.view;
    exports client.controller.unitactoins;

}