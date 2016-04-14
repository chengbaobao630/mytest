package cc.firstTest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by cheng on 2016/1/6 0006.
 */
@Entity
public class ResourceInfo {
    @Id
    private  String id;

    private  String name;

    private  String path;

    private  Long size;

    private  String type;

    private  String uploadUser;

    private Date createDate;

    private  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ResourceInfo() {
        this.createDate=new Date();
    }
}
