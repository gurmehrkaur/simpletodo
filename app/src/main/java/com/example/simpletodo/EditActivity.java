package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        View etItem = findViewById(R.id.etItem);
        View btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Edit item");

        etItem.setTextAlignment(Integer.parseInt(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT)));

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent ();

                intent.putExtra(MainActivity.KEY_ITEM_TEXT, etItem.getTextAlignment().toString());
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION));

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}