package com.kaishengit.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.kaishengit.dao.BookDao;
import com.kaishengit.entity.Book;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunny on 2016/12/14.
 */
public class BookServiceWithGuava {

    private BookDao bookDao = new BookDao();

    private static Cache<String ,Book> cache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterAccess(30,TimeUnit.SECONDS)
            .build();
    public Book findById(Integer id){
        Book book = null;
        try {
            book = cache.get("book:" + id, new Callable<Book>() {
                @Override
                public Book call() throws Exception {
                    return bookDao.findById(id);
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return book;
    }



/*    private static LoadingCache<String ,Book> cache = CacheBuilder
            .newBuilder()
            .maximumSize(100)
            .expireAfterAccess(50, TimeUnit.SECONDS)
            .build(new CacheLoader<String, Book>() {
                @Override
                public Book load(String s) throws Exception {
                    BookDao bookDao = new BookDao();
                    return bookDao.findById(Integer.valueOf(s));
                }
            });

    public Book findById(Integer id){
        Book book = cache.getUnchecked(id.toString());
        return book;
    }*/
}
