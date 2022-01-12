package com.teamdagger.finance_komandro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

        ambilDataSaldo();

        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Code yang ada di dalam sini akan di panggil ketika layar di swipe
                ambilDataSaldo();
                binding.swipeRefresh.setRefreshing(false);
            }
        });

    }

    void ambilDataSaldo(){
        SharedPreferences database = getSharedPreferences("database_uang", Context.MODE_PRIVATE);

        int saldo = database.getInt("SALDO",0);

        binding.tvTotal.setText("Rp." + saldo);
    }

}