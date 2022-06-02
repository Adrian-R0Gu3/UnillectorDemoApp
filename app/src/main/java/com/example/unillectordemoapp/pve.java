package com.example.unillectordemoapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<imageModel> imageModelArrayList;
    private RecyclerImageAdapter recyclerImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(recyclerImageAdapter);
        recyclerImageAdapter.notifyDataSetChanged();



        //recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(PokemonActivity.this, 3));
        recyclerView.setHasFixedSize(true);


        imageModelArrayList = new ArrayList<>();
        clearAll();
        // Write a message to the database
        DatabaseReference database = FirebaseDatabase.getInstance().getReference().child("Pokemon");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                clearAll();
                for(DataSnapshot snapshot1 : snapshot.getChildren())
                {
                    imageModel m = new imageModel();
                    m.setImageURL(snapshot1.child("Token").getValue().toString());
                    m.setType(snapshot1.child("Card Type").getValue().toString());
                    m.setDescription(snapshot1.child("Description").getValue().toString());
                    m.setHp(snapshot1.child("HP").getValue().toString());
                    m.setResistance(snapshot1.child("Resistance").getValue().toString());
                    m.setRc(snapshot1.child("Retreat Cost").getValue().toString());
                    m.setWeakness(snapshot1.child("Weakness").getValue().toString());


                    imageModelArrayList.add(m);
                }

                recyclerImageAdapter = new RecyclerImageAdapter(getApplicationContext(), imageModelArrayList);
                //recyclerView.setAdapter(recyclerImageAdapter);
                //recyclerImageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                Toast.makeText(PokemonActivity.this, "Error: " + error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    private void clearAll()
    {
        if(imageModelArrayList != null)
        {
            imageModelArrayList.clear();

            if(recyclerImageAdapter != null)
            {
                recyclerImageAdapter.notifyDataSetChanged();
            }
            imageModelArrayList = new ArrayList<>();
        }
    }
}
