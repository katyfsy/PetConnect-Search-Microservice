package com.vmware.CapstoneSearch;

public class Zip {
    public String zip_code;
    public String distance;
    public String city;
    public String state;

    public Zip() {
    }

    @Override
    public String toString() {
        return "Zip{" +
                "zip_code='" + zip_code + '\'' +
                ", distance='" + distance + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Zip(String zip_code, String distance, String city, String state) {
        this.zip_code = zip_code;
        this.distance = distance;
        this.city = city;
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
