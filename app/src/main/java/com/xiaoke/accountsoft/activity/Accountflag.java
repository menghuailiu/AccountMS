package com.xiaoke.accountsoft.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import patrickstar.com.accountms.R;
import patrickstar.com.accountms.db.DBFlag;
import patrickstar.com.accountms.model.tb_flag;

/**
 * 新增便签
 */
public class Accountflag extends Activity {
    EditText txtFlag;
    Button btnflagSaveButton;
    Button btnflagCanceButton;
    Button btnflagsavebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountflag);

        txtFlag = (EditText)findViewById(R.id.txtFlag);
        btnflagCanceButton = (Button)findViewById(R.id.btnflagCancel);
        btnflagSaveButton = (Button)findViewById(R.id.btnflagSave);
        btnflagsavebtn = (Button)findViewById(R.id.btnflagSave1);//返回主页的按钮

/*
        //点击保存时，保存输入信息
        btnflagSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

              String strFlag = txtFlag.getText().toString();
                if(!strFlag.isEmpty())
                {
                     DBFlag  flagDAO = new DBFlag(Accountflag.this);
                     tb_flag tbf = new tb_flag();
                    tbf.setId(Long.parseLong(String.valueOf(flagDAO.getMax()+1)));
                    tbf.setFlag(strFlag);
                     flagDAO.insert(tbf);
                    Toast.makeText(Accountflag.this,"新便签添加成功！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Accountflag.this,"请输入便签内容！",Toast.LENGTH_SHORT).show();
                }

            }
        });
*/
        //点击取消时，清空输入信息
        btnflagCanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String strFlag = txtFlag.getText().toString();
                //判断便签内容是否为空
                if(!strFlag.isEmpty())
                {
                    txtFlag.setText("");//清空便签文本框
                }else
                    {
                        Toast.makeText(Accountflag.this,"还未输入便签内容！",Toast.LENGTH_SHORT).show();
                }


            }
        });

        //点击主页时，关闭当前Activity，返回主界面
        btnflagsavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//关闭当前Activity
            }
        });

    }

}
