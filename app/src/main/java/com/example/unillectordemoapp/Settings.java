package com.example.unillectordemoapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {
    Switch MusicSwitch;
    AudioManager audioManager;
    Button button;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        button = (Button) findViewById(R.id.button);
        mediaPlayer = MediaPlayer.create(Settings.this, R.raw.backgroundmusic);
        mediaPlayer.setLooping(true);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        //Get current volume level
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        //used to play music
        MusicSwitch = (Switch) findViewById(R.id.MusicSwitch);
        onResume();

        //Used to change the volume of the music
        SeekBar seekBar = (SeekBar) findViewById(R.id.VolumeSeekBar);
        seekBar.setMax(maxVolume);
        seekBar.setProgress(currentVolume);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(Settings.this, button);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.pop_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(Settings.this, "You Clicked " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (item.getItemId()) {
                            case R.id.home:
                                Intent h = new Intent(Settings.this, Home.class);
                                startActivity(h);

                                break;
                            case R.id.PVP:
                                Intent p = new Intent(Settings.this, pvp.class);
                                startActivity(p);
                                break;

                            case R.id.PVE:
                                Intent e = new Intent(Settings.this, pve.class);
                                startActivity(e);
                                break;

                            case R.id.settings:
                                Intent s = new Intent(Settings.this, Settings.class);
                                startActivity(s);

                        }

                        return true;
                    }

                });

                popup.show();//showing popup menu

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }

    public void MusicSwitch(View v) {
        //Boolean switchstate = MusicSwitch.isChecked();
        if (MusicSwitch.isChecked() == true) {
            if (mediaPlayer == null)
            {
                mediaPlayer = MediaPlayer.create(Settings.this, R.raw.backgroundmusic);
            }
            onResume();
        }
        else if (MusicSwitch.isChecked() == false)
        {
            stopPlayer();
        }
    }



    private void stopPlayer()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer = null;
            Toast.makeText(this, "Media Player released", Toast.LENGTH_SHORT).show();
        }
    }
    //Method required to run music and used to start music
    @Override
    protected void onResume()
    {
        super.onResume();
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
    //Method required to run music
    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }
    //Method required to run music and used to stop music
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }

}