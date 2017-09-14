package patrickstar.com.accountms.db;

import android.content.Context;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import patrickstar.com.accountms.dao.tb_outaccountDao;
import patrickstar.com.accountms.model.tb_outaccount;

/**
 * Created by ios16 on 17/9/14.
 * 支出信息业务类
 *
 */

public class DBOutAccount {
    /**
     * 与greendao数据操作相关的几个类
     */
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster master;
    public DaoSession session;
    public tb_outaccountDao outAccountDao;
    public Context context;
    public tb_outaccount outaccount;

    public DBOutAccount(Context context1){
        context=context1;
    }

    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "UserDB.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        outAccountDao = session.getTb_outaccountDao();
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
    public tb_outaccount find(int id)
    {
        QueryBuilder bu=outAccountDao.queryBuilder();
        bu.where(tb_outaccountDao.Properties._id.eq(id));
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
    public  boolean deleteById(int id)
    {
        boolean bo=true;
        try {
            outAccountDao.deleteByKey(id);
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
            outAccountDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return false;
    }


}
