package com.example.grampus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Post5 extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView burgerMenu;
    private Button burger1;
    private Button burger2;
    private Button burger3;
    private Button burger4;
    private TextView vk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_5);

        drawerLayout = findViewById(R.id.drawerLayout);

        burgerMenu = findViewById(R.id.BurgerMenu);

        burger1 = findViewById(R.id.burger1);

        burger2 = findViewById(R.id.burger2);

        burger3 = findViewById(R.id.burger3);

        burger4 = findViewById(R.id.burger4);

        vk = findViewById(R.id.vk);

        burgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        burger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post5.this, MainActivity.class);
                startActivity(intent);
            }
        });

        burger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post5.this, Work.class);
                startActivity(intent);
            }
        });

        burger3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post5.this, About.class);
                startActivity(intent);
            }
        });

        burger4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Post5.this, Request.class);
                startActivity(intent);
            }
        });

        vk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://vk.com/grampus_studio";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}