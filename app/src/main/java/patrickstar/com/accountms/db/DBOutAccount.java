package patrickstar.com.accountms.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import greendao.gen.DaoMaster;
import greendao.gen.DaoSession;
import patrickstar.com.accountms.model.tb_inaccount;
import patrickstar.com.accountms.model.tb_outaccount;
import greendao.gen.*;
/**
 * Created by ios16 on 17/9/14.
 * 支出信息业务类
 *
 */

public class DBOutAccount {
    /**
     * 与greendao数据操作相关的几个类
     */

    public tb_outaccountDao outAccountDao;
    public Context context;
    public tb_outaccount outaccount;

    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "account.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        outAccountDao=session.getTb_outaccountDao();
    }
    public DBOutAccount(Context context1){
        context=context1;
        initDb();
    }


    /**
     * 新增支出信息
     * 需要传入一个 inaccount对象
     * @return  int 编号
     */
    public int add(tb_outaccount account)
    {
        long inaccountid=outAccountDao.insert(account);
        return Integer.parseInt(String.valueOf(inaccountid));
    }

    /**
     * 修改支出信息
     * @param account  便签对象
     * @return boolean 类型的数据
     */
    public boolean update(tb_outaccount account){

        if(account == null){
            return false;
        }
        outAccountDao.update(account);
        return true;
    }

    /**
     * 根据ID查询数据
     * @return tb_outAccountDao 支出对象
     */
    public tb_outaccount find(Long id)
    {
        org.greenrobot.greendao.query.QueryBuilder<tb_outaccount> bu=outAccountDao.queryBuilder();
        bu.where(tb_outaccountDao.Properties.Id.eq(id));
        tb_outaccount tb=null;
        try {
            tb=(tb_outaccount) bu.list().get(0);
        }
        catch (Exception ex)
        {
            return tb;
        }
        return tb;
    }

    /**
     * 查询所有支出信息
     * @return List<tb_outAccountDao> 支出信息的集合
     */
    public List<tb_outaccount> findAll()
    {
        return outAccountDao.loadAll();
    }




    /**
     * 根据id删除支出信息
     * @return boolean类型的数据
     */
    public  boolean deleteById(Long id)
    {
        boolean bo=true;
        try {
            outAccountDao.deleteByKey(id);
        }catch (Exception ex)
        {
            bo=false;
        }
        return bo;
    }



    /**
     * 删除所有数据
     * @return boolean 类型的数据
     */
    public boolean deleteAll()
    {
        boolean bo=true;
        try {
            outAccountDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return bo;
    }
    /**
     * 获取支出信息
     */
    public List<tb_outaccount> getScrollData(int start,int count){
/*        List<tb_outaccount> tboutaccount=new ArrayList<tb_outaccount>();//创建集合对象
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from tb_outaccount limit ?,?",
                new String[]{String.valueOf(start),
                String .valueOf(count)});
*//*        while (cursor.moveToNext()){
            tboutaccount.add(new tb_outaccount(cursor.getInt(cursor.getColumnIndex("_id")),
                    cursor.getDouble(cursor.getColumnIndex("money")),
                    cursor.getString(cursor.getColumnIndex("time")),
                    cursor.getString(cursor.getColumnIndex("type")),
                    cursor.getString(cursor.getColumnIndex("address")),
                    cursor.getString(cursor.getColumnIndex("mark"))));//将遍历到的支出信息添加到集合中

        }*//*
        return tboutaccount;//返回集合*/
        return outAccountDao.queryBuilder().limit(count).build().list();
    }
    /**
     * 获取记录数
     */

    public int getCount(){
        /*SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select count(_id) from tb_outaccount",null);//获取支出信息的记录数
        if(cursor.moveToNext()){
            return cursor.getLong(0);
        }*/
        int i=0;
        try{
            i=outAccountDao.loadAll().size();//如果没有数据，返回0
        }catch (Exception e){

        }
        return i;
    }
    /**
     * 获取最大编号
     */

    public int getMaxId(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select max(_id) from tb_outaccount",null);
        while (cursor.moveToLast()){
            return cursor.getInt(0);
        }
        return 0;
    }



}
