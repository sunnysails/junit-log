package com.kaishengit.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.kaishengit.dao.BookDao;
import com.kaishengit.entity.Book;

import java.util.concurrent.TimeUnit;

/**
 * Created by sunny on 2016/12/14.
 */
public class BookServiceWithGuava {
    private static LoadingCache<String ,Book> cache = CacheBuilder
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
    }
}
