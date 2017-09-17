package com.xiaoke.accountsoft.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import patrickstar.com.accountms.R;
import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.db.DBOutAccount;


/**
 * 注解：收支情况后台，对应的布局文件是revenue.xml文件
 */
public class Revenue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.revenue);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


          //添加代码  罗  用于显示用户总收入，总支出，余额
         long income=new DBInAcount(Revenue.this).sum();//获得总收入数据
         long outaccount=new DBOutAccount(Revenue.this).sum();//获得总支出数据
         long balance=income-outaccount;//余额

/**
         AlertDialog alertDialog=new AlertDialog.Builder(Revenue.this).create();
         alertDialog.setTitle("收支情况");
         alertDialog.setMessage("总收入:"+income+"元，\n"+"总支出："+outaccount+"元，\n"+"余额:"+balance+"元");
         alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

        }
        });
         alertDialog.show();*/

        /** TextView szqk=(TextView)findViewById(R.id.szqk);
         TextPaint tp = szqk.getPaint();
         tp.setFakeBoldText(true);*/

        //绑定数据，显示出来
         TextView tvin=(TextView)findViewById(R.id.etinaccount);
         TextView tvout=(TextView)findViewById(R.id.etoutaccount);
         TextView tvba=(TextView)findViewById(R.id.etbalance);
         tvin.setText(income+"¥");
         tvout.setText(outaccount+"¥");
         tvba.setText(balance+"¥");

        //判断收支情况，进行提示
        if(outaccount>balance)//支出大于余额
        {
            Toast.makeText(Revenue.this,"小主，透支了，请勤俭持家哦",Toast.LENGTH_LONG).show();
        }
        else if(outaccount<income)
        {
            Toast.makeText(Revenue.this,"小主，还有很多钱，赶紧去剁手吧",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(Revenue.this,"小主，勤俭持家的小能手",Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(fl_MainActivity.this,"返回主界面",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, com.xiaoke.accountsoft.activity.MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }


}
