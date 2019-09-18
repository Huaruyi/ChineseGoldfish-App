package com.example.materialtest;

/**
 * Created by lenovo-pc on 2018-10-15.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;


public class GoldfishIntroActivity extends AppCompatActivity {
    private String name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.jjz_intro);
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        Toolbar toolbar;
        name1 = bundle.getString("name1");
        if(name1.equals("金鲫种")){
            setContentView(R.layout.jjz_intro);
            toolbar = (Toolbar)findViewById(R.id.jjz_toolbar);
        }else if(name1.equals("文种")){
            setContentView(R.layout.wz_intro);
            toolbar = (Toolbar)findViewById(R.id.wz_toolbar);
        }else if(name1.equals("龙种")){
            setContentView(R.layout.lz_intro);
            toolbar = (Toolbar)findViewById(R.id.lz_toolbar);
        }else if(name1.equals("蛋种")){
            setContentView(R.layout.dz_intro);
            toolbar = (Toolbar)findViewById(R.id.dz_toolbar);
        }else if(name1.equals("龙背种")){
            setContentView(R.layout.lbz_intro);
            toolbar = (Toolbar)findViewById(R.id.lbz_toolbar);
        }else{
            toolbar = null;
        }


        if (toolbar != null){
            toolbar.setTitle(name1+"介绍");
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
        GoldfishIntroActivity.this.finish();
    }
}

