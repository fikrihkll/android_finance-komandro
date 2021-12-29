package com.teamdagger.finance_komandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.teamdagger.finance_komandro.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Ketik code disini,
                // dan code akan dijalankan ketika tombol di klik
                Intent intentSaveUse = new Intent(MainActivity.this, SaveUseActivity.class);

                Boolean apakahMenyimpan = true;

                intentSaveUse.putExtra("KEY_SAVE_USE", apakahMenyimpan);

                startActivity(intentSaveUse);
            }
        });

        binding.btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Ketik code disini,
                // dan code akan dijalankan ketika tombol di klik
                Intent intentSaveUse = new Intent(MainActivity.this, SaveUseActivity.class);

                Boolean apakahMenyimpan = false;

                intentSaveUse.putExtra("KEY_SAVE_USE", apakahMenyimpan);

                startActivity(intentSaveUse);
            }
        });


    }

}