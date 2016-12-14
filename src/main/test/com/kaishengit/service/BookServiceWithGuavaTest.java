package com.kaishengit.service;

import com.kaishengit.entity.Book;
import org.junit.Test;

/**
 * Created by sunny on 2016/12/14.
 */
public class BookServiceWithGuavaTest {
    private BookServiceWithGuava bookService = new BookServiceWithGuava();

    @Test
    public void findById() throws Exception {
        Book book = bookService.findById(8);
        System.out.println(book);
        book = bookService.findById(8);

        System.out.println(book);
    }
}
