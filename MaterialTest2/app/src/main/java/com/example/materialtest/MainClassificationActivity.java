package com.example.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainClassificationActivity extends AppCompatActivity {


    private String nameValue;
    private Goldfish[] mGoldfishes =
            {
                    new Goldfish("红草金鱼",R.drawable.hongcaojinyu),
                    new Goldfish("红白草金鱼",R.drawable.hongbaicaojinyu),
                    new Goldfish("燕尾",R.drawable.yanweiyu),
                    new Goldfish("红白珍珠鳞鱼",R.drawable.hongbaizhenzhulinyu),
                    new Goldfish("玉印头皇冠珍珠鳞鱼",R.drawable.yuyintouhuangguanzhenzhulinyu),
                    new Goldfish("十二黑皇冠珍珠鳞鱼",R.drawable.shirheihuangguanzhenzhulinyu),
                    new Goldfish("长尾红白琉金",R.drawable.changweihongbailiujin),
                    new Goldfish("虎皮纹短尾琉金",R.drawable.hupiwenduanweiliujin),
                    new Goldfish("长尾黑琉金",R.drawable.changweiheiliujinjjinyu),
                    new Goldfish("三色短尾琉金",R.drawable.sanseduanweiliujin),
                    new Goldfish("红白短尾琉金",R.drawable.hongbaiduanweiliujin),
                    new Goldfish("红顶三色狮",R.drawable.hongdingsanseshi),
                    new Goldfish("玉顶银狮",R.drawable.yudingyinshi),
                    new Goldfish("金头黑白狮",R.drawable.jintouheibaishi),
                    new Goldfish("黄高头",R.drawable.huanggaotou),
                    //new Goldfish("高头金鱼",R.drawable.gaotoujinyu),
                    new Goldfish("红帽金鱼",R.drawable.xiaohongmaojinyu),
                    //new Goldfish("红高头",R.drawable.honggaotou),
                    new Goldfish("鹤顶红",R.drawable.hedinghonggaotou),
                    new Goldfish("四绒球金鱼",R.drawable.sirongqiujinyu),
                    //new Goldfish("熊猫鱼",R.drawable.xiongmaoyu),
                    new Goldfish("花文鱼",R.drawable.huawenyu),
                    new Goldfish("彩色文鱼",R.drawable.caisewenyu),
                    new Goldfish("白水泡红帽子",R.drawable.wenzhonghongdingshuipao),
                    //new Goldfish("红顶宽鳍三色水泡",R.drawable.hongdingkuanqisanseshuipao),
                    new Goldfish("墨龙睛",R.drawable.molongjing),
                    new Goldfish("喜鹊花龙睛",R.drawable.xiquehualongjing),
                    new Goldfish("灯泡眼龙睛",R.drawable.dengpaoyanlongjing),
                    new Goldfish("朱砂眼黑龙睛",R.drawable.zhushayanlongjing),
                    new Goldfish("紫白龙睛",R.drawable.zibailongjing),
                    new Goldfish("十二红龙睛",R.drawable.shirhonglongjing),
                    new Goldfish("紫虎头龙睛",R.drawable.zihutoulongjing),
                    //new Goldfish("玛瑙眼蝶尾",R.drawable.manaoyandiewei),
                    new Goldfish("十二红蝶尾",R.drawable.shirhongdiewei),
                    new Goldfish("黄蝶尾",R.drawable.huangdiewei),
                    //new Goldfish("蓝蝶尾",R.drawable.landiewei),
                    new Goldfish("红白花蝶尾",R.drawable.hongbaihuadiewei),
                    //new Goldfish("三色水泡",R.drawable.sanseshuipao),
                    new Goldfish("黑白水泡",R.drawable.heibaishuipao),
                    new Goldfish("灯泡眼弓背水泡",R.drawable.dengpaoyangongbeishuipao),
                    new Goldfish("蓝花水泡",R.drawable.lanhuashuipao),
                    new Goldfish("红寿星虎头",R.drawable.hongshouxinghutou),
                    new Goldfish("红白兰寿",R.drawable.hongbailanshou),
                    new Goldfish("纯色寿星虎头",R.drawable.chunseshouxinghutou),
                    new Goldfish("红丹凤",R.drawable.hongdanfeng),
                    new Goldfish("蓝蛋凤球",R.drawable.landanfengqiu),
                    new Goldfish("红白望天",R.drawable.hongbaiwangtian),
                    new Goldfish("黑望天",R.drawable.heiwangtian),
                    new Goldfish("红朝天龙",R.drawable.chaotianlong),
                    new Goldfish("紫朝天龙",R.drawable.zisechaotianlong),
                    new Goldfish("红头龙背",R.drawable.hongtoulongbei),
                    new Goldfish("龙背球",R.drawable.longbeiqiu),
            };
    private List<Goldfish> mGoldfishList = new ArrayList<>();
    private GoldfishAdapter adapter;
    private int [] state = new int[mGoldfishes.length];



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainclassification);
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String name = bundle.getString("name");
        nameValue = "";
        if(name.equals("jjz")){
            nameValue = "金鲫种";
        }else if(name.equals("wz")){
            nameValue = "文种";
        }else if(name.equals("lz")){
            nameValue = "龙种";
        }else if(name.equals("dz")){
            nameValue = "蛋种";
        }else if(name.equals("lbz")){
            nameValue = "龙背种";
        }
        //Toast.makeText(this,name,Toast.LENGTH_LONG).show();
        Toolbar toolbar = (Toolbar)findViewById(R.id.ms_toolbar);
        if (toolbar != null){
            toolbar.setTitle(nameValue);
        }
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                finish();//返回
             }
        });


        initGoldfish(name);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.ms_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GoldfishAdapter(mGoldfishList);
        recyclerView.setAdapter(adapter);


       /* swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);*/
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.sub_toolbar,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.sub_intro:
                Intent intent = new Intent(MainClassificationActivity.this,GoldfishIntroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name1",nameValue);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        MainClassificationActivity.this.finish();
    }

    private void initGoldfish(String name){
        mGoldfishList.clear();
        Arrays.fill(state,0);
        int cnt = 0;
        int begin = -1,end = -1;
        switch (name){
            case "jjz":
                begin = 0;
                end = 2;
                break;
            case "wz":
                begin = 3;
                end = 20;
                break;
            case "lz":
                begin = 21;
                end = 30;
                break;
            case "dz":
                begin = 31;
                end = 38;
                break;
            case "lbz":
                begin = 39;
                end = 44;
                break;
        }
        for (int i = begin; i <= end; i++) {
                mGoldfishList.add(mGoldfishes[i]);
        }
    }
}
