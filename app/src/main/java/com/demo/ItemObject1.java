package com.demo;

public class ItemObject1 {

    private String name;
    private int photo;
    private String description;
    

    public ItemObject1(String name, int photo, String description) {
        this.name = name;
        this.photo = photo;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
