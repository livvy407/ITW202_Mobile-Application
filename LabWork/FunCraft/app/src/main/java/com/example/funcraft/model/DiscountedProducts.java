package com.example.funcraft.model;

public class DiscountedProducts {
    Integer id;
    String imageUrl;

    public DiscountedProducts(Integer id, String imageUrl){
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
}
