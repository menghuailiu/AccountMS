package patrickstar.com.accountms.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ios16 on 17/9/13.
 * 创建数据库
 * anthor:ljm
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;//设置版本号
    private static final String DBNAME="account.db";//定义数据库名称

    public DBOpenHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

  /*  public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }*/

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //创建数据库，第一次执行的时候运行
        String str1="create table tb_outaccount(_id integer primarykey key,money decimal,time varchar(10),type varchar(10),address varchar(100),mark varchar(200))";//创建支出信息表

        String str2=" create table tb_inaccount(_id integer primary key ,money decimal,time varchar(10),type varchar(10),handler varchar(100),mark varchar(200))";//创建收入信息表

        String str3="create table tb_pwd(password varhcar(20)) ";

        String str4="create table tb_flag(_id integer primary key,flag varchar(200))";//创建便签信息表
        sqLiteDatabase.execSQL(str1);
        sqLiteDatabase.execSQL(str2);
        sqLiteDatabase.execSQL(str3);
        sqLiteDatabase.execSQL(str4);

    }

    //覆写基类的onUpdate方法，以便数据库版本更新
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//这是如果已经创建了数据库，那就把要修改数据库的代码写在这里
        String str3="create table tb_pwd(id integer primary key ,password varhcar(20)) ";
        sqLiteDatabase.execSQL(str3);
    }
}
