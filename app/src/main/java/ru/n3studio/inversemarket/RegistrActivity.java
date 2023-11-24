package ru.n3studio.inversemarket;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RegistrActivity extends AppCompatActivity {
    EditText editLogin;
    EditText editPassword;
    ImageView see_password;
    Button btn_enter;
    boolean open_close = true;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registr);
        editLogin = findViewById(R.id.editLogin);
        editPassword = findViewById(R.id.editPassword);
        see_password = findViewById(R.id.see_password);
        btn_enter = findViewById(R.id.btn_enter);
        see_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!open_close){
                    open_close = true;
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    see_password.setImageResource(R.drawable.view_outline_20);
                }else {
                    open_close = false;
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    see_password.setImageResource(R.drawable.close_eyes);
                }

            }
        });
        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editLogin.length() > 0 && editLogin.length() > 0){
                    Intent intent = new Intent(RegistrActivity.this, MainActivity.class);
                    intent.putExtra("close_reg", true);
                    startActivity(intent);
                }
            }
        });

    }
}