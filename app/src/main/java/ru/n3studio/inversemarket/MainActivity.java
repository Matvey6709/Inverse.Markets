package ru.n3studio.inversemarket;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;


import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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
import ru.n3studio.inversemarket.Fragment.BasketFragment;
import ru.n3studio.inversemarket.Fragment.MenuFragment;
import ru.n3studio.inversemarket.Fragment.ProfileFragment;
import ru.n3studio.inversemarket.Fragment.ShopFragment;
import ru.n3studio.inversemarket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ShopFragment shopFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shopFragment = new ShopFragment();
        fragmentReplace(shopFragment);



        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.shop_for_bottom_nav:
//                    startActivity(new Intent(this, Inf_supermarket_Activity.class));
                    fragmentReplace(new ShopFragment());
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