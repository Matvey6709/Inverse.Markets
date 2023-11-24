package ru.n3studio.inversemarket.For_RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.tovar_in_supermarket, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.with(context)
                .load(recycleview_lists.get(position).getImg())
                .placeholder(R.drawable.ic_launcher_background).error(R.drawable.back_select)
                .into(holder.imageView);
//        if(recycleview_lists.get(position).getImg() != null){
//            holder.imageView.setImageDrawable(recycleview_lists.get(position).getImg());
//        }else {
//            holder.imageView.setImageDrawable(context.getDrawable(R.drawable.ic_launcher_background));
//        }

        holder.price.setText(recycleview_lists.get(position).getPrice());
        holder.mass.setText(recycleview_lists.get(position).getMass());
        holder.name.setText(recycleview_lists.get(position).getName());
    }




    @Override
    public int getItemCount() {
        return recycleview_lists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price;
        TextView mass;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_tovar);
            price = itemView.findViewById(R.id.price);
            mass = itemView.findViewById(R.id.mass);
            name = itemView.findViewById(R.id.name);
        }
    }
}
