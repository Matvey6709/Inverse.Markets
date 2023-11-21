package ru.n3studio.inversemarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;

import ru.n3studio.inversemarket.Activity.ProductShopsActivity;
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
            switch (item.getItemId()){
                case R.id.shop_for_bottom_nav:
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

            return  true;
        });


    }
    public void fragmentReplace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}