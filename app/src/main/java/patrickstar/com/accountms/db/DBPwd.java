package patrickstar.com.accountms.db;

import android.content.Context;

import java.util.List;

import patrickstar.com.accountms.dao.tb_pwdDao;
import patrickstar.com.accountms.model.tb_pwd;

/**
 * Created by ios16 on 17/9/13.
 * 密码表的业务类
 *
 */

public class DBPwd {
    /**
     * 与greendao数据操作相关的几个类
     */
    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    private tb_pwdDao pwdDao;
    private Context context;
    private tb_pwd pwd;

    public DBPwd(Context context1){
        context=context1;
    }

    private void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "account.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        pwdDao = session.getTb_pwdDao();
    }

    /**
     * 新增密码
     * 需要传入一个 pwd对象
     * @return  int 编号
     */
    public int insert(tb_pwd pwd)
    {
        long pwdid=pwdDao.insert(pwd);
        return Integer.parseInt(String.valueOf(pwdid));
    }


    /**
     * 删除所有数据
     * @return boolean 类型的数据
     */
    public boolean deleteAll()
    {
        boolean bo=true;
        try {
            pwdDao.deleteAll();
        }catch (Exception ex)
        {
            bo=false;
        }
        return false;
    }

    /**
     * 修改密码
     * @param tbpwd  便签对象
     * @return boolean 类型的数据
     */
    private boolean update(tb_pwd tbpwd){

        if(tbpwd == null){
            return false;
        }
        pwdDao.update(tbpwd);
        return true;
    }



}
