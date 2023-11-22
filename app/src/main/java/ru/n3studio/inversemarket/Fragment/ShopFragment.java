package ru.n3studio.inversemarket.Fragment;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_main_rv;
import ru.n3studio.inversemarket.R;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list;


public class ShopFragment extends Fragment {

    View v;

    ColorStateList def1;
    ColorStateList def2;
    AppCompatButton item1, item2, select;
    float startX = 0;
    float endX = 0;
    Drawable icon1;
    Drawable icon1_gr;
    Drawable icon2;
    Drawable icon2_gr;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_shop, null, true);
        icon_swich();

        RecyclerView recyclerView = v.findViewById(R.id.rv_main_supermarket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
        ArrayList<recycleview_list> recycleview_lists = new ArrayList<recycleview_list>();
        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));


        Adapter_for_main_rv adapter = new Adapter_for_main_rv(recycleview_lists, v.getContext());
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = v.findViewById(R.id.rv_main_cafe);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
        ArrayList<recycleview_list> recycleview_lists2 = new ArrayList<recycleview_list>();
        recycleview_lists2.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
        recycleview_lists2.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));


        Adapter_for_main_rv adapter2 = new Adapter_for_main_rv(recycleview_lists2, v.getContext());
        recyclerView2.setAdapter(adapter2);




        return v;
    }

    public void icon_swich(){
        item1 = v.findViewById(R.id.ButtonTest1);
        item2 = v.findViewById(R.id.ButtonTest2);

        item1.setOnClickListener(this::onClick);
        item2.setOnClickListener(this::onClick);

        select = v.findViewById(R.id.select);
        def1 = item2.getTextColors();
        def2 = item1.getTextColors();
        icon1 = getResources().getDrawable(R.drawable.bag_orn_top_buttons);
        icon1.setBounds(0, 0, icon1.getIntrinsicWidth(), icon1.getIntrinsicHeight());
        icon1_gr = getResources().getDrawable(R.drawable.bag_grey_top_buttons);
        icon1_gr.setBounds(0, 0, icon1_gr.getIntrinsicWidth(), icon1_gr.getIntrinsicHeight());
        icon2 = getResources().getDrawable(R.drawable.home_orn_top_buttons);
        icon2.setBounds(0, 0, icon2.getIntrinsicWidth(), icon2.getIntrinsicHeight());
        icon2_gr = getResources().getDrawable(R.drawable.home_grey_top_buttons);
        icon2_gr.setBounds(0, 0, icon2_gr.getIntrinsicWidth(), icon2_gr.getIntrinsicHeight());
    }


    public void onClick(View view) {
        if (view.getId() == R.id.ButtonTest1) {
            startX = item1.getX();
            select.animate().x(startX).setDuration(100);
            item1.setTextColor(def2);
            item1.setCompoundDrawablesWithIntrinsicBounds(icon1, null, null, null);
            item2.setTextColor(def1);
            item2.setCompoundDrawablesWithIntrinsicBounds(icon2_gr, null, null, null);
        } else if (view.getId() == R.id.ButtonTest2) {
            select.animate().x(0).setDuration(100);
            item1.setTextColor(def1);
            item1.setCompoundDrawablesWithIntrinsicBounds(icon1_gr, null, null, null);
            item2.setTextColor(def2);
            item2.setCompoundDrawablesWithIntrinsicBounds(icon2, null, null, null);
            endX = item2.getX();
            select.animate().x(endX).setDuration(100);
        }
    }


}