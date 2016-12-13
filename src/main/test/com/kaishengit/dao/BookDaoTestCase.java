package com.kaishengit.dao;


import com.kaishengit.entity.Book;
import org.junit.Test;

/**
 * Created by sunny on 2016/12/13.
 */
public class BookDaoTestCase {

    @Test
    public void testSave(){
        BookDao bookDao = new BookDao();
        Book book = new Book();
        book.setName("张三说");
        book.setAuthor("张三");
        book.setNowNumber(100);
        book.setTotal(100);
        book.setIsbn("10007");

        bookDao.save(book);
    }
}
