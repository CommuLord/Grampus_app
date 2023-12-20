package com.example.grampus_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class Work extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView burgerMenu;
    private Button burger1;
    private Button burger2;
    private Button burger3;
    private Button burger4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.work_layout);

        drawerLayout = findViewById(R.id.drawerLayout);

        burgerMenu = findViewById(R.id.BurgerMenu);

        burger1 = findViewById(R.id.burger1);

        burger2 = findViewById(R.id.burger2);

        burger3 = findViewById(R.id.burger3);

        burger4 = findViewById(R.id.burger4);

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fioEditText = findViewById(R.id.fioEditText);
                EditText ageEditText = findViewById(R.id.ageEditText);
                EditText phoneEditText = findViewById(R.id.phoneEditText);
                EditText emailEditText = findViewById(R.id.emailEditText);
                EditText descriptionEditText = findViewById(R.id.descriptionEditText);
                Spinner vacancySpinner = findViewById(R.id.vacancySpinner);

                String fio = fioEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String vacancy = vacancySpinner.getSelectedItem().toString();

                if (fio.isEmpty() || age.isEmpty() || phone.isEmpty() || email.isEmpty() || description.isEmpty() || vacancy.equals("Выбрать")) {
                    Toast.makeText(Work.this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Work.this, "Спасибо, мы скоро свяжемся с Вами!", Toast.LENGTH_SHORT).show();
                }
            }
        });


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
                Intent intent = new Intent(Work.this, MainActivity.class);
                startActivity(intent);
            }
        });

        burger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        burger3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Work.this, About.class);
                startActivity(intent);
            }
        });

        burger4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Work.this, Request.class);
                startActivity(intent);
            }
        });
    }
}