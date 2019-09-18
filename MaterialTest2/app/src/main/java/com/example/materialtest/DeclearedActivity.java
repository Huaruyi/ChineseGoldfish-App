package com.example.materialtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by lenovo-pc on 2018-10-17.
 */

public class DeclearedActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decleared);

        Toolbar toolbar = (Toolbar)findViewById(R.id.d_toolbar);
        if (toolbar != null){
            toolbar.setTitle("作品声明");
            setSupportActionBar(toolbar);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    finish();//返回
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        DeclearedActivity.this.finish();
    }
}
