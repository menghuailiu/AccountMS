package patrickstar.com.accountms;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
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
    public String[] tbsize;
    ArrayAdapter<String> adapter =null;
    public static final  String FLAG= "id";
    String strType="";




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
        //edit = (Button) findViewById(R.id.edit);
        //  find(Integer.parseInt(strid));
        //chk = (CheckBox) findViewById(R.id.chk1);
       /* edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(fl_MainActivity.this, "编辑", Toast.LENGTH_SHORT).show();
                //chk.setChecked(true);
            }
        });*/

        listView = (ListView) findViewById(R.id.listview);


        iData = this.getInData();
      /*  oData = this.getOutData();
        fData = this.getFData();*/



      DBInAcount acount=new DBInAcount(fl_MainActivity.this);
        List<tb_inaccount> tb= acount.findAll();
        tbsize = new String[tb.size()];
        strType ="btnininfo";
        int  m = 0;
        for(tb_inaccount inaccount:tb){
            tbsize[m] = inaccount.getId()+"|"+inaccount.getType()+String.valueOf(inaccount.getMoney())+"元"+inaccount.getTime();
            m++;
        }
      adapter=new ArrayAdapter<String>(fl_MainActivity.this,android.R.layout.simple_expandable_list_item_1,tbsize);
      listView.setAdapter(adapter);

       /* myAdapter = new MyAdapter(this, iData, 0);
        listView.setAdapter(myAdapter);*/

        zhichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strType = "btnoutinfo";
                List<tb_outaccount> list = getOutData();
                tbsize = new String [list.size()];
                int  m = 0;
                for(tb_outaccount outaccount:list){
                    tbsize[m] = outaccount.getId()+"|"+outaccount.getType()+String.valueOf(outaccount.getMoney())+"元"+outaccount.getTime();
                    m++;
                }
                adapter=new ArrayAdapter<String>(fl_MainActivity.this,android.R.layout.simple_expandable_list_item_1,tbsize);
                listView.setAdapter(adapter);

            }
        });

        shouru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strType = "btnininfo";
                List<tb_inaccount> tb= getInData();
                tbsize = new String[tb.size()];
                int  m = 0;
                for(tb_inaccount inaccount:tb){
                    tbsize[m] = inaccount.getId()+"|"+inaccount.getType()+String.valueOf(inaccount.getMoney())+"元"+inaccount.getTime();
                    m++;
                }
                adapter=new ArrayAdapter<String>(fl_MainActivity.this,android.R.layout.simple_expandable_list_item_1,tbsize);
                listView.setAdapter(adapter);

            }
        });

        bianqian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strType = "btnflaginfo";
                List<tb_flag> tb= getFData();
                tbsize = new String[tb.size()];
                int  m = 0;
                for(tb_flag inaccount:tb){
                    tbsize[m] = inaccount.getId()+","+inaccount.getFlag();
                    m++;
                }
                adapter=new ArrayAdapter<String>(fl_MainActivity.this,android.R.layout.simple_expandable_list_item_1,tbsize);
                listView.setAdapter(adapter);

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String strinfo = String.valueOf(((TextView)view).getText());
                String strid = strinfo.substring(0,strinfo.indexOf("|"));
                Toast.makeText(fl_MainActivity.this, strid,Toast.LENGTH_LONG).show();
                if(strType=="btnflaginfo"){
                    Intent intent  = new Intent(fl_MainActivity.this,"");
                    intent.putExtra("info",strid);
                    startActivity(intent);
                }else{
                Intent intent = new Intent(fl_MainActivity.this,InfoManage.class);
                intent.putExtra("info",strid+","+strType);
                startActivity(intent);}
            }
        });




         }
        //获取所有收入信息
        public List<tb_inaccount> getInData () {
            List<tb_inaccount> list = new ArrayList<tb_inaccount>();
            DBInAcount dbInAcount = new DBInAcount(this);
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
