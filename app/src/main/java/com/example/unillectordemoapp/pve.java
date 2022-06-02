package com.example.unillectordemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pve extends AppCompatActivity {
    Button button;
   /* private RecyclerView recyclerView;
    private ArrayList<imageModel> imageModelArrayList;
    private RecyclerImageAdapter recyclerImageAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pve);


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(pve.this, button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(pve.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.home:
                                Intent h = new Intent(pve.this, Home.class);
                                startActivity(h);

                                break;
                            case R.id.PVP:
                                Intent p = new Intent(pve.this, pvp.class);
                                startActivity(p);
                                break;

                            case R.id.PVE:
                                Intent e = new Intent(pve.this, pve.class);
                                startActivity(e);
                                break;

                            case R.id.settings:
                                Intent s = new Intent(pve.this, Settings.class);
                                startActivity(s);

                        }

                        return true;
                    }

                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method





        /*RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(recyclerImageAdapter);
        recyclerImageAdapter.notifyDataSetChanged();



        //recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(pve.this, 3));
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
                Toast.makeText(pve.this, "Error: " + error.getMessage(),
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
    }*/
    }
}
