package patrickstar.com.accountms;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by ios17 on 17/9/13.
 */

public class AddInaccount extends Activity {
    protected  static final int DATE_DIALOG_ID=0;//创建日期对话框常量
    EditText txtInMoney,txtInTime,txtInHandler,txtInMark;//创建四个EditText对象
    Spinner spInType;//创建Spinner对象
    Button btnInSaveButton;//创建Button对象"保存"
    Button btnInCancelButton;//创建Button对象"取消"
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
    }
}
