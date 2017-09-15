package patrickstar.com.accountms;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import patrickstar.com.accountms.db.DBFlag;
import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.model.tb_flag;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;


public class fl_MainActivity extends AppCompatActivity {

    private Button edit;
    private ListView  listView;
    public List<tb_outaccount> oData;
    public List<tb_inaccount> iData;
    public List<tb_flag> fData;
    private CheckBox chk;
    private MyAdapter myAdapter;
    private Button zhichu;
    private Button shouru;
    private Button bianqian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fl_activity_main);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.action_bar);
        actionBar.show();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayHomeAsUpEnabled(true);
            //actionBar.setHomeAsUpIndicator(R.drawable.notify);

        }

        zhichu = (Button) findViewById(R.id.zhichu);
        shouru = (Button) findViewById(R.id.shouru);
        bianqian = (Button) findViewById(R.id.bianqian);


        //action 编辑按钮
        edit = (Button) findViewById(R.id.edit);
        //chk = (CheckBox) findViewById(R.id.chk1);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(fl_MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
                //chk.setChecked(true);
            }
        });

        listView = (ListView) findViewById(R.id.listview);


       iData = this.getInData();
        /*oData = this.getOutData();
        fData = this.getFData();*/
        /*myAdapter = new MyAdapter(this, iData, 0);
        listView.setAdapter(myAdapter);*/



         }
        //获取所有收入信息
        public List<tb_inaccount> getInData () {
            List<tb_inaccount> list = new ArrayList<tb_inaccount>();
            DBInAcount dbInAcount = new DBInAcount(this);
           /* tb_inaccount tb = new tb_inaccount();
            tb.setMoney(100.0);
            tb.setType("红包");
            tb.setMark("测试");
            tb.setHandler("fl");
            tb.setTime("2017-9-14");
            String i = String.valueOf(dbInAcount.add(tb));
            Log.v("debug",i);*/
            list = dbInAcount.findAll();
            return list;
        }

        //支出信息
        public List<tb_outaccount> getOutData () {
            List<tb_outaccount> list = new ArrayList<tb_outaccount>();
            DBOutAccount dbOutAccount = new DBOutAccount(this);
            list  = dbOutAccount.findAll();
            return list;
        }

        //便签信息
        public List<tb_flag> getFData () {
            List<tb_flag> list = new ArrayList<tb_flag>();
            DBFlag dbFlag = new DBFlag(this);
            list  = dbFlag.query();
            return list;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            Toast.makeText(fl_MainActivity.this,"返回主界面",Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(this,TestActivity.class);
            startActivity(intent);*/
            return super.onOptionsItemSelected(item);
        }


}
