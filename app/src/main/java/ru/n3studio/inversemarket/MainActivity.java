package ru.n3studio.inversemarket;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;


import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.n3studio.inversemarket.Api.Shops;
import ru.n3studio.inversemarket.Api.UserClient;
import ru.n3studio.inversemarket.Fragment.BasketFragment;
import ru.n3studio.inversemarket.Fragment.MenuFragment;
import ru.n3studio.inversemarket.Fragment.ProfileFragment;
import ru.n3studio.inversemarket.Fragment.ShopFragment;
import ru.n3studio.inversemarket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ShopFragment shopFragment;
    private static String s = "Token 201fde2f630ae9246e2b6e42f2c301246e5854dc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shopFragment = new ShopFragment();
        fragmentReplace(shopFragment);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://market.inverse-team.store/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        UserClient userClient = retrofit.create(UserClient.class);

        Call<Shops> call = userClient.getShops(s);
        call.enqueue(new Callback<Shops>() {
            @Override
            public void onResponse(Call<Shops> call, Response<Shops> response) {
                if(response.isSuccessful()){
                    Shops shops = new Shops();
                    shops.setName(response.body().getName());
                    shops.setCategory(response.body().getCategory());
                    shops.setId(response.body().getId());
                    System.out.println(response.body().getName()+"asfggggggggggg");
                    System.out.println(response.body().toString()+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
                }
            }

            @Override
            public void onFailure(Call<Shops> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.shop_for_bottom_nav:
                    startActivity(new Intent(this, Inf_supermarket_Activity.class));
//                    fragmentReplace(new ShopFragment());
                    break;
                case R.id.menu_for_bottom_nav:
                    fragmentReplace(new MenuFragment());
                    break;
                case R.id.basket_for_bottom_nav:
                    fragmentReplace(new BasketFragment());
                    break;
                case R.id.profile_for_bottom_nav:
                    fragmentReplace(new ProfileFragment());
                    break;
            }

            return true;
        });
//        startActivity(new Intent(this, ProductShopsActivity.class));


    }

    public void fragmentReplace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}