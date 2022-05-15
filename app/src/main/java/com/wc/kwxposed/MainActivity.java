package com.wc.kwxposed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import de.robv.android.xposed.XSharedPreferences;

public class MainActivity extends AppCompatActivity {
    private static final String OPEN_KW_HOOK = "open_kw_hook";
    private CheckBox cbHook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbHook = findViewById(R.id.cbHook);
        cbHook.setOnCheckedChangeListener((compoundButton, b) -> {
            setInitData(b);
        });
        getInitData();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private void getInitData() {
        cbHook.setChecked(true);
    }

    private void setInitData(boolean b) {
    }
}