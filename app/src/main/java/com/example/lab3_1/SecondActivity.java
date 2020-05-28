package com.example.lab3_1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fruit);

        // find all items in the activity

        TextView Name = findViewById(R.id.Name2);
        TextView origin = findViewById(R.id.origin);
        ImageView imageView = findViewById(R.id.imageViewName);
        TextView description = findViewById(R.id.description);

        // put data from previous activity
        Bundle bundle = getIntent().getExtras();
        Name.setText(getIntent().getStringExtra("Name"));
        origin.setText(getIntent().getStringExtra("origin"));
        description.setText(getIntent().getStringExtra("description"));
        imageView.setImageResource(getIntent().getIntExtra("image", 0));

        // button to get back to recycle wiev
        Button back = findViewById(R.id.back);
        // back button to list
        back.setOnClickListener(view -> {
            onBackPressed();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
