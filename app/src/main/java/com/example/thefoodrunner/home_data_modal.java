package com.example.thefoodrunner;

public class home_data_modal {
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String price;
    private String name;
    private String imgUrl;

    public home_data_modal() {
    }
    public home_data_modal(String name, String imgUrl, String price) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.price=price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
