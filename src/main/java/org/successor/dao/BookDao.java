package org.successor.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.successor.domin.Book;

import java.util.List;



@Repository
public interface BookDao {

    Book queryById(long id);

    int queryNumberOfBooks();

    int queryNumberOfSomeTypeBooks(int largeType);

    int addBook(Book book);

    Book queryByTitle(String title);

    List<Book> getLargeTypeBooks(@Param("list") List<Integer> booTypeList,
                                 @Param("startRow") int starRow,
                                 @Param("pageSize") int pageSize);

    List<Book> getSmallTypeBooks(@Param("type_id") int type_id,
                                 @Param("startRow") int starRow,
                                 @Param("pageSize") int pageSize);

    int addDownloadTimes(long id);

    List<Book> queryByDownloadTimes();


    List<Book> searchBookByTitle(String searchTxt);

    List<Book> searchBookByAuthor(String searchTxt);

    int getTotalOfLTBooks(List<Integer> booTypeList);

    int getTotalOfSTBooks(int type_id);

    int deleteBook(long id);
}
