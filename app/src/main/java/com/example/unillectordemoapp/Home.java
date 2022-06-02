package com.example.unillectordemoapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    Button button;
    AudioManager audioManager;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        //used to find the max volume of the device as it varies from device to device
        //used to play music
        mediaPlayer = MediaPlayer.create(Home.this, R.raw.backgroundmusic);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Home.this, button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Home.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.home:
                                Intent h = new Intent(Home.this, Home.class);
                                startActivity(h);

                                break;
                            case R.id.PVP:
                                Intent p = new Intent(Home.this, pvp.class);
                                startActivity(p);
                                break;

                            case R.id.PVE:
                                Intent e = new Intent(Home.this, pve.class);
                                startActivity(e);
                                break;

                            case R.id.settings:
                                Intent s = new Intent(Home.this, Settings.class);
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
