package project.anhthu.travelinvietnam_app.Domain;

import java.io.Serializable;

public class PopularDomain implements Serializable {
    private String title, location, description, pic;
    private String sun, temperature;
    private boolean bicycle, swim, camping;
    private boolean guide, wifi;
    private int price;
    private double score;

    public PopularDomain(String title, String location, String description, String pic, boolean guide, boolean wifi, int price, double score) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.pic = pic;
        this.guide = guide;
        this.wifi = wifi;
        this.price = price;
        this.score = score;
    }

    public PopularDomain(String sun, String temperature) {
        this.sun = sun;
        this.temperature = temperature;

    }

    public PopularDomain(boolean bicycle, boolean swim, boolean camping) {
        this.bicycle = bicycle;
        this.swim = swim;
        this.camping = camping;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public boolean isBicycle() {
        return bicycle;
    }

    public void setBicycle(boolean bicycle) {
        this.bicycle = bicycle;
    }

    public boolean isSwim() {
        return swim;
    }

    public void setSwim(boolean swim) {
        this.swim = swim;
    }

    public boolean isCamping() {
        return camping;
    }

    public void setCamping(boolean camping) {
        this.camping = camping;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean isGuide() {
        return guide;
    }

    public void setGuide(boolean guide) {
        this.guide = guide;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
