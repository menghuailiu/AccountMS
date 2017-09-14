package patrickstar.com.accountms;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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

                PwdDAO pwdDAO=new PwdDAO(Sysset.this);                  //创建PwdDAO对象
                Tb_pwd tb_pwd=new Tb_pwd(txtpwd.getText().toString());  //根据输入的密码创建Tb_pwd对象
                if(pwdDAO.getCount()==0){                               //判断数据库中是否已经设置了密码
                    pwdDAO.add(tb_pwd);                                 //添加用户密码
                }
                else {
                    pwdDAO.update(tb_pwd);                              //修改用户密码

                }

                //弹出信息提示
                Toast.makeText(Sysset.this,"［密码］设置成功！",Toast.LENGTH_SHORT).show();

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
