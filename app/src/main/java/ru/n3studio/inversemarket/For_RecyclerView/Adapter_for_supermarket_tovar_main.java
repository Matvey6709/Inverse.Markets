package ru.n3studio.inversemarket.For_RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.n3studio.inversemarket.AbsolutefitLayourManager;
import ru.n3studio.inversemarket.R;

public class Adapter_for_supermarket_tovar_main extends RecyclerView.Adapter<Adapter_for_supermarket_tovar_main.ViewHolder>{
    private ArrayList<recycleview_list3> recycleview_lists;
    private Context context;

    public Adapter_for_supermarket_tovar_main(ArrayList<recycleview_list3> recycleview_lists, Context context) {
        this.recycleview_lists = recycleview_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_for_supermarket_tovar_main.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_res_v, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categories.setText(recycleview_lists.get(position).getCategories());
        holder.tovar.setAdapter(recycleview_lists.get(position).getTovar());

    }




    @Override
    public int getItemCount() {
        return recycleview_lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categories;
        RecyclerView tovar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categories = itemView.findViewById(R.id.eat_text);
            tovar = itemView.findViewById(R.id.eat1_rv);
            AbsolutefitLayourManager layourManager = new AbsolutefitLayourManager(context, 1, RecyclerView.HORIZONTAL, false);
            layourManager.generateDefaultLayoutParams();
            tovar.setLayoutManager(layourManager);
        }
    }
}
