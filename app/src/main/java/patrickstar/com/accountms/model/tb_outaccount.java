package patrickstar.com.accountms.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Entity mapped to table "TB_OUTACCOUNT".
 */
@Entity
public class tb_outaccount {
    @Id
    private Long id;
    private Double money;
    private String time;
    private String type;
    private String address;
    private String mark;
    public String getMark() {
        return this.mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public Double getMoney() {
        return this.money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 431014543)
    public tb_outaccount(Long id, Double money, String time, String type, String address, String mark) {
        this.id = id;
        this.money = money;
        this.time = time;
        this.type = type;
        this.address = address;
        this.mark = mark;
    }
    @Generated(hash = 259043096)
    public tb_outaccount() {
    }

}
