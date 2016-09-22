package org.khmeracademy.androidvolleyexample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ChivonChhai on 9/22/2016.
 */

public class Product {
    @SerializedName("id")
    private  int id;
    @SerializedName("name")
    private  String name;
    @SerializedName("qty")
    private  int qty;
    @SerializedName("price")
    private  double price;
    @SerializedName("image")
    private  String  image;
    public Product(int id, String name, int qty, double price, String image) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.image = image;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
