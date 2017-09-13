package patrickstar.com.accountms;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import patrickstar.com.accountms.db.DBOpenHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* DBOpenHelper d=new DBOpenHelper(MainActivity.this); 创建数据库代码
        SQLiteDatabase sqLiteDatabase=d.getWritableDatabase();*/

    }
}
