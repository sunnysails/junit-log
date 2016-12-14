package com.kaishengit.dao;


import com.kaishengit.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
        book.setName("李四说");
        book.setAuthor("李讲");
        book.setNowNumber(100);
        book.setTotal(100);
        book.setIsbn("10008");

        bookDao.save(book);
    }
    @Test
    public void testFindAll() {
        List<Book> userList = bookDao.findAll();
        assertEquals(10,userList.size());
    }

    @Test
    public void testDel() {
        bookDao.del(2);
    }
}
