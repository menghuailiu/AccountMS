package patrickstar.com.accountms;

/**
 * Created by 静静 on 17/9/13.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xiaoke.accountsoft.activity.MainActivity;

import patrickstar.com.accountms.model.tb_pwd;

import patrickstar.com.accountms.db.DBOpenHelper;
import patrickstar.com.accountms.db.DBPwd;
import patrickstar.com.accountms.db.DBPwd;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        DBOpenHelper helper=new DBOpenHelper(Login.this);
        helper.getWritableDatabase();
        String str="";
        DBPwd dao=new DBPwd(Login.this);
        int count=dao.getCount();
        if(count<1){
            dao.insert("123456");
            Toast.makeText(Login.this,"初始密码为：123456",Toast.LENGTH_LONG);
        }
        final EditText txtlogin=(EditText)findViewById(R.id.txtLogin);  //获取密码文本框
        Button btnlogin=(Button)findViewById(R.id.btnLogin);            //获取"登录"按钮
        btnlogin.setOnClickListener(new View.OnClickListener() {        //为"登录"按钮设置监听事件
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,MainActivity.class);//创建Intent对象
                DBPwd pwdDAO=new DBPwd(Login.this);                   //创建PwdDAO对象

                //判断是否有密码及是否输入了密码
                if((pwdDAO.getCount()==0| pwdDAO.find().getPassword().isEmpty())&&
                        txtlogin.getText().toString().isEmpty()){
                    startActivity(intent);                              //启动主Activity
                }
                else {
                    //判断输入的密码是否与数据库中的密码一致
                    if(pwdDAO.find().getPassword().equals(txtlogin.getText().toString())){
                        startActivity(intent);                          //启动主Activity
                    }
                    else {
                        //弹出信息提示
                        Toast.makeText(Login.this,"请输入正确的密码",Toast.LENGTH_SHORT).show();
                    }
                }
                txtlogin.setText("");                                   //清空密码文本框

            }
        });
    }
}

