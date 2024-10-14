package com.example.tp3part1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    EditText editText2;
    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        list = findViewById(R.id.list);
        editText = findViewById(R.id.input);
        editText2 = findViewById(R.id.editTextText3);

        data = new ArrayList<>(Arrays.asList("banane 10kg", "ananas 20kg", "tomate 2kg"));

        adapter = new ArrayAdapter<>(this, R.layout.item, R.id.textView, data);
        list.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString()+""+ editText2.getText().toString();
                data.add(inputText);
                adapter.notifyDataSetChanged(); // Notify the adapter that the data has changed
            }
        });
    }
}