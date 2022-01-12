package com.teamdagger.finance_komandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.teamdagger.finance_komandro.databinding.ActivitySaveUseBinding;

public class SaveUseActivity extends AppCompatActivity {

    private ActivitySaveUseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySaveUseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intentReceived = getIntent();
        Boolean apakahMenyimpan = intentReceived.getBooleanExtra("KEY_SAVE_USE", false);

        binding.btnSaveNominal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code di dalam sini akan di jalankan ketika tombol di klik

                if( binding.etNominal.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Tolong isi data", Toast.LENGTH_LONG).show();
                }else{

                    if(apakahMenyimpan == true){
                        String nominalStr = binding.etNominal.getText().toString();
                        int nominal = Integer.parseInt(nominalStr);

                        simpanUang(nominal);
                    }else{
                        String nominalStr = binding.etNominal.getText().toString();
                        int nominal = Integer.parseInt(nominalStr);

                        gunakanUang(nominal);
                    }

                }

            }
        });
    }
    void simpanUang(int nominal){
        SharedPreferences database = getSharedPreferences("database_uang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatabase = database.edit();

        int nominalTersimpan = database.getInt("SALDO", 0);
        nominalTersimpan = nominalTersimpan + nominal;

        editorDatabase.putInt("SALDO", nominalTersimpan);

        editorDatabase.apply();
    }
    void gunakanUang(int nominal){
        SharedPreferences database = getSharedPreferences("database_uang", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorDatabase = database.edit();

        int nominalTersimpan = database.getInt("SALDO", 0);
        nominalTersimpan = nominalTersimpan - nominal;

        editorDatabase.putInt("SALDO", nominalTersimpan);

        editorDatabase.apply();
    }

}