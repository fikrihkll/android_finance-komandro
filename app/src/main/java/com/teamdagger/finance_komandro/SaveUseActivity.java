package com.teamdagger.finance_komandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

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

    }
}