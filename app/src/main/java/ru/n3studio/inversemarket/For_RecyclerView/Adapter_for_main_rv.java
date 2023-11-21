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

public class Adapter_for_main_rv extends RecyclerView.Adapter<Adapter_for_main_rv.ViewHolder> {

    private ArrayList<recycleview_list> recycleview_lists;
    private Context context;

    public Adapter_for_main_rv(ArrayList<recycleview_list> recycleview_lists, Context context) {
        this.recycleview_lists = recycleview_lists;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter_for_main_rv.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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
//    Context context;
//
//    int[] images;
//    String[] times;
//    String[] titels;
//
//    public Adapter_for_main_rv(Context context, int[] images, String[] times, String[] titels) {
//        super(context, R.layout.supermarket_lv_main, titels);
//        this.context = context;
//        this.images = images;
//        this.times = times;
//        this.titels = titels;
//
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View row = layoutInflater.inflate(R.layout.supermarket_lv_main, parent, false);
//        ImageView imageView = row.findViewById(R.id.imageView_for_main_lv);
//        TextView textView = row.findViewById(R.id.text_main_for_lv);
//
//        imageView.setImageResource(images[position]);
//        textView.setText("От "+ times[position]+" мин");
//
//
//        return row;
//    }
}
