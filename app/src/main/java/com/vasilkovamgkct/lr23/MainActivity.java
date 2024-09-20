package com.vasilkovamgkct.lr23;


import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailAddress, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Найдем элементы по id
        emailAddress = findViewById(R.id.email_address);
        subject = findViewById(R.id.subject);
        message = findViewById(R.id.message);
        Button sendButton = findViewById(R.id.send_button);



        // Устанавливаем обработчик нажатия на кнопку
        sendButton.setOnClickListener(v -> {
            String email = emailAddress.getText().toString().trim();

            // Проверка на валидность email адреса
            if (!isValidEmail(email)) {
                emailAddress.setError("Введите корректный адрес электронной почты");
                return; // Прекращаем выполнение, если email невалиден
            }

            // Очищаем текстовые поля
            emailAddress.setText("");
            subject.setText("");
            message.setText("");


            // Переходим на новую активность
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intent);
        });
    }



    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}
