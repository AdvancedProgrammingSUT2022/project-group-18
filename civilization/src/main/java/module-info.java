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

    opens Chatserver.Model to  com.google.gson ;
    opens client to javafx.fxml;
    opens client.controller to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens enums to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.model to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
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
    opens client.model.improvements to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.model.unit to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.model.techs to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.model.Resource to javafx.fxml, com.google.gson, javafx.graphics , javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens client.model.graphicModel to javafx.fxml, com.google.gson, javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;
    opens server to javafx.fxml, com.google.gson, javafx.web, javafx.controls,
            org.controlsfx.controls, com.dlsc.formsfx, validatorfx,
            org.kordamp.ikonli.javafx, org.kordamp.bootstrapfx.core,
            eu.hansolo.tilesfx, javafx.media;



    exports client.model.graphicModel;
    exports client.model.trrain;
    exports client.model.improvements;
    exports client.model.unit;
    exports client.model.techs;
    exports client.model.Resource;
    exports client.model;
    exports enums;
    exports client;
    exports client.civilization;
    exports client.controller;
    exports client.view;
    exports client.controller.unitactoins;
    exports Chatserver;
    exports Chatserver.Controller;
    exports Chatserver.Model;

}