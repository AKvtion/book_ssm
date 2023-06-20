package org.successor.domin;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/*
    class(Book) 书籍实体类
    id: 书籍编号
    book_title: 书籍标题
    book_title: 书籍作者
    book_pubYear: 出版时间
    book_summary: 书籍摘要
    type_id: 类型编号
    book_format: 书籍格式
    download_times: 下载次数
    book_file: 书籍存储地址
    book_cover: 封面存储地址
 */
@Data
public class Book implements Serializable {
    private long id;
    private String book_title;
    private String book_author;
    private Date book_pubYear;
    private String book_summary;
    private int type_id;
    private String book_format;
    private int download_times;
    private String book_file;
    private String book_cover;

    public Book() {
    }

    public Book(long id, String book_title, String book_author, Date book_pubYear, String book_summary, int type_id, String book_format, int download_times, String book_file, String book_cover) {
        this.id = id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pubYear = book_pubYear;
        this.book_summary = book_summary;
        this.type_id = type_id;
        this.book_format = book_format;
        this.download_times = download_times;
        this.book_file = book_file;
        this.book_cover = book_cover;
    }


}
