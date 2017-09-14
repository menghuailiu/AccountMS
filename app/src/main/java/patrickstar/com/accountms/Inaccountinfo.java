package patrickstar.com.accountms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import patrickstar.com.accountms.dao.tb_inaccountDao;
import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.model.tb_inaccount;

/**
 * Created by ios17 on 17/9/14.
 */

public class Inaccountinfo extends Activity {
    public static final String FLAG="id";//定义一个常量，用来作为请求码
    ListView lvinfo;//创建ListView对象
    String strType="";//创建字符串，记录管理类型
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lvinfo=(ListView)findViewById(R.id.lvinaccountinfo);//获取布局文件中的ListView组件
        ShowInfo(R.id.btnininfo);//调用自定义方法显示收入信息
        lvinfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String strInfo=String.valueOf(((TextView)view).getText());//记录收入信息
                String strid=strInfo.substring(0,strInfo.indexOf('|'));//从收入信息中截取收入编号
                Intent intent=new Intent(Inaccountinfo.this,InfoManage.class);//创建Intent对象
                intent.putExtra(FLAG,new String[]{strid,strType});//设置传递数据
                startActivity(intent);//执行Intent操作

            }
        });
    }
    private void ShowInfo(int inType){ //用来根据管理类显示相应的信息
        String[] strInfos=null;//定义字符串数组，用来存储收入信息
        ArrayAdapter <String> arrayAdapter=null;//创建arrayAdapter对象
        strType="btnininfo";//为strType变量赋值
        DBInAcount inaccountinfo=new DBInAcount(Inaccountinfo.this);//创建tb_inaccountDao对象
        //获取所有收入信息，并存储到List泛型集合中
        List<tb_inaccount>listinfos=inaccountinfo.getScrollData(0,(int)inaccountinfo.getConut());
        strInfos=new String[listinfos.size()];//设置字符串数组的长度
        int m=0;//定义一个开始标识
        for(tb_inaccount tb_inaccount:listinfos)
        {
            //将收入相关信息组合成一个字符串，存储到字符串数组的相应位置
            strInfos[m]=tb_inaccount.get_id()+"|"+tb_inaccount.getType()+""+String.valueOf(tb_inaccount.getMoney()) +"" +
                    "  元 "+tb_inaccount.getTime();
            m++;//标识加1
        }
        //使用字符串数组初始化ArrayAdapter对象
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strInfos);
        lvinfo.setAdapter(arrayAdapter);//为ListView列表设置数据源

    }
}
