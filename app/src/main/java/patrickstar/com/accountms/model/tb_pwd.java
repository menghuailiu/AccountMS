package patrickstar.com.accountms.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Entity mapped to table "TB_PWD".
 */
@Entity
public class tb_pwd {
    @Id
    private Long id;
    private String password;
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1067139173)
    public tb_pwd(Long id, String password) {
        this.id = id;
        this.password = password;
    }
    @Generated(hash = 1420980386)
    public tb_pwd() {
    }

    public tb_pwd(String password) {
        this.password = password;
    }
}
