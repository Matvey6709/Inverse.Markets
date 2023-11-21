package ru.n3studio.inversemarket.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;

import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list2;
import ru.n3studio.inversemarket.R;

public class ProductShopsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_shops);

//        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = (RecyclerView) findViewById(R.id.eat1_rv1);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        ArrayList<recycleview_list2> recycleview_lists2 = new ArrayList<recycleview_list2>();
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "от 45 мин"));
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "от 45 мин"));
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "от 45 мин"));
    }
}