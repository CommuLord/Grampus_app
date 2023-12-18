package com.example.grampus_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import android.widget.Toast;

public class Request2 extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ImageView burgerMenu;
    private Button burger1;
    private Button burger2;
    private Button burger3;
    private Button burger4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_layout_2);

        drawerLayout = findViewById(R.id.drawerLayout);

        burgerMenu = findViewById(R.id.BurgerMenu);

        burger1 = findViewById(R.id.burger1);

        burger2 = findViewById(R.id.burger2);

        burger3 = findViewById(R.id.burger3);

        burger4 = findViewById(R.id.burger4);

        EditText fioEditText = findViewById(R.id.fioEditText);

        EditText phoneEditText = findViewById(R.id.phoneEditText);

        EditText emailEditText = findViewById(R.id.emailEditText);

        EditText descriptionEditText = findViewById(R.id.descriptionEditText);

        Button sendButton = findViewById(R.id.WorkButton);

        String connectionString = "jdbc:ucanaccess://C:/Users/KOSTYAVINOGRADOV/Downloads/praktiac.accdb";

        sendButton.setOnClickListener(view -> {
            String fio = fioEditText.getText().toString();
            String phone = phoneEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String description = descriptionEditText.getText().toString();

            String[] nameParts = fio.split(" ");
            String name = nameParts[0];
            String surname = nameParts[nameParts.length - 1];

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                try (Connection connection = DriverManager.getConnection(connectionString)) {
                    String query = "INSERT INTO Заказ (Имя, Фамилия, Телефон, Почта, Описание_заказа) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, surname);
                        preparedStatement.setString(3, phone);
                        preparedStatement.setString(4, email);
                        preparedStatement.setString(5, description);
                        preparedStatement.executeUpdate();
                    }
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
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
                Intent intent = new Intent(Request2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        burger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Request2.this, Work.class);
                startActivity(intent);
            }
        });

        burger4.setOnClickListener(new View.OnClickListener() {
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
                Intent intent = new Intent(Request2.this, About.class);
                startActivity(intent);
            }
        });
    }
}