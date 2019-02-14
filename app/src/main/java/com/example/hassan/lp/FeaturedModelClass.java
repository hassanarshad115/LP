package com.example.hassan.lp;

public class FeaturedModelClass {
    String name,btnText;
    int imageChanger;

    public FeaturedModelClass(String name, String btnText, int imageChanger) {
        this.name = name;
        this.btnText = btnText;
        this.imageChanger = imageChanger;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }

    public int getImageChanger() {
        return imageChanger;
    }

    public void setImageChanger(int imageChanger) {
        this.imageChanger = imageChanger;
    }
}
