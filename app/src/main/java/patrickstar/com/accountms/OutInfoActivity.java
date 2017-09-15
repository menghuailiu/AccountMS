package patrickstar.com.accountms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import patrickstar.com.accountms.db.DBFlag;
import patrickstar.com.accountms.model.tb_flag;

public class OutInfoActivity extends AppCompatActivity {
    private Button save;
    private Button delete;
    private EditText flag;
    DBFlag dbFlag = new DBFlag(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_info);
        final String id = getIntent().getStringExtra("id");

        save = (Button) findViewById(R.id.btnsave);
        delete = (Button) findViewById(R.id.btndelete);
        flag = (EditText) findViewById(R.id.editflag);

        flag.setText("");


       /* tb_flag flag1 = new DBFlag(this).*/

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  if (dbFlag.deleteById(Integer.parseInt(id))) {
                    //删除成功


                }
                else{
                    //删除失败
                }*/
            }
        });*/

        Toast.makeText(OutInfoActivity.this,id,Toast.LENGTH_LONG).show();

    }
}
