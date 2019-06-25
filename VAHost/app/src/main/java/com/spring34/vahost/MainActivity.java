package com.spring34.vahost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(v -> {
            File plugin = new File(getFilesDir(), "Resource1.apk");
            try {
                PluginManager.getInstance(this).loadPlugin(plugin);
            } catch(Exception e) {
                e.printStackTrace();
            }

            Intent intent = new Intent();
            intent.setClassName("com.spring34.vaplugin", "com.spring34.vaplugin.Main2Activity");
            startActivity(intent);
        });
    }
}
