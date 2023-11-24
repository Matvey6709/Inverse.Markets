package ru.n3studio.inversemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.n3studio.inversemarket.Api.Categories;
import ru.n3studio.inversemarket.Api.Products;
import ru.n3studio.inversemarket.Api.UserClient;
import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_supermarket_tovar;
import ru.n3studio.inversemarket.For_RecyclerView.Adapter_for_supermarket_tovar_main;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list2;
import ru.n3studio.inversemarket.For_RecyclerView.recycleview_list3;
import ru.n3studio.inversemarket.Fragment.ShopFragment;

public class Inf_supermarket_Activity extends AppCompatActivity implements Callback<ResponseBody> {

    Categories[] categories;
    private Products[] products;
    private static String s = "Token 201fde2f630ae9246e2b6e42f2c301246e5854dc";
    RecyclerView recyclerView;
    ArrayList<recycleview_list3> recycleview_lists3 = new ArrayList<recycleview_list3>();

    ArrayList<recycleview_list2> recycleview_lists2 = new ArrayList<recycleview_list2>();
    ImageButton imgButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inf_supermarket);
        imgButtons = findViewById(R.id.back_tovar);
        imgButtons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inf_supermarket_Activity.this, MainActivity.class);
                intent.putExtra("close_reg", true);
                startActivity(intent);
            }
        });
//        recyclerView.setLayoutManager(new LinearLayoutManager(this , RecyclerView.HORIZONTAL, false));

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nameShop = extras.getString("name");
            TextView textShop = findViewById(R.id.textShop);
            textShop.setText(nameShop);
            System.out.println(nameShop);
            String url_img = extras.getString("url_img");
            new LoadImgShop().execute(url_img);
        }

        internet_get();

    }

    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            JSONArray jsonArray = new JSONArray(response.body().string()+"");
            categories = new Categories[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject cover = jsonArray.getJSONObject(i);
                categories[i] = new Categories(cover.getInt("id"), cover.getString("name"));
            }
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl("https://market.inverse-team.store/")
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.build();
            UserClient userClient = retrofit.create(UserClient.class);
            Call<ResponseBody> call2 = userClient.getProducts(s);
            call2.enqueue(new Callback<ResponseBody>() {
//                private Products[] products;
//                private Callback<ResponseBody> init(Products[] products){
//                    this.products = products;
//                    return this;
//                }
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    recyclerView = findViewById(R.id.main_res_products);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(Inf_supermarket_Activity.this, LinearLayoutManager.VERTICAL, false));
                    JSONArray jsonArray = null;
                    try {
                        jsonArray = new JSONArray(response.body().string()+"");
                        products = new Products[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject cover = jsonArray.getJSONObject(i);
                            products[i] = new Products(cover.getInt("id"), cover.getString("cover"), cover.getString("name"),
                                    cover.getString("description"), new Categories(cover.getJSONObject("category").getInt("id"),
                                    cover.getJSONObject("category").getString("name")), cover.getInt("weight"), cover.getInt("start_price"), cover.getInt("current_price"), cover.getInt("amount"));
                        }//всю ерунду здесь сделать
                        //есть массив с категориями и есть массив с продуктами


                        for (int i = 0; i < categories.length; i++) {
                            recycleview_lists2 = new ArrayList<recycleview_list2>();
                            for (int j = 0; j < products.length; j++) {
                                if(categories[i].getId() == products[j].getCategories().getId()){
                                    recycleview_lists2.add(new recycleview_list2(products[j].getCover(), products[j].getCurrent_price()+" ₽ ", " " + products[j].getWeight()+" г", products[j].getName()));
                                    if(recycleview_lists2.size() > 4){
                                        break;
                                    }
                                }

                            }
                            Adapter_for_supermarket_tovar adapter = new Adapter_for_supermarket_tovar(recycleview_lists2,Inf_supermarket_Activity.this);
                            if(recycleview_lists2.size() > 0){
                                recycleview_lists3.add(new recycleview_list3(categories[i].getName(), adapter));
                            }


                        }
                        Adapter_for_supermarket_tovar_main tovar = new Adapter_for_supermarket_tovar_main(recycleview_lists3, Inf_supermarket_Activity.this);

                        recyclerView.setAdapter(tovar);
                        System.out.println(categories[0].getName()+"dsgfsc cat");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

    }

    private class LoadImgShop extends AsyncTask<String, Void, Bitmap> {


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
            Drawable drawable = new BitmapDrawable(getResources(), result);
            ImageView img_shop = findViewById(R.id.imageShop);
            img_shop.setBackground(drawable);
        }

    }

    public void internet_get(){
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://market.inverse-team.store/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        UserClient userClient = retrofit.create(UserClient.class);
        Call<ResponseBody> call = userClient.getCategories(s);
        call.enqueue(this);



//        RecyclerView recyclerView = findViewById(R.id.main_res_products);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        ArrayList<recycleview_list3> recycleview_lists3 = new ArrayList<recycleview_list3>();
//
//        ArrayList<recycleview_list2> recycleview_lists2 = new ArrayList<recycleview_list2>();
//
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "test230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "test230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
//        recycleview_lists2.add(new recycleview_list2(R.drawable.ic_launcher_background, "test230 ₽ ", " 200 г", "Омлет со страчетеллой и трбфелем"));
//
//        Adapter_for_supermarket_tovar adapter = new Adapter_for_supermarket_tovar(recycleview_lists2,this);
//
//        recycleview_lists3.add(new recycleview_list3("cat", adapter));
//        recycleview_lists3.add(new recycleview_list3("cat2", adapter));
//
//        Adapter_for_supermarket_tovar_main tovar = new Adapter_for_supermarket_tovar_main(recycleview_lists3, this);
//
//        recyclerView.setAdapter(tovar);
    }

    public static Drawable drawableFromUrl(String url) throws IOException {
        Bitmap x;
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.connect();
        InputStream input = connection.getInputStream();
        x = BitmapFactory.decodeStream(input);
        return new BitmapDrawable(Resources.getSystem(), x);
    }
}