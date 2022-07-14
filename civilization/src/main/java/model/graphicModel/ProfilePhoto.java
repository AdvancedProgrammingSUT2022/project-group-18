package model.graphicModel;

import com.google.gson.annotations.SerializedName;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

public class ProfilePhoto extends Rectangle {

    @SerializedName("photoName")
    private String name;
    private static ArrayList<ProfilePhoto> photos = new ArrayList<>();

    public ProfilePhoto(String name) throws IOException {
        super(200, 200);
        this.name = name;
        this.setFill(new ImagePattern(new Image(ProfilePhoto.class.getResource("/images/" + name).toExternalForm())));

        this.getStyleClass().add("photo");
        photos.add(this);
    }

    public String getName() {
        return name;
    }




}
