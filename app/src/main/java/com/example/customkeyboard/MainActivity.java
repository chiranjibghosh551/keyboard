package com.example.customkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         CustomKeyboard customKeyboard = findViewById(R.id.custom_keyboard);
        EditText textInput = findViewById(R.id.text_input);

        customKeyboard.setTargetEditText(textInput);
    }
}