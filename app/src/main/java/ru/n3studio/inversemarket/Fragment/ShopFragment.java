package ru.n3studio.inversemarket.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.n3studio.inversemarket.Api.Shops;
import ru.n3studio.inversemarket.Api.UserClient;
import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_main_rv;
import ru.n3studio.inversemarket.Inf_supermarket_Activity;
import ru.n3studio.inversemarket.R;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list;
import ru.n3studio.inversemarket.additional.RecyclerItemClickListener;


public class ShopFragment extends Fragment implements Callback<ResponseBody> {

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
    private static String s = "Token 201fde2f630ae9246e2b6e42f2c301246e5854dc";
    Shops[] list_shops;

    RecyclerView recyclerView;
    ArrayList<recycleview_list> recycleview_lists;
    Adapter_for_main_rv adapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_shop, null, true);
        icon_swich();

        recyclerView = v.findViewById(R.id.rv_main_supermarket);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
        recycleview_lists = new ArrayList<recycleview_list>();
//        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
//        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
//        recycleview_lists.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
        internet_get_inf();
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(v.getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        System.out.println(position+"позиция");
                        Intent intent = new Intent(v.getContext(), Inf_supermarket_Activity.class);
                        intent.putExtra("name", list_shops[position].getName());
                        intent.putExtra("url_img", list_shops[position].getCover());
                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

//        RecyclerView recyclerView2 = v.findViewById(R.id.rv_main_cafe);
//        recyclerView2.setHasFixedSize(true);
//        recyclerView2.setLayoutManager(new GridLayoutManager(v.getContext(), 2));
//        ArrayList<recycleview_list> recycleview_lists2 = new ArrayList<recycleview_list>();
//        recycleview_lists2.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
//        recycleview_lists2.add(new recycleview_list(R.drawable.ic_launcher_background, "от 45 мин"));
//        Adapter_for_main_rv adapter2 = new Adapter_for_main_rv(recycleview_lists2, v.getContext());
//        recyclerView2.setAdapter(adapter2);




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

    public void internet_get_inf(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://market.inverse-team.store/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        UserClient userClient = retrofit.create(UserClient.class);
        Call<ResponseBody> call = userClient.getShops(s);
        call.enqueue(this);


    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {
            try {

//                        System.out.println(response.body().string() + "asfggggggggggg");
                JSONArray jsonArray = new JSONArray(response.body().string()+"");
                list_shops = new Shops[jsonArray.length()];
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject cover = jsonArray.getJSONObject(i);
                    list_shops[i] = (new Shops(cover.getInt("id"), cover.getString("cover"), cover.getString("name"), new Shops.Category(cover.getJSONObject("category").getInt("id"), cover.getJSONObject("category").getString("name"))));
                    new DownloadImageTask()
                            .execute(cover.getString("cover"));

                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {


        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            try {
                recycleview_lists.add(new recycleview_list(new BitmapDrawable(getResources(), result), "от 45 мин"));
                adapter = new Adapter_for_main_rv(recycleview_lists, v.getContext());
                recyclerView.setAdapter(adapter);
            }catch (Exception e){
                return;
            }

        }

    }


}