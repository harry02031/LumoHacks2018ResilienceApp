package com.example.zhenyux.lumohack2018;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private ViewPager viewPager;
final Context self = MainActivity.this;

private IntroFragmentCollectionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.pager);
        adapter = new IntroFragmentCollectionAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        Button button = findViewById(R.id.introBut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = menuActivity.makeIntent(self) ;
               startActivity(intent);
               finish();
            }
        });
    }


}
