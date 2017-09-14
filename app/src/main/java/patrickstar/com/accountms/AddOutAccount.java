package patrickstar.com.accountms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by ios18 on 17/9/14.
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

        txtOutTime.setOnClickListener(new View.OnClickListener() {//为"时间"文本框设置单击监听事件
            @Override
            public void onClick(View view) {
                showDialog(DATE_DIALOG_ID);//显示日期选择对话框
            }
        });
        //final Calendar c=Calendar.getInstance();
    }
}
