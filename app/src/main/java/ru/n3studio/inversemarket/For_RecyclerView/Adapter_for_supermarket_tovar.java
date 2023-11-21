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

import ru.n3studio.inversemarket.R;

public class Adapter_for_supermarket_tovar extends RecyclerView.Adapter<Adapter_for_supermarket_tovar.ViewHolder>{
    private ArrayList<recycleview_list2> recycleview_lists;
    private Context context;

    public Adapter_for_supermarket_tovar(ArrayList<recycleview_list2> recycleview_lists, Context context) {
        this.recycleview_lists = recycleview_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_for_supermarket_tovar.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.supermarket_lv_main, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(recycleview_lists.get(position).getImg());
        holder.textView.setText(recycleview_lists.get(position).getTime());
    }




    @Override
    public int getItemCount() {
        return recycleview_lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView_for_main_lv);
            textView = itemView.findViewById(R.id.text_main_for_lv);
        }
    }
}
