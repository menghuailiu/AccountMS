package patrickstar.com.accountms;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by ios17 on 17/9/14.
 */

public class InfoManage extends AppCompatActivity {
    protected static final int DATE_DIALOG_ID = 0;//创建日期对话框常量
    TextView tvtitle, textView;//创建两个TextView对象
    EditText txtMoney, txtTime, txtHA, txtMark;//创建四个EditText对象
    Spinner spType;//创建Spinner对象
    Button btnEdit, btnDel;//创建两个Button对象
    String[] strInfos;//定义字符串数组
    String strid, strType;//定义两个字符串变量，分别用来记录信息编号和管理类型
    private int mYear;//年
    private int mMonth;//月
    private int mDay;//日
    public String info;//接收的参数
    public tb_outaccount tboutaccount;
    public tb_inaccount inaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infomanage);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //btninoutBack = (Button) findViewById(R.id.btnInOutBack);//获取返回按钮
        final DBOutAccount outaccountDAO = new DBOutAccount(InfoManage.this);//创建DBOutAccount对象
        final DBInAcount inAcount = new DBInAcount(InfoManage.this);
        tvtitle = (TextView) findViewById(R.id.inouttitle);//获取标题标签对象
        textView = (TextView) findViewById(R.id.tvInOut);//获取"地点/付款方式"标签对象
        txtMoney = (EditText) findViewById(R.id.txtInOutMoney);//获取"金额"文本框
        txtTime = (EditText) findViewById(R.id.txtInOutTime);//获取"时间"文本框
        txtMark = (EditText) findViewById(R.id.txtInOutMark);//获取"备注"文本框
        txtHA = (EditText) findViewById(R.id.txtInOut);//获取"地点/付款方式"文本框对象
        spType = (Spinner) findViewById(R.id.spInOutType);//获取"类别"下拉列表
        btnEdit = (Button) findViewById(R.id.btnInOutEdit);//获取"修改"按钮
        btnDel = (Button) findViewById(R.id.btnInOutDelete);//获取"删除"按钮
        Intent intent = getIntent();//创建Intent对象
        info = intent.getStringExtra("info");
        txtTime.setOnClickListener(new View.OnClickListener() {//为"时间"文本框设置单击监听事件
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);//显示日期选择对话框
            }
        });
        final Calendar c=Calendar.getInstance();//获取系统当前日期
        mYear=c.get(Calendar.YEAR);//获取年份
        mMonth=c.get(Calendar.MONTH);//获取月份
        mDay=c.get(Calendar.DAY_OF_MONTH);//获取天数
        updateDisplay();//显示当前系统时间*/


        strInfos = info.split(",");
        strid = strInfos[0];
        strType = strInfos[1];//记录类型
        if (strType.equals("btnoutinfo")) {
            tvtitle.setText("支出管理");//设置标题为"支出管理"
            textView.setText("地点：");//设置"地点/付款方"标签文本为"地点："
            //根据编号查找支出信息，并存储到tb_outaccount对象中
            tboutaccount = new DBOutAccount(this).find(Long.parseLong(strid));
            txtMoney.setText(String.valueOf(tboutaccount.getMoney()));//显示金额
            txtTime.setText(tboutaccount.getTime());//显示时间
            spType.setPrompt(tboutaccount.getType());//显示类别
            txtHA.setText(tboutaccount.getAddress());//显示地点
            txtMark.setText(tboutaccount.getMark());//显示备注
        } else if (strType.equals("btnininfo")) {
            tvtitle.setText("收入管理");//设置标题为"收入管理"
            textView.setText("付款方：");//设置"地点/付款方"标签文本为"付款方："
            //根据编号查找支出信息，并存储到tb_outaccount对象中
            inaccount = new DBInAcount(this).find(Integer.parseInt(strid));
            txtMoney.setText(String.valueOf(inaccount.getMoney()));//显示金额
            txtTime.setText(inaccount.getTime());//显示时间
            spType.setPrompt(inaccount.getType());//显示类别
            txtHA.setText(inaccount.getHandler());//显示付款方
            txtMark.setText(inaccount.getMark());//显示备注
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (strType.equals("btnoutinfo"))//判断类型如果是btnoutinfo
                {
                    tboutaccount.setMoney(Double.parseDouble(txtMoney.getText().toString()));//设置金额
                    tboutaccount.setTime(txtTime.getText().toString());//设置时间
                    tboutaccount.setType(spType.getSelectedItem().toString());//设置类别
                    tboutaccount.setAddress(txtHA.getText().toString());//设置地点
                    tboutaccount.setMark(txtMark.getText().toString());//设置备注
                    if (outaccountDAO.update(tboutaccount)) {
                        Toast.makeText(InfoManage.this, "【数据】修改成功！", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InfoManage.this, "【数据】修改失败！", Toast.LENGTH_SHORT).show();

                    }
                    ;//更新支出信息
                } else if (strType.equals("btnininfo")) {

                    inaccount.setMoney(Double.parseDouble(txtMoney.getText().toString()));//设置金额
                    inaccount.setTime(txtTime.getText().toString());//设置时间
                    inaccount.setType(spType.getSelectedItem().toString());//设置类别
                    inaccount.setHandler(txtHA.getText().toString());//设置付款方
                    inaccount.setMark(txtMark.getText().toString());//设置备注
                    if (inAcount.update(inaccount)) {
                        Toast.makeText(InfoManage.this, "【数据】修改成功！", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InfoManage.this, "【数据】修改失败！", Toast.LENGTH_SHORT).show();
                    }
                    ;//更新收入信息
                }

            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(InfoManage.this);
                builder.setTitle("确认");
                builder.setMessage("确认删除该记录？");
                builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (strType.equals("btnininfo")) {

                            if (inAcount.deleteById(Integer.parseInt(strid))) {
                                //String result = inAcount.deleteById(Integer.parseInt(strid));
                                Toast.makeText(InfoManage.this, "【数据】删除成功！", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(InfoManage.this,fl_MainActivity.class));
                                //finish();
                            } else {
                                Toast.makeText(InfoManage.this, "【数据】删除失败！", Toast.LENGTH_SHORT).show();
                            }
                        } else if (strType.equals("btnoutinfo")) {
                            if (outaccountDAO.deleteById(Long.parseLong(strid))) {
                                Toast.makeText(InfoManage.this, "【数据】删除成功！", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(InfoManage.this,fl_MainActivity.class));
                                fl_MainActivity.test();

                            } else {
                                Toast.makeText(InfoManage.this, "【数据】删除失败！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                builder.setNegativeButton("取消", null);
                builder.show();




            }
        });
       /* btninoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(fl_MainActivity.this,"返回主界面",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, fl_MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    private void updateDisplay()
    {
        txtTime.setText("");
        //显示设置的时间
        txtTime.setText(new StringBuffer().append(mYear).append("-").append(mMonth +1).append("-").append(mDay));
    }
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
        }
        return null;
    }
    private  DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
        {
            mYear=year;//为年份赋值
            mMonth=monthOfYear;//为月份赋值
            mDay=dayOfMonth;//为天赋值
            updateDisplay();//显示设置的日期
        }
    };

}
