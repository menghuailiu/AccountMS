package patrickstar.com.accountms.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;
import greendao.gen.*;
import greendao.gen.DaoMaster;
import greendao.gen.DaoSession;

import patrickstar.com.accountms.model.tb_inaccount;

/**
 * Created by ios16 on 17/9/14.
 * 收入信息业务类
 */

public class DBInAcount {
    /**
     * 与greendao数据操作相关的几个类
     */

    public tb_inaccountDao inaccountDao;
    public Context context;
    public tb_inaccount inaccount;
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "account.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        inaccountDao=session.getTb_inaccountDao();
    }
    public DBInAcount(Context context1){
        context=context1;initDb();
        initDb();
    }


    /**
     * 新增收入信息
     * 需要传入一个 inaccount对象
     * @return  int 编号
     */
    public long add(tb_inaccount account)
    {
        long inaccountid=inaccountDao.insert(account);
        return inaccountid;
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
        bu.where(tb_inaccountDao.Properties.Id.eq(id));
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
    public  boolean deleteById(long id)
    {
        boolean bo=true;
        try {
            inaccountDao.deleteByKey(id);
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
            inaccountDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return bo;
    }

    /**
     * 获取最大id
     * @return
     */
    public long getMax(){
    long g=0;
    try {
        List<tb_inaccount> tb=inaccountDao.loadAll();
        int i=tb.size();
        tb_inaccount tbi=tb.get(i-1);
        g=tbi.getId();

    }catch (Exception e){return 0;}
    return g;
    }

    /**
     * 获取所有数据
     * @param start 开始位置
     * @param count 结束位置
     * @return 收入表的集合
     */
    public List<tb_inaccount> getScrollData(int start,int count)
    {
       return inaccountDao.queryBuilder().limit(count).list();

    }

    /**
     * 获取总记录数
     * @return int
     */
    public int getCount()
    {
        return inaccountDao.loadAll().size();
    }

    /**
     * 返回所有支出
     * @return long类型的支出
     */
    public long sum(){
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor=db.rawQuery("select sum(money) from tb_inaccount",null);
        while (cursor.moveToLast()){
            return cursor.getInt(0);
        }
        return 0;
    }
}
