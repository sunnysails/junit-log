package com.kaishengit.dao;


import com.kaishengit.entity.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by sunny on 2016/12/13.
 */
public class BookDaoTestCase {

    private BookDao bookDao;
    @Before
    public void before(){
        bookDao = new BookDao();
    }

    @Test
    public void testFindById() throws Exception {
        Book book = bookDao.findById(6);

        assertNotNull(book);
    }

    @Test
    public void testSave(){

        Book book = new Book();
        book.setName("张三说");
        book.setAuthor("张三");
        book.setNowNumber(100);
        book.setTotal(100);
        book.setIsbn("10007");

        bookDao.save(book);
    }
}
