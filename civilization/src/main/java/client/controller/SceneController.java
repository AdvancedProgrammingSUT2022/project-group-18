package client.controller;

import client.view.Database;
import javafx.scene.Scene;

import java.util.Stack;

public class SceneController {
    private static final Stack<Scene> scenes = new Stack<>();
    private static Object currentController;

    public static void push(Scene scene, Object currentController) {
        scenes.push(scene);
        SceneController.currentController = currentController;
        Database.getInstance().getStage().setScene(scene);
    }

    public static void pop() {
        scenes.pop();
        Scene top = scenes.peek();
        Database.getInstance().getStage().setScene(top);
    }

    public static Object getController() {
        return currentController;
    }
}

