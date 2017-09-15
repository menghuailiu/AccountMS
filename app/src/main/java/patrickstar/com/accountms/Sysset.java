package patrickstar.com.accountms;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBPwd;
import patrickstar.com.accountms.model.tb_pwd;


/**
 * Created by 静静 on 17/9/13.
 */

public class Sysset extends AppCompatActivity {

    EditText txtpwd;                                                    //创建EditText对象
    Button btnSet,btnsetCancel;                                         //创建两个Button对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sysset);

        txtpwd=(EditText)findViewById(R.id.txtPwd);                     //获取密码文本框
        btnSet=(Button)findViewById(R.id.btnSet);                       //获取"设置"按钮
        btnsetCancel=(Button)findViewById(R.id.btnsetCancel);           //获取"取消"按钮
        btnSet.setOnClickListener(new View.OnClickListener() {          //为"设置"按钮添加监听事件
            @Override
            public void onClick(View arg0) {

                DBPwd pwdDAO=new DBPwd(Sysset.this);
                //创建PwdDAO对象
                tb_pwd pwd  =pwdDAO.getpwd();
                pwd.setPassword(txtpwd.getText().toString());
                try {
                    boolean bo = pwdDAO.update(pwd);
                    if (bo == false) {
                        Toast.makeText(Sysset.this,"密码修改失败",Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(Sysset.this,"密码修改成功",Toast.LENGTH_LONG).show();
                        finish();
                    }
                }catch (Exception ex)
                {
                    Toast.makeText(Sysset.this,"密码修改失败",Toast.LENGTH_LONG).show();
                }
              /*  if(pwdDAO.getCount()==0){                               //判断数据库中是否已经设置了密码
                    pwdDAO.insert(pwd);                                 //添加用户密码
                }
                else {
                    pwdDAO.update(tb_pwd);                              //修改用户密码

                }*/
            }
        });

        btnsetCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                txtpwd.setText("");                                     //清空密码文本框
                txtpwd.setHint("请输入密码");                             //为密码文本框设置提示

            }
        });
    }
}
