package patrickstar.com.accountms;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.db.DBInAcount;

/**
 * Created by ios17 on 17/9/13.
 * ff
 */

public class AddInaccount extends Activity {
    protected  static final int DATE_DIALOG_ID=0;//创建日期对话框常量
    EditText txtInMoney,txtInTime,txtInHandler,txtInMark;//创建四个EditText对象
    Spinner spInType;//创建Spinner对象
    Button btnInSaveButton;//创建Button对象"保存"
    Button btnInCancelButton;//创建Button对象"取消"
    Button btnReturn;////创建Button对象"返回主页"
    ImageView image ;//设置图片
    private int mYear;//年
    private int mMonth;//月
    private int mDay;//日

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addinaccount);
        txtInMoney=(EditText)findViewById(R.id.txtInMoney);//获取"金额"文本框
        txtInTime=(EditText)findViewById(R.id. txtInTime);//获取"时间"文本框
        txtInHandler=(EditText)findViewById(R.id.txtInHandler);//获取"付款方式"文本框
        txtInMark=(EditText)findViewById(R.id.txtInMark);//获取"备注"文本框
        spInType=(Spinner)findViewById(R.id.spInType);//获取"类别"下拉列表
        btnInSaveButton=(Button)findViewById(R.id.btnInSave);//获取"保存"按钮
        btnInCancelButton=(Button)findViewById(R.id.btnInCancel);//获取"取消"按钮
        btnReturn=(Button)findViewById(R.id.btnReturn);//获取"返回主页面"按钮
        image=(ImageView)findViewById(R.id.image) ;

        txtInTime.setOnClickListener(new View.OnClickListener() {//为"时间"文本框设置单击监听事件
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);//显示日期选择对话框
            }
        });
        btnInSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//为"保存"按钮设置监听事件
                String strInMoney=txtInMoney.getText().toString();//获取"金额"文本框的值
                if(!strInMoney.isEmpty()){ //判断金额不为空
                    //创建InaccountDAO对象
                    DBInAcount inaccountDAO=new  DBInAcount(AddInaccount.this);
                    tb_inaccount  tbinaccount=new tb_inaccount();
                    tbinaccount.setHandler(txtInHandler.getText().toString());
                    tbinaccount.setMark(txtInMark.getText().toString());
                    tbinaccount.setMoney(Double.parseDouble(strInMoney));
                    tbinaccount.setTime(txtInTime.getText().toString());
                    tbinaccount.setType(spInType.getSelectedItem().toString());
                    tbinaccount.setId(Long.parseLong(String.valueOf(inaccountDAO.getMax()+1)));
                    long result=inaccountDAO.add(tbinaccount);
                    if(result>0)
                    {
                        //弹出信息提示
                        Toast.makeText(AddInaccount.this,"【新增收入】数据添加成功！",Toast.LENGTH_SHORT).show();
                    }
                }else
                {
                    Toast.makeText(AddInaccount.this,"请输入收入金额！",Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnInCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInMoney.setText("");//设置"金额"文本框为空
                txtInMoney.setHint("0.00");//设置"金额"文本框设置提示
                txtInTime.setText("");//设置"时间"文本框为空
                txtInTime.setHint("2011-01-01");//设置"时间"文本框设置提示
                txtInHandler.setText("");//设置"付款方式"文本框为空
                txtInMark.setText("");//设置"备注"文本框为空
                spInType.setSelection(0);//设置"类别下拉列表默认选择第一项
            }
        });
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final Calendar c=Calendar.getInstance();//获取系统当前日期
        mYear=c.get(Calendar.YEAR);//获取年份
        mYear=c.get(Calendar.MONTH);//获取月份
        mYear=c.get(Calendar.DAY_OF_MONTH);//获取天数
        updateDisplay();//显示当前系统时间*/
    }
        private void updateDisplay()
    {
        //显示设置的时间
        txtInTime.setText(new StringBuffer().append(mYear).append("-").append(mMonth +1).append("-").append(mDay));
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
       public void onDateSet(DatePicker view,int year,int monthOfYear,int dayOfMonth)
       {
           mYear=year;//为年份赋值
           mMonth=monthOfYear;//为月份赋值
           mDay=dayOfMonth;//为天赋值
           updateDisplay();//显示设置的日期
       }
    };

}
