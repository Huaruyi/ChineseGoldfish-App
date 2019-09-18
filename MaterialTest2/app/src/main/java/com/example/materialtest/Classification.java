package com.example.materialtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class Classification extends AppCompatActivity {

    public static final String GOLDFISH_NAME = "goldfish_name";
    public static final String GOLDFISH_IMAGE_ID = "goldfish_image_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goldfish);
        Bundle bundle = this.getIntent().getExtras();
        //接收name值
        String name = bundle.getString("name");
        Intent intent = getIntent();
        String goldfishName = intent.getStringExtra(GOLDFISH_NAME);
        int goldfishImageId = intent.getIntExtra(GOLDFISH_IMAGE_ID,0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView goldfishImageView = (ImageView) findViewById(R.id.goldfish_image_view);
        TextView goldfishContentText = (TextView) findViewById(R.id.goldfish_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(goldfishName);
        Glide.with(this).load(goldfishImageId).into(goldfishImageView);
        String goldfishContent = generateFruitContent(goldfishName,name);
        goldfishContentText.setText(goldfishContent);
    }


    private String generateFruitContent(String goldfishName,String name){
        StringBuilder goldfishContent = new StringBuilder();
        if(name.equals("jjz")){

            //金鲫种
            if(goldfishName .equals("红草金鱼") ){
                goldfishContent.append(getString(R.string.Hongcao));
            }else if(goldfishName.equals("红白草金鱼")){
                goldfishContent.append(getResources().getString(R.string.Hongbaicao));
            }else if(goldfishName.equals("燕尾")){
                goldfishContent.append(getResources().getString(R.string.Yanwei));
            }

        }else if (name.equals("wz")){

            //文种
            if(goldfishName.equals("红白珍珠鳞鱼")){
                goldfishContent.append(getResources().getString(R.string.Hongbaizhenzhulin));
            }else if(goldfishName.equals("玉印头皇冠珍珠鳞鱼")){
                goldfishContent.append(getResources().getString(R.string.Yuyintouzhenzhulin));
            }else if(goldfishName.equals("十二黑皇冠珍珠鳞鱼")){
                goldfishContent.append(getResources().getString(R.string.Shirheizhenzhulin));
            }else if(goldfishName.equals("长尾红白琉金")){
                goldfishContent.append(getResources().getString(R.string.Changweihongbailiujin));
            }else if(goldfishName.equals("虎皮纹短尾琉金")){
                goldfishContent.append(getResources().getString(R.string.Hupiwenduanweiliujin));
            }else if(goldfishName.equals("长尾黑琉金")){
                goldfishContent.append(getResources().getString(R.string.Changweiheiliujin));
            }else if(goldfishName.equals("三色短尾琉金")){
                goldfishContent.append(getResources().getString(R.string.Sanseduanweiliujin));
            }else if(goldfishName.equals("红白短尾琉金")){
                goldfishContent.append(getResources().getString(R.string.Hongbaiduanweiliujin));
            }else if(goldfishName.equals("红顶三色狮")){
                goldfishContent.append(getResources().getString(R.string.Hongdingsanseshi));
            }else if(goldfishName.equals("玉顶银狮")){
                goldfishContent.append(getResources().getString(R.string.Yudingyinshi));
            }else if(goldfishName.equals("金头黑白狮")){
                goldfishContent.append(getResources().getString(R.string.Jintouheibaishi));
            }else if(goldfishName.equals("黄高头")){
                goldfishContent.append(getResources().getString(R.string.Huanggaotou));
            }else if(goldfishName.equals("红帽金鱼")){
                goldfishContent.append(getResources().getString(R.string.Hongmao));
            } else if(goldfishName.equals("红高头")){
            //goldfishContent.append(getResources().getString(R.string.Yanwei));
            } else if(goldfishName.equals("鹤顶红")){
                goldfishContent.append(getResources().getString(R.string.Hedinghong));
            }else if(goldfishName.equals("四绒球金鱼")){
                goldfishContent.append(getResources().getString(R.string.Sirongqiu));
            } else if(goldfishName.equals("熊猫鱼")){
            //goldfishContent.append(getResources().getString(R.string.Yanwei));
            } else if(goldfishName.equals("花文鱼")){
                goldfishContent.append(getResources().getString(R.string.Huawenyu));
            }else if(goldfishName.equals("彩色文鱼")){
                goldfishContent.append(getResources().getString(R.string.Caisewenyu));
            }else if(goldfishName.equals("白水泡红帽子")){
                goldfishContent.append(getResources().getString(R.string.Hongdingshuipao));
            } else if(goldfishName.equals("红顶宽鳍三色水泡")){
            //goldfishContent.append(getResources().getString(R.string.Yanwei));
            }


        }else if (name.equals("lz")){

            //龙种
            if(goldfishName.equals("墨龙睛")){
                goldfishContent.append(getResources().getString(R.string.Molongjing));
            }else if(goldfishName.equals("喜鹊花龙睛")){
                goldfishContent.append(getResources().getString(R.string.Xiquehualongjing));
            }else if(goldfishName.equals("灯泡眼龙睛")){
                goldfishContent.append(getResources().getString(R.string.Dengpaoyangongbeishuipao));
            }else if(goldfishName.equals("朱砂眼黑龙睛")){
                goldfishContent.append(getResources().getString(R.string.Zhushayanlongjing));
            }else if(goldfishName.equals("紫白龙睛")){
                goldfishContent.append(getResources().getString(R.string.Zibailongjing));
            }else if(goldfishName.equals("十二红龙睛")){
                goldfishContent.append(getResources().getString(R.string.Shirhonglongjing));
            }else if(goldfishName.equals("紫虎头龙睛")){
                goldfishContent.append(getResources().getString(R.string.Zihutoulongjing));
            } else if(goldfishName.equals("玛瑙眼蝶尾")){
                  //goldfishContent.append(getResources().getString(R.string.Yanwei));
            } else if(goldfishName.equals("十二红蝶尾")){
                goldfishContent.append(getResources().getString(R.string.Shirhongdiewei));
            }else if(goldfishName.equals("黄蝶尾")){
                goldfishContent.append(getResources().getString(R.string.Huangdiewei));
            } else if(goldfishName.equals("蓝蝶尾")){
             //goldfishContent.append(getResources().getString(R.string.Yanwei));
            } else if(goldfishName.equals("红白花蝶尾")){
                goldfishContent.append(getResources().getString(R.string.Hongbaihuadiewei));
            }

        }else if (name.equals("dz")){

            //蛋种
            if(goldfishName.equals("三色水泡")){
            //goldfishContent.append(getResources().getString(R.string.Yanwei));
            }
            if(goldfishName.equals("黑白水泡")){
                goldfishContent.append(getResources().getString(R.string.Heibaishuipao));
            }else if(goldfishName.equals("灯泡眼弓背水泡")){
                goldfishContent.append(getResources().getString(R.string.Dengpaoyangongbeishuipao));
            }else if(goldfishName.equals("蓝花水泡")){
                goldfishContent.append(getResources().getString(R.string.Lanhuashuipao));
            }else if(goldfishName.equals("红寿星虎头")){
                goldfishContent.append(getResources().getString(R.string.Hongshouxinghutou));
            }else if(goldfishName.equals("红白兰寿")){
                goldfishContent.append(getResources().getString(R.string.Hongbailanshou));
            }else if(goldfishName.equals("纯色寿星虎头")){
                goldfishContent.append(getResources().getString(R.string.Chunseshouxinghutou));
            }else if(goldfishName.equals("红丹凤")){
                goldfishContent.append(getResources().getString(R.string.Hongdanfeng));
            }else if(goldfishName.equals("蓝蛋凤球")){
                goldfishContent.append(getResources().getString(R.string.Landanfengqiu));
            }

        }else if (name.equals("lbz")){

            //龙背种
            if(goldfishName.equals("红白望天")){
                goldfishContent.append(getResources().getString(R.string.Hongbaiwangtian));
            }else if(goldfishName.equals("黑望天")){
                goldfishContent.append(getResources().getString(R.string.Heiwangtian));
            }else if(goldfishName.equals("红朝天龙")){
                goldfishContent.append(getResources().getString(R.string.Hongchaotianlong));
            }else if(goldfishName.equals("紫朝天龙")){
                goldfishContent.append(getResources().getString(R.string.Zichaotianlong));
            }else if(goldfishName.equals("红头龙背")){
                goldfishContent.append(getResources().getString(R.string.Hongtoulongbei));
            }else if(goldfishName.equals("龙背球")){
                goldfishContent.append(getResources().getString(R.string.Longbeiqiu));
            }

        }
        return goldfishContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
