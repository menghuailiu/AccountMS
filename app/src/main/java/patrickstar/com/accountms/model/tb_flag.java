package patrickstar.com.accountms.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Entity mapped to table "TB_FLAG".
 */
@Entity
public class tb_flag {
    @Id
    private Long id;
    private String flag;
    private String password;
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFlag() {
        return this.flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 717539150)
    public tb_flag(Long id, String flag, String password) {
        this.id = id;
        this.flag = flag;
        this.password = password;
    }
    @Generated(hash = 1694295426)
    public tb_flag() {
    }
}
