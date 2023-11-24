package ru.n3studio.inversemarket.For_RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleview_list2 {
    String img;
    String price;
    String mass;
    String name;

    public recycleview_list2(String img, String price, String mass, String name) {
        this.img = img;
        this.price = price;
        this.mass = mass;
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
