package org.successor.domin;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/*
    class(Upload) 上传信息实体类
    id： 编号
    uploader: 上传用户id
    uploadedBook: 上传书籍id
    uploadedDate: 上传日期
 */
@Data
public class Upload implements Serializable{
    private int id;
    private long uploader;
    private long uploadedBook;
    private Date uploadedDate;

    public Upload() {
    }

    public Upload(int id, long uploader, long uploadedBook, Date uploadedDate) {
        this.id = id;
        this.uploader = uploader;
        this.uploadedBook = uploadedBook;
        this.uploadedDate = uploadedDate;
    }

}
