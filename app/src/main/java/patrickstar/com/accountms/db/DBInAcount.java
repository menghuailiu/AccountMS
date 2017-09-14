package patrickstar.com.accountms.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import patrickstar.com.accountms.dao.tb_inaccountDao;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by ios16 on 17/9/14.
 * 收入信息业务类
 */

public class DBInAcount {
    /**
     * 与greendao数据操作相关的几个类
     */
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster master;
    public DaoSession session;
    public tb_inaccountDao inaccountDao;
    public Context context;
    public tb_inaccount inaccount;

    public DBInAcount(Context context1){
        context=context1;
    }

    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "UserDB.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        inaccountDao = session.getTb_inaccountDao();
    }
    /**
     * 新增收入信息
     * 需要传入一个 inaccount对象
     * @return  int 编号
     */
    public int add(tb_inaccount account)
    {
        long inaccountid=inaccountDao.insert(account);
        return Integer.parseInt(String.valueOf(inaccountid));
    }

    /**
     * 修改收入信息
     * @param account  便签对象
     * @return boolean 类型的数据
     */
    public boolean update(tb_inaccount account){

        if(account == null){
            return false;
        }
        inaccountDao.update(account);
        return true;
    }

    /**
     * 根据ID查询数据
     * @return tb_inaccount 收入对象
     */
    public tb_inaccount find(int id)
    {
        QueryBuilder bu=inaccountDao.queryBuilder();
        bu.where(tb_inaccountDao.Properties._id.eq(id));
        tb_inaccount tb=null;
        try {
             tb=(tb_inaccount) bu.list().get(0);
        }
        catch (Exception ex)
                {
                    return tb;
                }
                return tb;
    }

    /**
     * 查询所有收入信息
     * @return List<tb_inaccount> 收入信息的集合
     */
    public List<tb_inaccount> findAll()
    {
        return inaccountDao.loadAll();
    }




    /**
     * 根据id删除收入信息
     * @return boolean类型的数据
     */
    public  boolean deleteById(int id)
    {
        boolean bo=true;
        try {
            inaccountDao.deleteByKey(id);
        }catch (Exception ex)
        {
            bo=false;
        }
        return false;
    }



    /**
     * 删除所有数据
     * @return boolean 类型的数据
     */
    public boolean deleteAll()
    {
        boolean bo=true;
        try {
            inaccountDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return false;
    }
    /**
     * 获取支出信息
     */
    public List<tb_inaccount> getScollData(int start, int count){
        List<tb_inaccount> tbinaccount= new ArrayList<>();//创建集合对象
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_inaccount limit ?,?",
                new String[]{String.valueOf(start),
                        String .valueOf(count)});
        while (cursor.moveToNext()){
            tbinaccount.add(new tb_inaccount(cursor.getInt(cursor.getColumnIndex("_id")),
                    cursor.getDouble(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getString(cursor.getColumnIndex("type")),
                    cursor.getString(cursor.getColumnIndex("handler")),
                    cursor.getString(cursor.getColumnIndex("mark"))));//将遍历到的支出信息添加到集合中

        }
        return tbinaccount;//返回集合
    }
    /**
     * 获取记录数
     */
    public long getCount(){
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select count(_id) from tb_inaccount",null);//获取支出信息的记录数
        if(cursor.moveToNext()){
            return cursor.getLong(0);
        }
        return 0;//如果没有数据，返回0
    }
    /**
     * 获取最大编号
     */
    public int getMaxId(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select max(_id) from tb_inaccount",null);
        while (cursor.moveToLast()){
            return cursor.getInt(0);
        }
        return 0;
    }

}
