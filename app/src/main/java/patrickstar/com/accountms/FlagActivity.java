package patrickstar.com.accountms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBFlag;

public class FlagActivity extends AppCompatActivity {
    public EditText text;
    public Button edit;
    public Button delete;
    public String id;//接收参数变量


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag2);

        Intent intent=getIntent();//创建Intent对象
        id= intent.getStringExtra("info");

        DBFlag dbFlag = new DBFlag(this);
        //dbFlag.


        //记录类型oast.makeText(InfoManage.this,"【数据】修改成功！", Toast.LENGTH_SHORT).show();
    }
}
