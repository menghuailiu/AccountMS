package patrickstar.com.accountms;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBFlag;
import patrickstar.com.accountms.model.tb_flag;

public class FlagActivity extends AppCompatActivity {
    public EditText text;
    public Button edit;
    public Button delete;
    public String id;//接收参数变量 时代大厦


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();//创建Intent对象
        id= intent.getStringExtra("info");



        final DBFlag dbFlag = new DBFlag(this);
        final tb_flag flag = dbFlag.find(Integer.parseInt(id));

        text= (EditText) findViewById(R.id.txtFlag);
        edit = (Button) findViewById(R.id.btnflagSave);
        delete = (Button) findViewById(R.id.btnflagCancel);
        text.setText(flag.getFlag());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag.setFlag(text.getText().toString());
                if(dbFlag.update(flag)){
                    Toast.makeText(FlagActivity.this,"【数据】修改成功！",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(FlagActivity.this,"【数据】修改失败！",Toast.LENGTH_SHORT).show();

                }

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dbFlag.deleteById(Long.parseLong(id))){
                    Toast.makeText(FlagActivity.this,"【数据】删除成功！",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent1 = new Intent(FlagActivity.this,fl_MainActivity.class);
                    startActivity(intent1);
                }
                else{
                    Toast.makeText(FlagActivity.this,"【数据】删除失败！",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //记录类型oast.makeText(InfoManage.this,"【数据】修改成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Toast.makeText(fl_MainActivity.this,"返回主界面",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, com.xiaoke.accountsoft.activity.MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}
