package com.example.unit3eval1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         timer=new Timer();
         timer.schedule(new TimerTask() {
             @Override
             public void run() {
                 Intent intent=new Intent(MainActivity.this,ItemListActivity.class);
                 startActivity(intent);
                 finish();

             }
         },3000);

    }


}