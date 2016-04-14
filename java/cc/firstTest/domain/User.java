package cc.firstTest.domain;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by cheng on 2015/12/4 0004.
 */
@Entity
@Table(name = "user_info")
@Document(collection = "user")
public class User implements Serializable {
    @Id
    @Column(name = "uid")
    private String id;

    @Column
    private String name;

    @Column
    private  String account;

    @Column
    private String pwd;

    @Column
    private Date createDate;

    @Column
    private Boolean isDel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    public User() {
        this.isDel=false;
        this.createDate=new Date();
    }
}
