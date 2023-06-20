package org.successor.domin;

import lombok.Data;

import java.io.Serializable;


/*
    class(BookType) 书籍类型实体类
    id: 书籍类型编号
    book_large_type： 主类型编号
    book_small_type: 子类型编号
    large_type_name: 主类型名称
    small_type_name: 子类型名称
 */
@Data
public class BookType implements Serializable{
    private int id;
    private int book_large_type;
    private int book_small_type;
    private String large_type_name;
    private String small_type_name;

    public BookType() {
    }

    public BookType(int id, int book_large_type, int book_small_type,
                    String large_type_name, String small_type_name) {
        this.id = id;
        this.book_large_type = book_large_type;
        this.book_small_type = book_small_type;
        this.large_type_name = large_type_name;
        this.small_type_name = small_type_name;
    }

}
