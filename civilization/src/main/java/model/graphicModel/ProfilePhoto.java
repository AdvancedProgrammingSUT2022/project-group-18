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
    //private Image image;
    private static ArrayList<ProfilePhoto> photos = new ArrayList<>();
    public ProfilePhoto(String name) throws IOException {
        super(200, 200);
        this.name = name;
        //this.image = new Image(getClass().getResource("/images/"+name+".jpg").toExternalForm());
        this.setFill(new ImagePattern(new Image(getClass().getResource("/images/" + name + ".jpg").toExternalForm())));
        this.getStyleClass().add("photo");
        photos.add(this);
    }

    public String getName() {
        return name;
    }

    public static ProfilePhoto getPhotoByName(String name) {
        for (ProfilePhoto photo : photos) {
            if(photo.getName().equals(name))
                return photo;
        }
        return null;
    }


}
