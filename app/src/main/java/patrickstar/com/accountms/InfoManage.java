package patrickstar.com.accountms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBInAcount;
import patrickstar.com.accountms.db.DBOutAccount;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by ios17 on 17/9/14.
 */

public class InfoManage extends Activity {
    protected  static final int DATE_DIALOG_ID=0;//创建日期对话框常量
    TextView tvtitle,textView;//创建两个TextView对象
    EditText txtMoney,txtTime,txtHA,txtMark;//创建四个EditText对象
    Spinner spType;//创建Spinner对象
    Button btnEdit,btnDel,btninoutBack;//创建两个Button对象
    String [] strInfos;//定义字符串数组
    String strid,strType;//定义两个字符串变量，分别用来记录信息编号和管理类型
    private int mYear;//年
    private int mMonth;//月
    private int mDay;//日
    public String info;//接收的参数
    public tb_outaccount tboutaccount;
    public tb_inaccount inaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.infomanage);
        btninoutBack=(Button)findViewById(R.id.btnInOutBack);//获取返回按钮
        final DBOutAccount outaccountDAO=new DBOutAccount(InfoManage.this);//创建DBOutAccount对象
        final DBInAcount inAcount = new DBInAcount(InfoManage.this);
       // Toast.makeText(InfoManage.this, "进入",Toast.LENGTH_LONG).show();
        tvtitle=(TextView)findViewById(R.id.inouttitle);//获取标题标签对象
        textView=(TextView)findViewById(R.id.tvInOut) ;//获取"地点/付款方式"标签对象
        txtMoney=(EditText)findViewById(R.id.txtInOutMoney);//获取"金额"文本框
        txtTime=(EditText)findViewById(R.id. txtInOutTime);//获取"时间"文本框
        txtMark=(EditText)findViewById(R.id.txtInOutMark);//获取"备注"文本框
        txtHA=(EditText)findViewById(R.id.txtInOut) ;//获取"地点/付款方式"文本框对象
        spType=(Spinner)findViewById(R.id.spInOutType);//获取"类别"下拉列表
        btnEdit=(Button)findViewById(R.id.btnInOutEdit);//获取"修改"按钮
        btnDel=(Button)findViewById(R.id.btnInOutDelete);//获取"删除"按钮
        Intent intent=getIntent();//创建Intent对象
         info= intent.getStringExtra("info");


        //Toast.makeText(InfoManage.this, info,Toast.LENGTH_LONG).show();
        //Bundle budle=intent.getExtras();//获取传入的数据，并使用Bundle对象
        //strInfos=budle.getStringArray(Showinfo.FLAG);//获取Bundle中记录的信息
        strInfos = info.split(",");
        strid=strInfos[0];
        strType=strInfos[1];//记录类型
       if(strType.equals("btnoutinfo"))
        {
            tvtitle.setText("支出管理");//设置标题为"支出管理"
            textView.setText("地点：");//设置"地点/付款方"标签文本为"地点："
            //根据编号查找支出信息，并存储到tb_outaccount对象中
             tboutaccount=new DBOutAccount(this).find(Long.parseLong(strid));
            txtMoney.setText(String.valueOf(tboutaccount.getMoney()) );//显示金额
            txtTime.setText(tboutaccount.getTime());//显示时间
            spType.setPrompt(tboutaccount.getType());//显示类别
            txtHA.setText(tboutaccount.getAddress());//显示地点
            txtMark.setText(tboutaccount.getMark());//显示备注
        }
        else if(strType.equals("btnininfo"))
        {
            tvtitle.setText("收入管理");//设置标题为"收入管理"
            textView.setText("付款方：");//设置"地点/付款方"标签文本为"付款方："
            //根据编号查找支出信息，并存储到tb_outaccount对象中
             inaccount=new DBInAcount(this).find(Integer.parseInt(strid));
            txtMoney.setText(String.valueOf(inaccount.getMoney()) );//显示金额
            txtTime.setText(inaccount.getTime());//显示时间
            spType.setPrompt(inaccount.getType());//显示类别
            txtHA.setText(inaccount.getHandler());//显示付款方
            txtMark.setText(inaccount.getMark());//显示备注
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strType.equals("btnoutinfo"))//判断类型如果是btnoutinfo
                {

                    //tboutaccount.set_id(Integer.parseInt(strid));//设置编号
                    tboutaccount.setMoney(Double.parseDouble(txtMoney.getText().toString()) );//设置金额
                    tboutaccount.setTime(txtTime.getText().toString());//设置时间
                    tboutaccount.setType(spType.getSelectedItem().toString());//设置类别
                    tboutaccount.setAddress(txtHA.getText().toString());//设置地点
                    tboutaccount.setMark(txtMark.getText().toString());//设置备注
                    if(outaccountDAO.update(tboutaccount)){
                        Toast.makeText(InfoManage.this,"【数据】修改成功！",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(InfoManage.this,"【数据】修改失败！",Toast.LENGTH_SHORT).show();

                    };//更新支出信息
                }
                else if(strType.equals("btnininfo")){
                    //tb_inaccount tbinaccount=new  tb_inaccount();//创建tb_outaccount对象
                    //tbinaccount.set_id(Integer.parseInt(strid));//设置编号

                    inaccount.setMoney(Double.parseDouble(txtMoney.getText().toString()) );//设置金额
                    inaccount.setTime(txtTime.getText().toString());//设置时间
                    inaccount.setType(spType.getSelectedItem().toString());//设置类别
                    inaccount.setHandler(txtHA.getText().toString());//设置付款方
                    inaccount.setMark(txtMark.getText().toString());//设置备注
                    if(inAcount.update(inaccount)){
                        Toast.makeText(InfoManage.this,"【数据】修改成功！",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(InfoManage.this,"【数据】修改失败！",Toast.LENGTH_SHORT).show();
                    };//更新收入信息
                }
                //弹出信息提示
               // Toast.makeText(InfoManage.this,"【数据】修改成功！",Toast.LENGTH_SHORT).show();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(strType.equals("btnininfo"))
                {
                   if( inAcount.deleteById(Integer.parseInt(strid))){
                       Toast.makeText(InfoManage.this,"【数据】删除成功！",Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(InfoManage.this,"【数据】删除失败！",Toast.LENGTH_SHORT).show();
                   }
                }
                else if(strType.equals("btnoutinfo"))
                {
                    if(outaccountDAO.deleteById(Long.parseLong(strid))){
                        Toast.makeText(InfoManage.this,"【数据】删除成功！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(InfoManage.this,"【数据】删除失败！",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btninoutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
