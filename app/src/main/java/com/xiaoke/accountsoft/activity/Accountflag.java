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

public class Accountflag extends Activity {
    EditText txtFlag;
    Button btnflagSaveButton;
    Button btnflagCanceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accountflag);

        txtFlag = (EditText)findViewById(R.id.txtFlag);
        btnflagCanceButton = (Button)findViewById(R.id.btnflagCancel);
        btnflagSaveButton = (Button)findViewById(R.id.btnflagSave);


        //点击保存时，保存输入信息
        btnflagSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String strFlag = txtFlag.getText().toString();
                if(!strFlag.isEmpty())
                {/**
                     DBFlag  flagDAO = new DBFlag(Accountflag.this);
                     tb_flag tbf = new tb_flag(flagDAO.getMax()+1,strFlag);
                     flagDAO.add(tbf);*/
                    Toast.makeText(Accountflag.this,"新便签添加成功！",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Accountflag.this,"请输入便签内容！",Toast.LENGTH_SHORT).show();
                }

            }
        });

        //点击取消时，清空输入信息
        btnflagCanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                txtFlag.setText("");//清空便签文本框
            }
        });

    }

}
