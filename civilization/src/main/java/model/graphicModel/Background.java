package model.graphicModel;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Background extends Rectangle {
    private static Background background;
    public static Background getInstance() {
        if(background == null)
            background = new Background();
        return background;
    }

    public Background() {
        super(1080, 720);
        this.setX(0);
        this.setY(0);
    }

    public void setAnimation(String url) {
        this.setFill(new ImagePattern(new Image(Background.class.getResource(url).toExternalForm())));
    }
}
