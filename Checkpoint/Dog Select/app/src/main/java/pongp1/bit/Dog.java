package pongp1.bit;

import android.graphics.drawable.Drawable;

public class Dog {

    private String name;
    private Drawable image;

    Dog(String name, Drawable image){
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }
}