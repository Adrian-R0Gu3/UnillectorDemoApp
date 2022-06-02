package com.example.unillectordemoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class NewActivity extends AppCompatActivity {

    private ImageView fullImageView;
    private TextView CardType, Hp, Weakness, Resistance, retreatCost, Description;
    private Button download;
    private Button collect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);




        fullImageView = findViewById(R.id.fullImageView);

        Glide.with(this).
                load(getIntent().getStringExtra("Token@#"))
                .into(fullImageView);

        CardType = findViewById(R.id.type);
        CardType.setText(getIntent().getStringExtra("type@#"));
        Hp = findViewById(R.id.hp);
        Hp.setText(getIntent().getStringExtra("hp@#"));
        Weakness = findViewById(R.id.weakness);
        Weakness.setText(getIntent().getStringExtra("weakness@#"));
        Resistance = findViewById(R.id.resistance);
        Resistance.setText(getIntent().getStringExtra("resistance@#"));
        retreatCost = findViewById(R.id.retreatcost);
        retreatCost.setText(getIntent().getStringExtra("retreatcost@#"));
        Description = findViewById(R.id.description);
        Description.setText(getIntent().getStringExtra("description@#"));

    }
}