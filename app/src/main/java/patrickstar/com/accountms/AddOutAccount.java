package patrickstar.com.accountms;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.model.tb_outaccount;

/*import patrickstar.com.accountms.dao.tb_outaccountDao;*/
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by 秧心媛 on 17/9/14.
 * 添加支出记录
 */

public class AddOutAccount extends Activity {
    protected  static final int DATE_DIALOG_ID=0;//创建日期对话框常量
    EditText txOutMoney,txtOutTime,txOutAddress,txOutMark;//创建四个EditText对象
    Spinner spOutType;//创建Spinner对象
    Button btnOutSave;//创建Button对象"保存"
    Button btnOutCancel;//创建Button对象"取消"
    private int mYear;//年
    private int mMonth;//月
    private int mDay;//日
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addoutaccount);
        txOutMoney=(EditText)findViewById(R.id.txOutMoney);//获取"金额"文本框
        txtOutTime=(EditText)findViewById(R.id.txtOutTime);//获取"时间"文本框
        txOutAddress=(EditText)findViewById(R.id.txOutAddress);//获取"付款方式"文本框
        txOutMark=(EditText)findViewById(R.id.txOutMark);//获取"备注"文本框
        spOutType=(Spinner)findViewById(R.id.spOutType);//获取"类别"下拉列表
        btnOutSave=(Button)findViewById(R.id.btnOutSave);//获取"保存"按钮
        btnOutCancel=(Button)findViewById(R.id.btnOutCancel);//获取"取消"按钮

        //点击获取时间
        txtOutTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);
            }
        });

            final Calendar c=Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);
            updateDisplay();


        //点击保存按钮触发
        btnOutSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String txtOtMoney=txOutMoney.getText().toString();//获取金额文本框
                if(!txtOtMoney.isEmpty()){//判断金额不为空
                    //
                    DBOutAccount outaccountDao=new DBOutAccount(AddOutAccount.this);
                    tb_outaccount tboutaccount=new tb_outaccount();
                    tboutaccount.setId(Long.parseLong(String.valueOf(outaccountDao.getMaxId()+1)));
                    tboutaccount.setType(spOutType.getSelectedItem().toString());
                    tboutaccount.setMark(txOutMark.getText().toString());
                    tboutaccount.setAddress(txOutAddress.getText().toString());
                    tboutaccount.setTime(txtOutTime.getText().toString());
                    tboutaccount.setMoney(Double.parseDouble(txtOtMoney));
                            /*(outaccountDao.getMaxId()+1,Double.parseDouble(txtOtMoney)
                    ,txtOutTime.getText().toString(),spOutType.getSelectedItem().toString(),
                            txOutAddress.getText().toString(),
                            txOutMark.getText().toString());*/
                    outaccountDao.add(tboutaccount);
                    //弹出提示框
                    Toast.makeText(AddOutAccount.this,"【新增支出】数据添加成功！",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddOutAccount.this,"请输入支出金额！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnOutCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        }
    private void updateDisplay(){
        txtOutTime.setText(new
                StringBuffer().append(mYear).append("-").append(mMonth+1).append(mDay));


    }
    private DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        }
        public void onDateSet(){
            mYear=mYear;
            mMonth=mMonth;
            mDay=mDay;
            updateDisplay();
        }
    };
    @Override
    public Dialog onCreateDialog(int id){
        switch (id){
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,mDateSetListener,mYear,mMonth,mDay);
        }
        return null;
    }



}
