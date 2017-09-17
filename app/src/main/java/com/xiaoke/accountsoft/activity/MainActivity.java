package com.xiaoke.accountsoft.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextPaint;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import patrickstar.com.accountms.Login;
import patrickstar.com.accountms.R;
import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.fl_MainActivity;

public class MainActivity extends Activity {

    GridView gvInfo;

    //定义字符串数组，存储系统功能的文本
    String[] titles = new String[]{"新增支出","我的支出","新增收入","我的收入","数据管理","系统设置","收支便签","我的账单","退出"};

    //定义int数组，存储功能对应图标
    int[] images = new int[]{R.drawable.xinzengzhichu,R.drawable.wdzhichu,R.drawable.xinzengshouru,
            R.drawable.wdshouru,R.drawable.xitongshezhi,R.drawable.shujuguanli,R.drawable.shouzhibianqian,
            R.drawable.tubiao5,R.drawable.tubiao1};

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
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.OutAccountInfo.class);
                        startActivity(intent);
                        break;

                    case 2:
                        //使用Outaccountinfo窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.AddInaccount.class);
                        startActivity(intent);
                        break;
                    case 3:
                        //使用Inaccountinfo窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.Inaccountinfo.class);
                        startActivity(intent);
                        break;

                    case 4:
                        //使用AddOutaccount窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.fl_MainActivity.class);
                        startActivity(intent);

                        break;
                    case 5:
                        //使用Sysset窗口初始化Intent
                        intent = new Intent(MainActivity.this,patrickstar.com.accountms.Sysset.class);
                        startActivity(intent);
                        break;
                    case 6:
                        //使用Accountflag窗口初始化Intent
                        intent = new Intent(MainActivity.this,Accountflag.class);
                        startActivity(intent);
                        break;
                    case 7:
                        //若点击我的账单，进入我的账单页面
                        intent = new Intent(MainActivity.this,Revenue.class);
                        startActivity(intent);
                        break;
                    case 8:
                        finish();//若点击的是关闭，则关闭当前Activity

                        //新增  罗
                        Intent intent1 = new Intent(Intent.ACTION_MAIN,null);
                        intent1.addCategory(Intent.CATEGORY_HOME);
                        startActivity(intent1);
                }

            }
        });

        /**
        //添加代码  罗  用于显示用户总收入，总支出，余额
        long income=new DBInAcount(MainActivity.this).sum();
        long outaccount=new DBOutAccount(MainActivity.this).sum();
        long balance=income-outaccount;//余额
        AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("收支情况");
        alertDialog.setMessage("总收入:"+income+"元，\n"+"总支出："+outaccount+"元，\n"+"余额:"+balance+"元");
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();*/



       /* WindowManager wm = this.getWindowManager();
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();*/
       /** TextView szqk=(TextView)findViewById(R.id.szqk);
        TextPaint tp = szqk.getPaint();
        tp.setFakeBoldText(true);

        TextView tvin=(TextView)findViewById(R.id.etinaccount);
        TextView tvout=(TextView)findViewById(R.id.etoutaccount);
        TextView tvba=(TextView)findViewById(R.id.etbalance);
        tvin.setText(income+"¥");
        tvout.setText(outaccount+"¥");
        tvba.setText(balance+"¥");*/
    }

}
