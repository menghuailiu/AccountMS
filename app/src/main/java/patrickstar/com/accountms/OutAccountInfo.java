package patrickstar.com.accountms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import greendao.gen.*;
import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.model.tb_outaccount;


/**
 * Created by 秧心媛 on 17/9/14.
 * 显示所有支出信息
 */

public class OutAccountInfo extends Activity {
    public static final String FLAG="id";//定义一个常量，作为请求码
    ListView lvOutinfo;
    String strType="";//创建字符串    ，记录管理类型
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outaccountinfo);

       lvOutinfo=(ListView)findViewById(R.id.lvOutacountInfo);//获取布局文件中的listView
        btnback=(Button)findViewById(R.id.btnBack);
      //  ShowInfo(R.id.btninfo);

        String[] strInfo=null;
        ArrayAdapter<String> arrayAdapter=null;//定义字符串数组存储收入信息
        strType="btninfo";
        DBOutAccount outaccountinfo=new DBOutAccount(OutAccountInfo.this);
        //获取所有信息存储到泛型集合list中
        int i=outaccountinfo.getCount();
        List<tb_outaccount> listinfo=outaccountinfo.getScrollData(0,i);
        strInfo=new String[listinfo.size()];//设置字符串数组的长度
        int m=0;
        for(tb_outaccount tboutaccount:listinfo){
            //将收入相关信息组合成一个字符串，存储到字符串数组的相应位置
            strInfo[m]=tboutaccount.getId()+"|"+tboutaccount.getType()+""+String.valueOf(tboutaccount.getMoney())+"元"+tboutaccount.getTime();
            m++;

        }
        //使用字符串数组初始化arrayadapter对象
        ArrayAdapter arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfo);
        lvOutinfo.setAdapter(arrayAdapter1);
        //点击查看详细信息界面
        lvOutinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           //方法覆写
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strinf=String.valueOf(((TextView)view).getText());//记录支出信息
                String strid=strinf.substring(0,strinf.indexOf('|'));//从收入信息中截取编号
                Intent intent=new Intent(OutAccountInfo.this,InfoManage.class);//创建intent对象
                intent.putExtra("info",strid+","+"btnoutinfo");
                startActivity(intent);//执行intent操作
            }
        });
        //返回按钮
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void ShowInfo(int intType){
     /*  String[] strInfo=null;
        ArrayAdapter<String> arrayAdapter=null;//定义字符串数组存储收入信息
        strType="btninfo";
        tb_outaccountDao outaccountinfo=new  tb_outaccountDao(OutAccountInfo.this);
        //获取所有信息存储到泛型集合list中
        List<tb_outaccount> listinfo=outaccountinfo.getScrollData(0,(int)outaccountinfo.getCount());
        strInfo=new String[listinfo.size()];//设置字符串数组的长度
        int m=0;
        for(tb_outaccount tboutaccount:listinfo){
            //将收入相关信息组合成一个字符串，存储到字符串数组的相应位置
            strInfo[m]=tboutaccount.get_id()+"|"+tboutaccount.getType()+""+String.valueOf(tboutaccount.getMoney())+"元"+tboutaccount.getTime();
            m++;

        }
        //使用字符串数组初始化arrayadapter对象
        ArrayAdapter arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfo);
        listinfo.setAdapter(arrayAdapter1);*/
    }

}
