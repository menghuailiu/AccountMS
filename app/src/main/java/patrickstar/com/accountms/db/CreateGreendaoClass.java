package patrickstar.com.accountms.db;


import org.greenrobot.greendao.annotation.Entity;

import java.io.IOException;

import javax.xml.validation.Schema;
import javax.xml.validation.Validator;
import javax.xml.validation.ValidatorHandler;





/**
 * Created by ios16 on 17/9/13.
 * 用于编写创建greendao之前的准备高规格
 */

public class CreateGreendaoClass {
    public static void main(String arg[])
    {
/*
        Schema mySchema = new Schema(1, "patrickstar.com.accountms");//Schema一般为数据库对象的集合
        org.greenrobot.greendao.generator.Entity UserInfo = mySchema.addEntity("tb_flag");//创建一个标签表
        UserInfo.addIntProperty("_id").primaryKey();
        UserInfo.addStringProperty("flag");

        Entity inaccount = mySchema.addEntity("tb_inaccount");//创建一个收入表
        inaccount.addIntProperty("_id").primaryKey();
        inaccount.addDoubleProperty("money");//收入金额
        inaccount.addStringProperty("time");//收入时间
        inaccount.addStringProperty("type");//收入类别
        inaccount.addStringProperty("handler");//付款方
        inaccount.addStringProperty("mark");//备注

        Entity outaccount = mySchema.addEntity("tb_outaccount");//创建一个支出表
        outaccount.addIntProperty("_id").primaryKey();
        outaccount.addDoubleProperty("money");//支出金额
        outaccount.addStringProperty("time");//支出时间
        outaccount.addStringProperty("type");//支出类别
        outaccount.addStringProperty("address");//支出地点
        outaccount.addStringProperty("mark");//备注

        Entity tbpwd = mySchema.addEntity("tb_pwd");//创建一个密码表
        UserInfo.addStringProperty("password");
        try {
            //运行该句代码将生成指定实体所对应的greendao相关操作类
            new DaoGenerator().generateAll(mySchema, "/Users/ios16/Desktop/greendao");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
       /* Schema mySchema = new Schema(1, "com.patrickstar.onetomanygreendao");
        //学生实体
        Entity Student = mySchema.addEntity("Student");
        Student.addStringProperty("stuNO").primaryKey();//添加字段同时指定为主键
        Student.addStringProperty("stuName");
        Student.addLongProperty("classId");
        //班级实体
        Entity ClassInfo = mySchema.addEntity("ClassInfo");
        ClassInfo.addLongProperty("classId").primaryKey();
        ClassInfo.addStringProperty("className");
        ClassInfo.addStringProperty("grade");
        //指定班级与学生之间的一对多关系
        //指定classId为外键关联ClassInfo
        Student.addToOne(ClassInfo,Student.getProperties().get(2));
        //指定一个班级中存在多个学生
        ClassInfo.addToMany(Student, Student.getProperties().get(2)).setName("stuList");

        try {
            //运行该句代码将生成指定实体所对应的greendao相关操作类
            new DaoGenerator().generateAll(mySchema, "/users/admin/desktop/greenDao/ontomany");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
