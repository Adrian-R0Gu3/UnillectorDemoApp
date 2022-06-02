package com.example.unillectordemoapp;

public class imageModel {

    String imageURL;
    String type;
    String description;
    String hp;
    String Resistance;
    String rc;//retreat cost
    String weakness;

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getHp() {

        return hp;
    }

    public void setHp(String hp) {

        this.hp = hp;
    }

    public String getResistance() {

        return Resistance;
    }

    public void setResistance(String resistance) {

        Resistance = resistance;
    }

    public String getRc() {

        return rc;
    }

    public void setRc(String rc) {

        this.rc = rc;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {

        this.weakness = weakness;
    }

    public String getImageURL()
    {

        return imageURL;
    }

    public void setImageURL(String imageURL)
    {

        this.imageURL = imageURL;
    }
}
