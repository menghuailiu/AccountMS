package patrickstar.com.accountms.db;

import android.content.Context;

import patrickstar.com.accountms.model.tb_pwd;
import greendao.gen.*;
/**
 * Created by ios16 on 17/9/13.
 * 密码表的业务类
 *
 */

public class DBPwd {
    /**
     * 与greendao数据操作相关的几个类
     */

    private tb_pwdDao pwdDao;
    private Context context;
    private tb_pwd pwd;

    private DaoMaster.DevOpenHelper helper;
    private DaoMaster master;
    private DaoSession session;
    public void initDb(){
        helper = new DaoMaster.DevOpenHelper(context, "account.db", null);
        master = new DaoMaster(helper.getWritableDatabase());
        session = master.newSession();
        pwdDao=session.getTb_pwdDao();
    }
    public DBPwd(Context context1){
        context=context1;
        initDb();
    }




    /**
     * 新增密码
     * 需要传入一个 pwd字符串
     * @return  int 编号
     */
    public int insert(String pwd)
    {
        tb_pwd pwd1 =new tb_pwd();
        int i=0;
        try{
            i=pwdDao.loadAll().size();
            if(i>0){
                pwdDao.deleteAll();
            }
            i=1;
        }catch (Exception ex)
        {
            i=1;
        }
        pwd1.setPassword(pwd);
        pwd1.setId(Long.parseLong(String.valueOf(i)));
        long pwdid=pwdDao.insert(pwd1);
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
    public boolean update(tb_pwd tbpwd){

        if(tbpwd == null){
            return false;
        }
        pwdDao.update(tbpwd);
        return true;
    }

    /**
     * 获取密码数量
     * 返回数量
     */
    public  int getCount()
    {
        return pwdDao.loadAll().size();
    }

    /**
     * 查询密码
     * @return 密码对象
     */
    public tb_pwd find(){
        tb_pwd pwd=pwdDao.loadAll().get(0);
        return pwd;
    }

    /**
     * 获取密码对象
     * @return 密码对象
     */
    public tb_pwd getpwd()
    {
        tb_pwd p=new tb_pwd();
        p=pwdDao.loadAll().get(0);
        return p;
    }
}
