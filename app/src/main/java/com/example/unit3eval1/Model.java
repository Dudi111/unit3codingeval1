package com.example.unit3eval1;

public class Model {
    private int image;
    private String title;
    private String subtitle;

    public Model(int image, String title, String subtitle) {
        this.image = image;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}
