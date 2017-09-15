package com.xiaoke.accountsoft.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import patrickstar.com.accountms.R;

public class MainActivity extends Activity {

    GridView gvInfo;

    //定义字符串数组，存储系统功能的文本s
    String[] titles = new String[]{"新增支出","新增收入","我的支出","我的收入","数据管理","系统设置","收支便签","退出"};

    //定义int数组，存储功能对应图标
    int[] images = new int[]{R.drawable.addoutaccount,R.drawable.addinaccount,R.drawable.outaccountinfo,
    R.drawable.inaccountifo,R.drawable.showinfo,R.drawable.sysset,R.drawable.accountflag,R.drawable.exit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        gvInfo = (GridView)findViewById(R.id.gvInfo);

        pictureAdapter adapter = new pictureAdapter(titles,images,this);//创建pictureAdapter对象
        gvInfo.setAdapter(adapter);//为GridView设置数据


        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                Intent intent = null;

                switch (arg2){
                    case 0:
                        //使用AddOutaccount窗口初始化Intent
                       intent = new Intent(MainActivity.this,patrickstar.com.accountms.AddOutAccount.class);
                        startActivity(intent);
                        break;


                    case 1:
                        //使用AddInaccount窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.AddInaccount.class);
                        startActivity(intent);
                        break;

                    case 2:
                        //使用Outaccountinfo窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.OutAccountInfo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //使用Inaccountinfo窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.Inaccountinfo.class);
                        startActivity(intent);
                        break;

                    case 4:
                        //使用AddOutaccount窗口初始化Intent
                     /*   intent = new Intent(MainActivity.this,Showinfo.class);
                        startActivity(intent);*/
                        break;
                    case 5:
                        //使用Sysset窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.Sysset.class);
                        startActivity(intent);
                        break;
                    case 6:
                        //使用Accountflag窗口初始化Intent
                        /*intent = new Intent(MainActivity.this,Accountflag.class);
                        startActivity(intent);*/
                        break;
                    case 7:
                       finish();//若点击的是关闭，则关闭当前Activity



                }

            }
        });


    }

}
