package patrickstar.com.accountms.db;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import patrickstar.com.accountms.MainActivity;
import  patrickstar.com.accountms.model.*;
import patrickstar.com.accountms.dao.tb_flagDao;
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
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    private tb_flagDao flagDao;
    private Context context;
    private tb_flag flag;

    public DBFlag(Context context1){
        context=context1;
    }

    private void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "UserDB.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        flagDao = session.getTb_flagDao();
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
    public  boolean deleteById(int id)
    {
        boolean bo=true;
        try {
            flagDao.deleteByKey(id);
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
            flagDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return false;
    }

    /**
     * 修改便签
     * @param tbflag  便签对象
     * @return boolean 类型的数据
     */
    private boolean update(tb_flag tbflag){

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
    private List<tb_flag> query(){
        List<tb_flag> flagList = flagDao.loadAll();
       return flagList;
    }

    public void getxx(){

    }


    /**
     * 相等查询,where参数中可以添加多个相等的条件
     *
     */
/*    private void queryEq(){
        tb_flag user = flagDao.queryBuilder()
                .where(flagDao.Properties.Flag.eq("admin")).unique();
    }*/


/*    private void queryLike(){
        List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.RealName.like("%lihy%")).list();
    }*/

/*    private void queryBetween(){
        //List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Age.between(0, 10)).list();
        List<UserInfo> userList = userInfoDao.queryBuilder().where(UserInfoDao.Properties.Age.gt(10)).list();
        //gt:大于 lt:小于 ge:大于等于 le:小于等于

    }*/


}
