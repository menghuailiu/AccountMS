package patrickstar.com.accountms.db;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import greendao.gen.DaoMaster;
import greendao.gen.DaoSession;
import  patrickstar.com.accountms.model.*;
import greendao.gen.*;
/**
 * Created by ios16 on 17/9/13.
 * 用于对便签表的增删改操作
 *
 * ljm
 */
public class DBFlag {
    /**
     * 与greendao数据操作相关的几个类
     */

    public tb_flagDao flagDao;
    public Context context;
    public tb_flag flag;



    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "account.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        flagDao=session.getTb_flagDao();

    }
    public DBFlag(Context context1){
        context=context1;
        initDb();
    }
    /**
     * 新增便签信息
     * 需要传入一个 flad对象
     *
     * @return  int 编号
     */
    public int insert(tb_flag flag)
    {
        long flagid=flagDao.insert(flag);
        return Integer.parseInt(String.valueOf(flagid));
    }


    /**
     * 根据id删除便签
     * @return boolean类型的数据
     */
    public  boolean deleteById(Long id)
    {
        boolean bo=true;
        try {
            flagDao.deleteByKey(id);
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
            flagDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return bo;
    }

    /**
     * 修改便签
     * @param tbflag  便签对象
     * @return boolean 类型的数据
     */
    public boolean update(tb_flag tbflag){

        if(tbflag == null){
           return false;
        }
        flagDao.update(tbflag);
        return true;
    }

    /**
     * 查询所有便签信息
     * @return tb_flag的list的集合
     */
    public List<tb_flag> query(){
        List<tb_flag> flagList = flagDao.loadAll();
       return flagList;
    }


    /**
     * 根据ID查询数据
     * @return tb_flag 便签对象
     */
    public tb_flag find(int id)
    {
        tb_flag bu=null;
        try {

            bu = flagDao.queryBuilder().where(tb_flagDao.Properties.Id.eq(id)).build().list().get(0);
  /*      tb_flag tb=null;*/

           // tb=(tb_flag) bu.list().get(0);
        }
        catch (Exception ex)
        {
            return null;
        }
        return bu;
    }

    /**
     * 获取最大数据
     * @return
     */
    public  int getMax(){
    int i=0;
    try{
        i=flagDao.loadAll().size();
        List<tb_flag> tb=flagDao.loadAll();
        int j=tb.size();
        tb_flag tbi=tb.get(j-1);
        i=Integer.parseInt(String.valueOf(tbi.getId()));

    }catch (Exception ex){
            i=0;
    }
    return  i;
}
    /**
     * 相等查询,where参数中可以添加多个相等的条件
     *
     */
/*    public void queryEq(){
        tb_flag user = flagDao.queryBuilder()
                .where(flagDao.Properties.Flag.eq("admin")).unique();
    }*/


/*    public void queryLike(){
        List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.RealName.like("%lihy%")).list();
    }*/

/*    public void queryBetween(){
        //List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Age.between(0, 10)).list();
        List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Age.gt(10)).list();
        //gt:大于 lt:小于 ge:大于等于 le:小于等于

    }*/


}
