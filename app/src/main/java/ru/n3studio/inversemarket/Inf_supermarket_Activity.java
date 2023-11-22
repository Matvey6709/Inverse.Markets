package ru.n3studio.inversemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_main_rv;
import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_supermarket_tovar;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list2;

public class Inf_supermarket_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_supermarket);

        RecyclerView recyclerView = findViewById(R.id.eat1_rv1);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        AbsolutefitLayourManager layourManager = new AbsolutefitLayourManager(this, 1, RecyclerView.HORIZONTAL, false);
        layourManager.generateDefaultLayoutParams();
        recyclerView.setLayoutManager(layourManager);
        ArrayList<recycleview_list2> recycleview_lists2 = new ArrayList<recycleview_list2>();
        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));


        Adapter_for_supermarket_tovar adapter = new Adapter_for_supermarket_tovar(recycleview_lists2, this);
        recyclerView.setAdapter(adapter);

        RecyclerView recyclerView2 = findViewById(R.id.eat1_rv2);
        recyclerView2.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));
        AbsolutefitLayourManager layourManager2 = new AbsolutefitLayourManager(this, 1, RecyclerView.HORIZONTAL, false);
        layourManager2.generateDefaultLayoutParams();
        recyclerView2.setLayoutManager(layourManager2);
        ArrayList<recycleview_list2> recycleview_lists22 = new ArrayList<recycleview_list2>();
        recycleview_lists22.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists22.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists22.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists22.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
        recycleview_lists22.add(new recycleview_list2(R.drawable.ic_launcher_background, "230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));


        Adapter_for_supermarket_tovar adapter2 = new Adapter_for_supermarket_tovar(recycleview_lists22, this);
        recyclerView2.setAdapter(adapter2);
    }
}