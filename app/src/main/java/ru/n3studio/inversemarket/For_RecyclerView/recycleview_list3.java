package ru.n3studio.inversemarket.For_RecyclerView;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleview_list3 {
    String categories;
    Adapter_for_supermarket_tovar tovar;

    public recycleview_list3(String categories, Adapter_for_supermarket_tovar tovar) {
        this.categories = categories;
        this.tovar = tovar;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Adapter_for_supermarket_tovar getTovar() {
        return tovar;
    }

    public void setTovar(Adapter_for_supermarket_tovar tovar) {
        this.tovar = tovar;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
