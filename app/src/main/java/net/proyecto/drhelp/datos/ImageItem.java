package net.proyecto.drhelp.datos;

import android.graphics.Bitmap;

/**
 * Created by choqu_000 on 24/05/2016.
 */
public class ImageItem {

    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
