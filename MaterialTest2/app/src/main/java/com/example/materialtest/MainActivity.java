package com.example.materialtest;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private SwipeRefreshLayout swipeRefresh;

    private Goldfish[] mGoldfishes =
            {
                    new Goldfish("红草金鱼",R.drawable.hongcaojinyu),
                    new Goldfish("红白草金鱼",R.drawable.hongbaicaojinyu),
                    new Goldfish("燕尾",R.drawable.yanweiyu),
                    //文种  18
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
                    new Goldfish("红帽金鱼",R.drawable.xiaohongmaojinyu),
                    new Goldfish("鹤顶红",R.drawable.hedinghonggaotou),
                    new Goldfish("四绒球金鱼",R.drawable.sirongqiujinyu),
                    new Goldfish("花文鱼",R.drawable.huawenyu),
                    new Goldfish("彩色文鱼",R.drawable.caisewenyu),
                    new Goldfish("白水泡红帽子",R.drawable.wenzhonghongdingshuipao),
                    //龙种  10
                    new Goldfish("墨龙睛",R.drawable.molongjing),
                    new Goldfish("喜鹊花龙睛",R.drawable.xiquehualongjing),
                    new Goldfish("灯泡眼龙睛",R.drawable.dengpaoyanlongjing),
                    new Goldfish("朱砂眼黑龙睛",R.drawable.zhushayanlongjing),
                    new Goldfish("紫白龙睛",R.drawable.zibailongjing),
                    new Goldfish("十二红龙睛",R.drawable.shirhonglongjing),
                    new Goldfish("紫虎头龙睛",R.drawable.zihutoulongjing),
                    new Goldfish("十二红蝶尾",R.drawable.shirhongdiewei),
                    new Goldfish("黄蝶尾",R.drawable.huangdiewei),
                    new Goldfish("红白花蝶尾",R.drawable.hongbaihuadiewei),
                    //蛋种   8
                    new Goldfish("黑白水泡",R.drawable.heibaishuipao),
                    new Goldfish("灯泡眼弓背水泡",R.drawable.dengpaoyangongbeishuipao),
                    new Goldfish("蓝花水泡",R.drawable.lanhuashuipao),
                    new Goldfish("红寿星虎头",R.drawable.hongshouxinghutou),
                    new Goldfish("红白兰寿",R.drawable.hongbailanshou),
                    new Goldfish("纯色寿星虎头",R.drawable.chunseshouxinghutou),
                    new Goldfish("红丹凤",R.drawable.hongdanfeng),
                    new Goldfish("蓝蛋凤球",R.drawable.landanfengqiu),
                    // 龙背种   6
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

    private long firstTime = 0;



    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            firstTime = secondTime;
        } else {
            System.exit(0);
        }
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = (FloatingActionButton)  findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Snackbar.make(v,"Data deleted",Snackbar.LENGTH_SHORT)
                        .setAction("Undo",new View.OnClickListener(){
                           @Override
                            public void onClick(View view){
                               Toast.makeText(MainActivity.this,"Data restored",Toast.LENGTH_SHORT).show();
                           }
                        }).show();
            }
        });*/
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView  navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(new DrawerArrowDrawable(getApplicationContext()));
            //getSupportActionBar().setHomeAsUpIndicator(new DrawerArrowDrawable(this));
        }
        navView.setCheckedItem(R.id.nav_all);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_jjz) {
                    Intent intent = new Intent(MainActivity.this,MainClassificationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","jjz");
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (id == R.id.nav_wz) {
                    Intent intent = new Intent(MainActivity.this,MainClassificationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","wz");
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (id == R.id.nav_lz) {
                    Intent intent = new Intent(MainActivity.this,MainClassificationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","lz");
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (id == R.id.nav_dz) {
                    Intent intent = new Intent(MainActivity.this,MainClassificationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","dz");
                    intent.putExtras(bundle);
                    startActivity(intent);
                } else if (id == R.id.nav_lbz) {
                    Intent intent = new Intent(MainActivity.this,MainClassificationActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name","lbz");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        initGoldfish();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GoldfishAdapter(mGoldfishList);
        recyclerView.setAdapter(adapter);


        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh(){
                refreshGoldfishes();
            }
        });
    }

    private void refreshGoldfishes(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initGoldfish();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initGoldfish(){
        mGoldfishList.clear();
        Arrays.fill(state,0);
        int cnt = 0;
        //for (int i = 0; i < mGoldfishes.length; i++) {
        while (1==1){
            if (cnt == state.length)
                break;
            Random random = new Random();
            int index = random.nextInt(mGoldfishes.length);
            if(state[index] == 0){
                mGoldfishList.add(mGoldfishes[index]);
                state[index]=1;
                cnt++;
            }
        }

       // }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.intro_all:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,IntroActivity.class);
                startActivity(intent);
                break;
            case R.id.version:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this,Version.class);
                startActivity(intent1);
                break;
            case R.id.declaration:
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this,DeclearedActivity.class);
                startActivity(intent2);
                break;
            default:
        }
        return true;
    }
}
