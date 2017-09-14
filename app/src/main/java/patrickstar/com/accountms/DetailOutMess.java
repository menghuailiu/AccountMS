package patrickstar.com.accountms;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import patrickstar.com.accountms.db.DBOutAccount;

public class DetailOutMess extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailoutmess);

    }
    protected static final int DATE_DIALOG_ID=0;//创建日期对话框常量
    TextView tvTitle,textView;//创建两个TextView对象
    EditText txMoney,txTime,TxAdd,txMark;//创建4个edittext对象
    Spinner spType;
    Button btnEdit,btnDel;//创建两个button对象
    String[] strInfo;//定义字符串数组
    String stride,strType;//定义两个字符串，用来记录信息编号和管理类型
    private int mYear;//定义年
    private int mMonth;//月
    private int mDay;//日
    DBOutAccount outaccountDao=new DBOutAccount(DetailOutMess.this);


}
