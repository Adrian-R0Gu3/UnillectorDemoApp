package com.example.unillectordemoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pvp extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);


        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(pvp.this, button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(pvp.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.home:
                                Intent h = new Intent(pvp.this, Home.class);
                                startActivity(h);

                                break;
                            case R.id.PVP:
                                Intent p = new Intent(pvp.this, pvp.class);
                                startActivity(p);
                                break;

                            case R.id.PVE:
                                Intent e = new Intent(pvp.this, pve.class);
                                startActivity(e);
                                break;

                            case R.id.settings:
                                Intent s = new Intent(pvp.this, Settings.class);
                                startActivity(s);


                        }

                        return true;
                    }

                });

                popup.show();//showing popup menu
            }
        });//closing the setOnClickListener method
    }
}