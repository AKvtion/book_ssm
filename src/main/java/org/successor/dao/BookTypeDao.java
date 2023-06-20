package org.successor.dao;

import org.successor.domin.BookType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookTypeDao {

    /**
     * 通过id查询图书类型
     * @param id
     * @return
     */
    BookType queryById(int id);

    /**
     * 通过主分类下的图书类型
     * @param largeTypeName
     * @return
     */
    List<BookType> queryByLargeTypeName(String largeTypeName);
}
